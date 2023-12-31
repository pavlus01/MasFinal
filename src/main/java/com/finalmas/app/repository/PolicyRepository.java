package com.finalmas.app.repository;

import com.finalmas.app.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {
}
