package com.api.goncalvesrep.orcamentos.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "TB_CHAPA")
@Data
@NoArgsConstructor
public class ChapaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Price per kg is mandatory")
    private Float pricekg;
}
