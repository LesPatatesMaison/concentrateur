package org.patatesmaison.concentrateur.service;

import lombok.extern.slf4j.Slf4j;
import org.patatesmaison.concentrateur.client.ApiClient;
import org.patatesmaison.concentrateur.client.CocktailAPIClient;
import org.patatesmaison.concentrateur.dto.CocktailDTO;
import org.patatesmaison.concentrateur.dto.DrinksDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CocktailService {
    @Autowired
    private CocktailAPIClient cocktailAPIClient;

    public List<CocktailDTO> getCocktailsByName(String cocktailName) {
        ResponseEntity<DrinksDTO> response
                = cocktailAPIClient.call("search.php?s=" + cocktailName);
        DrinksDTO drinksDTO = response.getBody();
        return drinksDTO == null ? new ArrayList<>() : drinksDTO.getDrinks();
    }
}
