package com.klagan.pvptariffservice.domain.models;

import java.math.BigDecimal;
import java.util.Date;

public class Tariff {
    private Long brandId;
    private Date startDate;
    private Date endDate;
    private Long priceList;
    private Long productId;
    private Integer priority;
    private BigDecimal price;
    private String curr;

    private Tariff(Builder builder) {
        this.brandId = builder.brandId;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.priceList = builder.priceList;
        this.productId = builder.productId;
        this.priority = builder.priority;
        this.price = builder.price;
        this.curr = builder.curr;
    }

    public Long getBrandId() {
        return brandId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Long getPriceList() {
        return priceList;
    }

    public Long getProductId() {
        return productId;
    }

    public Integer getPriority() {
        return priority;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurr() {
        return curr;
    }

    public static class Builder {
        private Long brandId;
        private Date startDate;
        private Date endDate;
        private Long priceList;
        private Long productId;
        private Integer priority;
        private BigDecimal price;
        private String curr;

        public Builder brandId(Long brandId) {
            this.brandId = brandId;
            return this;
        }

        public Builder startDate(Date startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(Date endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder priceList(Long priceList) {
            this.priceList = priceList;
            return this;
        }

        public Builder productId(Long productId) {
            this.productId = productId;
            return this;
        }

        public Builder priority(Integer priority) {
            this.priority = priority;
            return this;
        }

        public Builder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder curr(String curr) {
            this.curr = curr;
            return this;
        }

        public Tariff build() {
            return new Tariff(this);
        }
    }

}
