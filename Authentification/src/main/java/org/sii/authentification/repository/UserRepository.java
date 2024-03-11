package org.sii.authentification.repository;

import org.sii.authentification.model.Utilisateur;
import org.sii.authentification.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Utilisateur,Integer> {
    Utilisateur findByEmail(String email);
    Boolean existsByEmail(String email);
}
