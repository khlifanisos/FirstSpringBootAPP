package tn.iit.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

@Entity
@Table(name = "t_compte")
public class Compte implements Serializable /* spec jee */ {

	public Compte(float solde, Client client) {
		this.solde = solde;
		this.client = client;
		
	}

	private static final long serialVersionUID = 1L;

	@Id // rib = PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
	@Include // à inclure lors de la génération de equals and hashCode
	private Long rib;
	private float solde;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_client")
	private Client client;
	//Fetch:
	// EAGER: le client est chargé dès le chargement du compte de la BD
	// LAZY: le client n'est pas chargé compteService.findAll()
	// LAZY: il est chargé à la demande (lors de l'appel de getClient());

}
