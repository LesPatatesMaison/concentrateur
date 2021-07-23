package org.patatesmaison.concentrateur.dao;

import org.patatesmaison.concentrateur.entity.Etablissement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface EtablissementRepository extends CrudRepository<Etablissement, BigInteger> {

    List<Etablissement> findByNameContains(String name);

    @Override
    List<Etablissement> findAll();

}
