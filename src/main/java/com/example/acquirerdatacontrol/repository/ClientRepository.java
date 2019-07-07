package com.example.acquirerdatacontrol.repository;

import com.example.acquirerdatacontrol.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {}