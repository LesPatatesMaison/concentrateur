package org.patatesmaison.concentrateur.configuration;

import lombok.extern.slf4j.Slf4j;
import org.patatesmaison.concentrateur.dao.EtablissementRepository;
import org.patatesmaison.concentrateur.entity.Etablissement;
import org.patatesmaison.concentrateur.dao.RestaurantListeFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Paths;
import java.util.List;

@Slf4j
@Configuration
public class H2DBConfig {

    @Autowired
    private EtablissementRepository etablissementRepository;

    @Bean
    public void initDatabase() {
        String absolutePath = Paths.get("./src/main/resources").toFile().getAbsolutePath();

        List<Etablissement> etablissements = RestaurantListeFile.read(absolutePath + "/restaurants-liste.csv");

        etablissements.forEach(etablissement -> etablissementRepository.save(etablissement));

        log.info("H2 DataBase filled");
    }

}
