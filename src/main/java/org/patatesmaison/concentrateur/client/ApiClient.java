package org.patatesmaison.concentrateur.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiClient {

    private final RestTemplate restTemplate = new RestTemplate();

}
