package org.patatesmaison.concentrateur.mapper;

import org.patatesmaison.concentrateur.dto.EtablissementDTO;
import org.patatesmaison.concentrateur.entity.Etablissement;

public class EtablissementMapper {

    public EtablissementDTO fromEntity(EtablissementDTO dto, Etablissement entity) {
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCategory(entity.getCategory());
        dto.setSpeciality(entity.getSpeciality());
        dto.setPhone(entity.getPhone());
        dto.setWebsite(entity.getWebsite());
        dto.setEmail(entity.getEmail());
        dto.setAddress(entity.getAddress());
        dto.setPostcode(entity.getPostcode());
        dto.setCity(entity.getCity());
        return dto;
    }

    public EtablissementDTO fromEntity(Etablissement entity) {
        return fromEntity(new EtablissementDTO(), entity);
    }

    public Etablissement fromDto(Etablissement entity, EtablissementDTO dto) {
        if (entity.getId() == null) entity.setId(dto.getId());
        if (dto.getName() != null) entity.setName(dto.getName());
        if (dto.getCategory() != null) entity.setCategory(dto.getCategory());
        if (dto.getSpeciality() != null) entity.setSpeciality(dto.getSpeciality());
        if (dto.getPhone() != null) entity.setPhone(dto.getPhone());
        if (dto.getWebsite() != null) entity.setWebsite(dto.getWebsite());
        if (dto.getEmail() != null) entity.setEmail(dto.getEmail());
        if (dto.getAddress() != null) entity.setAddress(dto.getAddress());
        if (dto.getPostcode() != null) entity.setPostcode(dto.getPostcode());
        if (dto.getCity() != null) entity.setCity(dto.getCity());

        return entity;
    }

    public Etablissement fromDto(EtablissementDTO dto) {
        return fromDto(new Etablissement(), dto);
    }

}
