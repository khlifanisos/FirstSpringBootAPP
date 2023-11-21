package tn.iit.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import tn.iit.entity.Compte;

@Repository
public interface CompteDao extends JpaRepository<Compte, Long> {

	Compte findByClientCin(String cin);



}
