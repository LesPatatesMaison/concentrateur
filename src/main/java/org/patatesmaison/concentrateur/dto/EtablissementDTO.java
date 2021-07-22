package org.patatesmaison.concentrateur.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class EtablissementDTO {
    private BigInteger id;
    private String name;
    private String category;
    private String speciality;
    private String phone;
    private String website;
    private String email;
    private String address;
    private String postcode;
    private String city;
}
