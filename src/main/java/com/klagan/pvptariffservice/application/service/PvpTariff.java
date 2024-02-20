package com.klagan.pvptariffservice.application.service;

import com.klagan.pvptariffservice.application.in.PvpTariffCaseUse;
import com.klagan.pvptariffservice.application.mappers.TariffPriceDTO;
import com.klagan.pvptariffservice.domain.services.PvpTariffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class PvpTariff implements PvpTariffCaseUse {
    private final PvpTariffService pvpTariffService;
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final SimpleDateFormat FORMAT_DATE =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public PvpTariff(PvpTariffService pvpTariffService) {
        this.pvpTariffService = pvpTariffService;
    }

    @Override
    public Optional<TariffPriceDTO> pvpTariff(Date date, Long idProduct, Long idStore) {
        log.info("Start find pvp tariff date {} id product {} bran id {} ",date,idProduct,idStore);
        return pvpTariffService.findPvpTariff(date, idProduct, idStore)
          .map(tariff -> new TariffPriceDTO(
            tariff.getProductId(),
            tariff.getBrandId(),
            tariff.getPriority(),
            FORMAT_DATE.format(tariff.getStartDate()),
            FORMAT_DATE.format(tariff.getEndDate()),
            tariff.getPrice()
          ));
    }
}
