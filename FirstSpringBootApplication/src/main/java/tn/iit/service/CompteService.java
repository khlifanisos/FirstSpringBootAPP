package tn.iit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.iit.dao.ClientDao;
import tn.iit.dao.CompteDao;
import tn.iit.entity.Compte;

@Service
public class CompteService {

//	private final CompteDaoJpa compteDaoJpa;
	private final CompteDao compteDaoSpringData;
	
	@Autowired
	public CompteService(CompteDao compteDaoSpringData) {
		super();
		this.compteDaoSpringData = compteDaoSpringData;
	}
	

	public void saveOrUpdate(Compte compte) {
		compteDaoSpringData.saveAndFlush(compte);
		
	}

	public List<Compte> findAll() {
		return compteDaoSpringData.findAll();
	}

	public void delete(Compte compte) {
		compteDaoSpringData.delete(compte);
	}
	
	public void delete(Long rib) {
		compteDaoSpringData.deleteById(rib);
	}

	

	public Compte findById(Long rib) {
		Optional<Compte> compteOptional = compteDaoSpringData.findById(rib);
		if (compteOptional.isPresent()) {
			return compteOptional.get();
		}
		return null;
	}

}
