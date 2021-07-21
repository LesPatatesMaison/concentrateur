package org.patatesmaison.concentrateur.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;


@Entity
@Table(name = "ETABLISSEMENT")
public class Etablissement {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private BigInteger id;

    @Column(name = "NAME")
    @Getter
    @Setter
    private String name;

    @Column(name = "CATEGORY")
    @Getter
    @Setter
    private String category;

    @Column(name = "SPECIALITY")
    @Getter
    @Setter
    private String speciality;

    @Column(name = "PHONE")
    @Getter
    @Setter
    private String phone;

    @Column(name = "WEBSITE")
    @Getter
    @Setter
    private String website;

    @Column(name = "EMAIL")
    @Getter
    @Setter
    private String email;

    @Column(name = "ADDRESS")
    @Getter
    @Setter
    private String address;

    @Column(name = "POSTCODE")
    @Getter
    @Setter
    private String postcode;

    @Column(name = "CITY")
    @Getter
    @Setter
    private String city;
}
