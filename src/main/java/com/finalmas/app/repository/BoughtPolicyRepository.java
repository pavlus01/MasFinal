package com.finalmas.app.repository;

import com.finalmas.app.model.BoughtPolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoughtPolicyRepository extends JpaRepository<BoughtPolicy, Long> {
}
