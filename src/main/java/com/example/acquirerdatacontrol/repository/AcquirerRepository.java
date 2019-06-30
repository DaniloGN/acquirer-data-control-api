package com.example.acquirerdatacontrol.repository;

import com.example.acquirerdatacontrol.model.Acquirer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcquirerRepository extends JpaRepository<Acquirer, Long> {}