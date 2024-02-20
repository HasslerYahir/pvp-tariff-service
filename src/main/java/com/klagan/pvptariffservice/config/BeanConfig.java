package com.klagan.pvptariffservice.config;

import com.klagan.pvptariffservice.application.in.PvpTariffCaseUse;
import com.klagan.pvptariffservice.application.out.PvpTariffPersistence;
import com.klagan.pvptariffservice.application.service.PvpTariff;
import com.klagan.pvptariffservice.domain.services.PvpTariffService;
import com.klagan.pvptariffservice.infrastructure.out.persistence.PvpTariffPersistenceHibernate;
import com.klagan.pvptariffservice.infrastructure.out.persistence.repository.PvpTariffRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public PvpTariffPersistence pvpTariffPersistence(PvpTariffRepository pvpTariffRepository) {
        return new PvpTariffPersistenceHibernate(pvpTariffRepository);
    }
    @Bean
    public PvpTariffService pvpTariffService(PvpTariffPersistence pvpTariffPersistence){
        return new PvpTariffService(pvpTariffPersistence);
    }
    @Bean
    public PvpTariffCaseUse pvpTariffCaseUse(PvpTariffService pvpTariffService){
        return new PvpTariff(pvpTariffService);
    }
}
