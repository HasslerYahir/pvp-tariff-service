package com.klagan.pvptariffservice.domain.services;

import com.klagan.pvptariffservice.application.out.PvpTariffPersistence;
import com.klagan.pvptariffservice.domain.models.Tariff;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Optional;


public class PvpTariffService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final PvpTariffPersistence pvpTariffPersistence;

    public PvpTariffService(PvpTariffPersistence pvpTariffPersistence) {
        this.pvpTariffPersistence = pvpTariffPersistence;
    }
    public Optional<Tariff> findPvpTariff(Date date, Long idProduct, Long idStore){
        log.info("Start query find pvp tariff date {} id product {} bran id {} ",date,idProduct,idStore);
        return pvpTariffPersistence.findPvpTariff(date, idProduct, idStore);
    }
}
