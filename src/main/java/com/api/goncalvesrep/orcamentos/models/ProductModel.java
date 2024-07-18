package com.api.goncalvesrep.orcamentos.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_PRODUCTS")
@Data
@NoArgsConstructor
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @NotBlank
    private String name;

    @NotNull
    private float meters;

    @Column(columnDefinition = "boolean default false")
    private boolean isBar = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chapa_id")
    @JsonIgnore
    private ChapaModel chapa;

    @Column
    private float price;
}
