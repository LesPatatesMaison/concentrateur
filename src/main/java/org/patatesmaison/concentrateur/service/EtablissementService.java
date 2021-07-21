package org.patatesmaison.concentrateur.service;

import javassist.NotFoundException;
import org.patatesmaison.concentrateur.dao.EtablissementRepository;
import org.patatesmaison.concentrateur.entity.Etablissement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class EtablissementService {

    @Autowired
    private EtablissementRepository etablissementRepository;

    public Etablissement getEtablissementById (BigInteger id) throws NotFoundException {
        //TODO: Use a DTO
        return etablissementRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Etablissement " + id + " not found"));
    }
}
