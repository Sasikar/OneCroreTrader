package com.trader.oneCrore.repository;


import com.trader.oneCrore.entity.Child;
import oracle.sql.TIMESTAMP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;


public interface CHILDRepository extends JpaRepository<Child, Void>, JpaSpecificationExecutor<Child> {

    public List<Child> findBySuperBuyGreaterThanAndCreationDateGreaterThan(String no, Timestamp timestamp);

    public List<Child> findBySasiBuyNotAndCreationDateGreaterThan(String no, Timestamp timestamp);

    public List<Child> findByGoldenBuyNotAndCreationDateGreaterThan(String no, Timestamp timestamp);

    @Transactional
    @Modifying
    @Query("update Child c set c.percentage= :percentage where c.Symbol=:symbolName and c.creationDate = :timeStamp")
    void updatePercentage(String symbolName, Timestamp timeStamp, String percentage);

}