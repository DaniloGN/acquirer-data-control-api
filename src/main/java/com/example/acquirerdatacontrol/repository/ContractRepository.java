package com.example.acquirerdatacontrol.repository;

import com.example.acquirerdatacontrol.model.Contract;
import com.example.acquirerdatacontrol.model.ContractKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, ContractKey> {}