package com.api.goncalvesrep.orcamentos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.goncalvesrep.orcamentos.models.ChapaModel;
import com.api.goncalvesrep.orcamentos.repositories.ChapaRepository;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChapaService {

    @Autowired
    private ChapaRepository chapaRepository;

    public List<ChapaModel> getAllChapas() {
        return chapaRepository.findAll();
    }

    public Optional<ChapaModel> getChapaById(UUID id) {
        return chapaRepository.findById(id);
    }

    @Transactional
    public ChapaModel createChapa(ChapaModel chapa) {
        return chapaRepository.save(chapa);
    }

    @Transactional
    public Optional<ChapaModel> updateChapa(UUID id, ChapaModel chapaDetails) {
        return chapaRepository.findById(id).map(chapa -> {
            chapa.setName(chapaDetails.getName());
            chapa.setPricekg(chapaDetails.getPricekg());
            return chapaRepository.save(chapa);
        });
    }

    @Transactional
    public void deleteChapa(UUID id) {
        chapaRepository.deleteById(id);
    }
}
