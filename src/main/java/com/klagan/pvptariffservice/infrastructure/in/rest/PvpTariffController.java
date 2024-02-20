package com.klagan.pvptariffservice.infrastructure.in.rest;

import com.klagan.pvptariffservice.application.in.PvpTariffCaseUse;
import com.klagan.pvptariffservice.utils.DateParse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pvp-tariff-service")
public class PvpTariffController {
    private final PvpTariffCaseUse pvpTariffCaseUse;
    private final Logger log = LoggerFactory.getLogger(this.getClass());


    public PvpTariffController(PvpTariffCaseUse pvpTariffCaseUse) {
        this.pvpTariffCaseUse = pvpTariffCaseUse;
    }

    @GetMapping
    public ResponseEntity<?> findByPriceTariff(@RequestParam("date") String date,
                                               @RequestParam("product") Long product,
                                               @RequestParam("brand") Long brand) {
        log.info("find by price tariff in controller date: {} product: {} brand:{}", date, product, brand);
        return DateParse.toDate(date)
          .map(
            toDate -> ResponseEntity.ofNullable(pvpTariffCaseUse.pvpTariff(toDate, product, brand)))
          .orElse(ResponseEntity.badRequest().build());
    }
}
