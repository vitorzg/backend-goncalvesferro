package com.api.goncalvesrep.orcamentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.goncalvesrep.orcamentos.models.ProductModel;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, UUID> {
}
