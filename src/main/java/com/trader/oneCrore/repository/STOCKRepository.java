package com.trader.oneCrore.repository;


import com.trader.oneCrore.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface STOCKRepository extends JpaRepository<Stock, String>, JpaSpecificationExecutor<Stock> {

}