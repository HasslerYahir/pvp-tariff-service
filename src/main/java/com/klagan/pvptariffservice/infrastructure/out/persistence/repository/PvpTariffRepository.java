package com.klagan.pvptariffservice.infrastructure.out.persistence.repository;


import com.klagan.pvptariffservice.infrastructure.out.persistence.entity.PvpTariffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PvpTariffRepository extends JpaRepository<PvpTariffEntity,Long> {
    @Query("SELECT p FROM PvpTariffEntity p " +
      "WHERE :specificDate BETWEEN p.startDate AND p.endDate " +
      "AND p.productId = :productId " +
      "AND p.brandId.id = :brandId " +
      "ORDER BY p.priority DESC")
    List<PvpTariffEntity> pvpTariffPrices(
      @Param("specificDate") Date specificDate,
      @Param("productId") Long productId,
      @Param("brandId") Long brandId
    );
}
