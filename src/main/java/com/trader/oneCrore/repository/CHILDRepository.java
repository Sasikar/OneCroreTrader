package com.trader.oneCrore.repository;


import com.trader.oneCrore.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CHILDRepository extends JpaRepository<Child, Void>, JpaSpecificationExecutor<Child> {

}