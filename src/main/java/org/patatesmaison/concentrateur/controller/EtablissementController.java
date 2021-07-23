package org.patatesmaison.concentrateur.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.patatesmaison.concentrateur.dto.EtablissementDTO;
import org.patatesmaison.concentrateur.exception.APIException;
import org.patatesmaison.concentrateur.service.EtablissementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/etablissement")
@Api(value = "Etablissement API", produces = "", consumes = "", tags = "Etablissement", protocols = "GET")
public class EtablissementController {

    @Autowired
    private EtablissementService etablissementService;

    @ApiOperation(value = "Voir la liste des établissements", response = EtablissementDTO.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des Etablissements trouvés"),
            @ApiResponse(responseCode = "404", description = "Aucun Etablissement trouvé")
    })
    @GetMapping("/list")
    @ResponseStatus(code = HttpStatus.OK)
    public List<EtablissementDTO> getEtablissementList() throws APIException {
        //TODO: Use a DTO
        return etablissementService.getEtablissements();
    }

    @ApiParam(name = "{id}", required = true)
    @ApiOperation(value = "Voir un établissement", response = EtablissementDTO.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Etablissement trouvé"),
            @ApiResponse(responseCode = "404", description = "Etablissement non trouvé")
    })
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public EtablissementDTO getEtablissementById(@PathVariable("id") BigInteger id) throws APIException {
        //TODO: Use a DTO
        return etablissementService.getEtablissementById(id);
    }

    @ApiOperation(value = "Recherche d'un établissement", response = EtablissementDTO.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Etablissement trouvé"),
            @ApiResponse(responseCode = "404", description = "Etablissement non trouvé")
    })
    @GetMapping("/search")
    @ResponseStatus(code = HttpStatus.OK)
    public List<EtablissementDTO> findEtablissementByName(@RequestParam(value = "name", required = false) String name) throws APIException {
        //TODO: Use a DTO
        return etablissementService.getEtablissementByName(name);
    }

}
