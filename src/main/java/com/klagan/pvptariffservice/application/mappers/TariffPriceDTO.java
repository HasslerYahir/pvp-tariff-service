package com.klagan.pvptariffservice.application.mappers;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class TariffPriceDTO {
    private Long productId;
    private Long brandId;
    private Integer priority;

    private String startDate;

    private String endDate;

    private BigDecimal price;

    public TariffPriceDTO(Long productId, Long brandId, Integer priority, String startDate, String endDate, BigDecimal price) {
        this.productId = productId;
        this.brandId = brandId;
        this.priority = priority;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public TariffPriceDTO() {
    }

    public Long getProductId() {
        return productId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public Integer getPriority() {
        return priority;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
