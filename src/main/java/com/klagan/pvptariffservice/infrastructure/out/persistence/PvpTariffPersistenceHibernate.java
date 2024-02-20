package com.klagan.pvptariffservice.infrastructure.out.persistence;

import com.klagan.pvptariffservice.application.out.PvpTariffPersistence;
import com.klagan.pvptariffservice.domain.models.Tariff;
import com.klagan.pvptariffservice.infrastructure.out.persistence.mapper.PvpTariffMapper;
import com.klagan.pvptariffservice.infrastructure.out.persistence.repository.PvpTariffRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.Date;
import java.util.Optional;

public class PvpTariffPersistenceHibernate implements PvpTariffPersistence {
    private final PvpTariffRepository pvpTariffRepository;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public PvpTariffPersistenceHibernate(PvpTariffRepository pvpTariffRepository) {
        this.pvpTariffRepository = pvpTariffRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Tariff> findPvpTariff(Date date, Long idProduct, Long idStore) {
        return pvpTariffRepository.pvpTariffPrices(date, idProduct, idStore)
          .stream().map(
            pr-> {
                log.info("Start transform to model {} date {}",pr.getPriority(),pr.getStartDate());
                return PvpTariffMapper.toModel(pr);
            }
          )
          .max(Comparator.comparing(Tariff::getPriority));
    }
}
