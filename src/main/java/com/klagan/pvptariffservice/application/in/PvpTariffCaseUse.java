package com.klagan.pvptariffservice.application.in;

import com.klagan.pvptariffservice.application.mappers.TariffPriceDTO;
import com.klagan.pvptariffservice.domain.models.Tariff;

import java.util.Date;
import java.util.Optional;

public interface PvpTariffCaseUse {
    Optional<TariffPriceDTO> pvpTariff(Date date, Long idProduct, Long idStore);
}
