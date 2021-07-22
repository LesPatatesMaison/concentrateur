package org.patatesmaison.concentrateur.service;

import lombok.extern.slf4j.Slf4j;
import org.patatesmaison.concentrateur.client.ApiClient;
import org.patatesmaison.concentrateur.client.CocktailAPIClient;
import org.patatesmaison.concentrateur.constants.ErrorMessages;
import org.patatesmaison.concentrateur.dto.CocktailDTO;
import org.patatesmaison.concentrateur.dto.DrinksDTO;
import org.patatesmaison.concentrateur.exception.APIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CocktailService {
    @Autowired
    private CocktailAPIClient cocktailAPIClient;

    public CocktailDTO getCocktailById(Long cocktailId) throws APIException {
        ResponseEntity<DrinksDTO> response
                = cocktailAPIClient.call("lookup.php?i=" + cocktailId);
        DrinksDTO drinksDTO = response.getBody();
        if(drinksDTO == null) {
            throw new APIException("Cocktail non trouvé", HttpStatus.NOT_FOUND);
        }
        return drinksDTO.getDrinks().get(0);
    }

    public List<CocktailDTO> getCocktailsByName(String cocktailName) {
        ResponseEntity<DrinksDTO> response
                = cocktailAPIClient.call("search.php?s=" + cocktailName);
        DrinksDTO drinksDTO = response.getBody();
        return drinksDTO == null ? new ArrayList<>() : drinksDTO.getDrinks();
    }

    public List<CocktailDTO> getCocktailsByIngredient(String ingredient) {
        ResponseEntity<DrinksDTO> response
                = cocktailAPIClient.call("filter.php?i=" + ingredient);
        DrinksDTO drinksDTO = response.getBody();
        return drinksDTO == null ? new ArrayList<>() : drinksDTO.getDrinks();
    }
}
