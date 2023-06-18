package com.finalmas.app.repository;

import com.finalmas.app.model.InsurancePackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsurancePackageRepository extends JpaRepository<InsurancePackage, Long> {

    boolean existsByName(String name);

}
