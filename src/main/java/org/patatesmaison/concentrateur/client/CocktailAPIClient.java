package org.patatesmaison.concentrateur.client;

import org.patatesmaison.concentrateur.dto.DrinksDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CocktailAPIClient {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseUrl = "https://www.thecocktaildb.com/api/json/v1/1/";

    public ResponseEntity<DrinksDTO> call(String endpoint) {
        return this.restTemplate.getForEntity(baseUrl + endpoint, DrinksDTO.class);
    }
}
