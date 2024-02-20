package com.klagan.pvptariffservice.infrastructure.in.rest;

import com.klagan.pvptariffservice.application.mappers.TariffPriceDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PvpTariffIntegrationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testRequestAt10AMOnDay14() {
        assertPvpTariffResponse("/api/v1/pvp-tariff-service?date=2020-06-14T10:00:00&product=35455&brand=1",
          1, "2020-06-14 00:00:00", "2020-12-31 23:59:59", 1, 35455L, 0, new BigDecimal("35.50"), "EUR");
    }

    @Test
    public void testRequestAt16PMOnDay14() {
        assertPvpTariffResponse("/api/v1/pvp-tariff-service?date=2020-06-14T16:00:00&product=35455&brand=1",
          1, "2020-06-14 15:00:00", "2020-06-14 18:30:00", 2, 35455L, 1, new BigDecimal("25.45"), "EUR");
    }

    @Test
    public void testRequestAt21PMOnDay14() {
        assertPvpTariffResponse("/api/v1/pvp-tariff-service?date=2020-06-14T21:00:00&product=35455&brand=1",
          1, "2020-06-14 00:00:00", "2020-12-31 23:59:59", 1, 35455L, 0, new BigDecimal("35.50"), "EUR");
    }

    @Test
    public void testRequestAt10AMOnDay15() {
        assertPvpTariffResponse("/api/v1/pvp-tariff-service?date=2020-06-15T10:00:00&product=35455&brand=1",
          1, "2020-06-15 00:00:00", "2020-06-15 11:00:00", 3, 35455L, 1, new BigDecimal("30.50"), "EUR");
    }

    @Test
    public void testRequestAt21PMOnDay16() {
        assertPvpTariffResponse("/api/v1/pvp-tariff-service?date=2020-06-16T21:00:00&product=35455&brand=1",
          1, "2020-06-15 16:00:00", "2020-12-31 23:59:59", 4, 35455L, 1, new BigDecimal("38.95"), "EUR");
    }

    private void assertPvpTariffResponse(String url, int expectedBrandId, String expectedStartDate,
                                         String expectedEndDate, int expectedPriceList, long expectedProductId,
                                         int expectedPriority, BigDecimal expectedPrice, String expectedCurrency) {
        ResponseEntity<TariffPriceDTO> response = restTemplate.getForEntity(url, TariffPriceDTO.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(Objects.requireNonNull(response.getBody()).getBrandId()).isEqualTo(expectedBrandId);
        assertThat(response.getBody().getStartDate()).isEqualTo(expectedStartDate);
        assertThat(response.getBody().getEndDate()).isEqualTo(expectedEndDate);
        assertThat(response.getBody().getProductId()).isEqualTo(expectedProductId);
        assertThat(response.getBody().getPriority()).isEqualTo(expectedPriority);
        assertThat(response.getBody().getPrice()).isEqualTo(expectedPrice);
    }
}
