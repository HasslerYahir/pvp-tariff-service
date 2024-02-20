package com.klagan.pvptariffservice.infrastructure.out.persistence.mapper;

import com.klagan.pvptariffservice.application.service.PvpTariff;
import com.klagan.pvptariffservice.domain.models.Tariff;
import com.klagan.pvptariffservice.infrastructure.out.persistence.entity.BrandEntity;
import com.klagan.pvptariffservice.infrastructure.out.persistence.entity.PvpTariffEntity;

import java.util.Optional;

public class PvpTariffMapper {
    private PvpTariffMapper() {

    }

    public static Tariff toModel(PvpTariffEntity pvpTariffEntity) {
        return new Tariff.Builder()
          .brandId(Optional.of(pvpTariffEntity)
            .map(PvpTariffEntity::getBrandId)
            .map(BrandEntity::getId)
            .orElse(0L))
          .curr(pvpTariffEntity.getCurr())
          .endDate(pvpTariffEntity.getEndDate())
          .startDate(pvpTariffEntity.getStartDate())
          .price(pvpTariffEntity.getPrice())
          .priceList(pvpTariffEntity.getPriceList())
          .productId(pvpTariffEntity.getProductId())
          .priority(pvpTariffEntity.getPriority())
          .build();
    }
}
