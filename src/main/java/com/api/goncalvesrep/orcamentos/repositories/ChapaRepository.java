package com.api.goncalvesrep.orcamentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.goncalvesrep.orcamentos.models.ChapaModel;

import java.util.UUID;

@Repository
public interface ChapaRepository extends JpaRepository<ChapaModel, UUID> {
}
