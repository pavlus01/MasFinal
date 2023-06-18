package com.finalmas.app.service;


import com.finalmas.app.model.Client;
import com.finalmas.app.model.Policy;
import com.finalmas.app.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {
    private final PolicyRepository policyRepository;
    private final InsurancePackageRepository insurancePackageRepository;
    private final PackagedPolicyRepository packagedPolicyRepository;
    private final BoughtPolicyRepository boughtPolicyRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public MainService(PolicyRepository policyRepository, InsurancePackageRepository insurancePackageRepository, PackagedPolicyRepository packagedPolicyRepository, BoughtPolicyRepository boughtPolicyRepository, ClientRepository clientRepository) {
        this.policyRepository = policyRepository;
        this.insurancePackageRepository = insurancePackageRepository;
        this.packagedPolicyRepository = packagedPolicyRepository;
        this.boughtPolicyRepository = boughtPolicyRepository;
        this.clientRepository = clientRepository;
    }

    public List<Policy> findAllPolicies(){
        return policyRepository.findAll();
    }

    public boolean existsByName(String name) {return insurancePackageRepository.existsByName(name);}

    public Client getClientByClientId(int id){return clientRepository.getClientByClientId(id);}
}
