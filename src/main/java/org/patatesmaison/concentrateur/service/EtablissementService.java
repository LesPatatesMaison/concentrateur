package org.patatesmaison.concentrateur.service;

import javassist.NotFoundException;
import org.patatesmaison.concentrateur.constants.ErrorMessages;
import org.patatesmaison.concentrateur.dao.EtablissementRepository;
import org.patatesmaison.concentrateur.entity.Etablissement;
import org.patatesmaison.concentrateur.exception.APIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class EtablissementService {

    @Autowired
    private EtablissementRepository etablissementRepository;

    public Etablissement getEtablissementById(BigInteger id) throws APIException {
        //TODO: Use a DTO
        return etablissementRepository
                .findById(id)
                .orElseThrow(() -> new APIException(ErrorMessages.ETABLISSEMENT_NOT_FOUND, HttpStatus.NOT_FOUND));
    }

    public List<Etablissement> getEtablissements() throws APIException {
        //TODO: Use a DTO
        List<Etablissement> etablissements = etablissementRepository.findAll();

        if (etablissements == null || etablissements.isEmpty()) {
            throw new APIException(ErrorMessages.ETABLISSEMENT_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        return etablissements;
    }

    public List<Etablissement> getEtablissementByName(String name) throws APIException {
        //TODO: Use a DTO
        List<Etablissement> etablissements = etablissementRepository.findByNameContains(name);

        if (etablissements == null || etablissements.isEmpty()) {
            throw new APIException(ErrorMessages.ETABLISSEMENT_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        return etablissements;
    }

}
