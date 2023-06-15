package com.finalmas.app.service;


import com.finalmas.app.model.Policy;
import com.finalmas.app.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {
    private final PolicyRepository policyRepository;

    @Autowired
    public MainService(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    public List<Policy> findAllPolicies(){
        return policyRepository.findAll();
    }
}
