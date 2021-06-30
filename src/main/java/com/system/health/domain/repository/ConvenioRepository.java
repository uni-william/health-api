package com.system.health.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.health.domain.model.Convenio;

@Repository
public interface ConvenioRepository extends JpaRepository<Convenio, Long> {

}
