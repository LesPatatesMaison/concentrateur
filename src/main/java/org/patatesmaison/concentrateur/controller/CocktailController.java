package org.patatesmaison.concentrateur.controller;

import javassist.NotFoundException;
import org.patatesmaison.concentrateur.dto.CocktailDTO;
import org.patatesmaison.concentrateur.entity.Etablissement;
import org.patatesmaison.concentrateur.service.CocktailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cocktail")
public class CocktailController {
    @Autowired
    private CocktailService cocktailService;

    @GetMapping("/{cocktailName}")
    public List<CocktailDTO> getCocktailsByName(@PathVariable("cocktailName") String cocktailName) throws NotFoundException {
        return cocktailService.getCocktailsByName(cocktailName);
    }

    @GetMapping("/ingredient/{ingredient}")
    public List<CocktailDTO> getCocktailsByIngredient(@PathVariable("ingredient") String ingredient) throws NotFoundException {
        return cocktailService.getCocktailsByIngredient(ingredient);
    }
}
