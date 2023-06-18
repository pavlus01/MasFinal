package com.finalmas.app.repository;

import com.finalmas.app.model.PackagedPolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackagedPolicyRepository extends JpaRepository<PackagedPolicy, Long> {
}
