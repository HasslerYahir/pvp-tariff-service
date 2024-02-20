package com.klagan.pvptariffservice.application.out;

import com.klagan.pvptariffservice.domain.models.Tariff;

import java.util.Date;
import java.util.Optional;

public interface PvpTariffPersistence {
    Optional<Tariff> findPvpTariff(Date date, Long idProduct, Long idStore);
}
