package org.patatesmaison.concentrateur.dao;

import lombok.extern.slf4j.Slf4j;
import org.patatesmaison.concentrateur.entity.Etablissement;
import org.patatesmaison.concentrateur.tools.StringFormat;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class RestaurantListeFile {

    private static final String CSV_SEPARATOR = ";";

    private RestaurantListeFile() {
        // Hide default constructor
    }

    public static List<Etablissement> read(String filename) {
        List<Etablissement> etablissements = new ArrayList<>();
        List<String> lines = new ArrayList<>();

        // Get all csv file lines
        try {
            lines = Files.readAllLines(Paths.get(filename), StandardCharsets.ISO_8859_1);

        } catch (Exception e) {
            log.warn("RestaurantListFile : reader - {} ", e.getMessage());
        }

        // Suppress first line that is CSV header
        lines.remove(0);

        // Parse all lines to store it in an Entity array
        AtomicInteger i = new AtomicInteger(1);
        lines.forEach(line -> {
            try {
                String[] contents = line.split(CSV_SEPARATOR);

                Etablissement etablissement = new Etablissement();
                etablissement.setId(new BigInteger(String.valueOf(i.getAndIncrement())));
                etablissement.setName(StringFormat.getContent(contents, 0));
                etablissement.setCategory(StringFormat.getContent(contents, 1));
                etablissement.setSpeciality(StringFormat.getContent(contents, 2));
                etablissement.setPhone(StringFormat.getContent(contents, 4));
                etablissement.setWebsite(StringFormat.getContent(contents, 5));
                etablissement.setEmail(StringFormat.getContent(contents, 6));
                etablissement.setAddress(StringFormat.getContent(contents, 7));
                etablissement.setPostcode(
                        StringFormat.getContent(contents, 8).split(" ")[0]
                );
                etablissement.setCity(
                        StringFormat.getContent(contents, 8).replaceAll("^\\d+ +", "")
                );

                etablissements.add(etablissement);
            } catch (Exception e) {
                log.warn("RestaurantListeFile.reader.line - {} - line {}", e.getMessage(), line);
            }

        });

        return etablissements;
    }

}
