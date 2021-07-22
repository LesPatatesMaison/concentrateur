package org.patatesmaison.concentrateur.service;

import org.patatesmaison.concentrateur.constants.ErrorMessages;
import org.patatesmaison.concentrateur.dao.EtablissementRepository;
import org.patatesmaison.concentrateur.dto.EtablissementDTO;
import org.patatesmaison.concentrateur.entity.Etablissement;
import org.patatesmaison.concentrateur.exception.APIException;
import org.patatesmaison.concentrateur.mapper.EtablissementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EtablissementService extends EtablissementMapper {

    @Autowired
    private EtablissementRepository etablissementRepository;

    public EtablissementDTO getEtablissementById(BigInteger id) throws APIException {
        return fromEntity(etablissementRepository
                .findById(id)
                .orElseThrow(() -> new APIException(ErrorMessages.ETABLISSEMENT_NOT_FOUND, HttpStatus.NOT_FOUND))
        );
    }

    public List<EtablissementDTO> getEtablissements() throws APIException {
        //TODO: Use a DTO
        List<Etablissement> etablissements = etablissementRepository.findAll();

        if (etablissements == null || etablissements.isEmpty()) {
            throw new APIException(ErrorMessages.ETABLISSEMENT_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        return etablissements.stream().map(this::fromEntity).collect(Collectors.toList());
    }

    public List<EtablissementDTO> getEtablissementByName(String name) throws APIException {
        //TODO: Use a DTO
        List<Etablissement> etablissements = etablissementRepository.findByNameContains(name);

        if (etablissements == null || etablissements.isEmpty()) {
            throw new APIException(ErrorMessages.ETABLISSEMENT_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        return etablissements.stream().map(this::fromEntity).collect(Collectors.toList());
    }

}
