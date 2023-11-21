package tn.iit.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

@Entity
@Table(name = "t_client")
public class Client implements Serializable /* spec jee */ {
	private static final long serialVersionUID = 1L;

	@Id // rib = PK
	@Include // à inclure lors de la génération de equals and hashCode
	@Column(length = 10)
	private String cin;
	
	private String nom;
	private String prenom;
	
	
	//bidirectionnelle
	@Exclude //cassé la boucle toString
	@JsonIgnore //casse la boucle json
	@OneToOne(mappedBy = "client")
	private Compte  compte;

}
