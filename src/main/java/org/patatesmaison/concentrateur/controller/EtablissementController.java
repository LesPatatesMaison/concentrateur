package org.patatesmaison.concentrateur.controller;

import javassist.NotFoundException;
import org.patatesmaison.concentrateur.entity.Etablissement;
import org.patatesmaison.concentrateur.service.EtablissementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@RequestMapping("/etablissement")
public class EtablissementController {

    @Autowired
    private EtablissementService etablissementService;

    @GetMapping("/{id}")
    public Etablissement getEtablissement(@PathVariable("id") BigInteger id) throws NotFoundException {
        //TODO: Use a DTO
        return etablissementService.getEtablissementById(id);
    }

}
