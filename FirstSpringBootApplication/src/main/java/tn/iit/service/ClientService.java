package tn.iit.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.iit.dao.ClientDao;
import tn.iit.entity.Client;
import tn.iit.entity.Compte;

@Service
public class ClientService {

//	private final CompteDaoJpa compteDaoJpa;
	private final ClientDao clientDaoSpringData;


	
	@Autowired
	public ClientService(ClientDao clientDaoSpringData) {
		super();
		this.clientDaoSpringData = clientDaoSpringData;
	}
	

	public void saveOrUpdate(Client client) {
		clientDaoSpringData.saveAndFlush(client);
		
	}

	public List<Client> findAll() {
		return clientDaoSpringData.findAll();
	}

	public void delete(Client client) {
		clientDaoSpringData.delete(client);
	}
	public void delete(String cin) {
		clientDaoSpringData.deleteById(cin);
	}

	public Client findById(String cin) {
		Optional<Client> clientOptional = clientDaoSpringData.findById(cin);
		if (clientOptional.isPresent()) {
			return clientOptional.get();
		}
		return null;
	}


	


}
