package fr.diginamic.banque.jpa.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="compte")
public class Compte {

	/** @nnotation de Mapping avec la BDD*/
	@Id /** Définir la PK */
	@GeneratedValue(strategy = GenerationType.IDENTITY) /**AUTOINCREMENTAL PAR LE SGBDR */
	private int id; /** nom de la colonne */
	
	@Column(name = "numero", length = 100, nullable = false)
	private String numero;
	
	@Column(name = "sold", nullable = false)
	private Double sold;
	

	@ManyToOne
	@JoinColumn(name = "ID_LIVRET", nullable = true)
	private LivretA compteLivretA;
	
	@ManyToOne
	@JoinColumn(name = "ID_ASSU", nullable = true)
	private AssuranceVie compteAssuranceVie;
	
	@ManyToOne
	@JoinColumn(name = "ID_OPE", nullable = true)
	private Operation compteOperation;
	
	
	
	
	public Operation getCompteOperation() {
		return compteOperation;
	}


	public void setCompteOperation(Operation compteOperation) {
		this.compteOperation = compteOperation;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "REL_COM_CLI",
			joinColumns = @JoinColumn(name = "ID_COM", referencedColumnName = "ID"),
			inverseJoinColumns = @JoinColumn(name="ID_CLI", referencedColumnName = "ID"))
	private Set<Client> comptesClient;
	
	
	
	public Compte() {
		comptesClient = new HashSet<>();
	}
	

	public LivretA getCompteLivretA() {
		return compteLivretA;
	}



	public void setCompteLivretA(LivretA compteLivretA) {
		this.compteLivretA = compteLivretA;
	}



	public AssuranceVie getCompteAssuranceVie() {
		return compteAssuranceVie;
	}



	public void setCompteAssuranceVie(AssuranceVie compteAssuranceVie) {
		this.compteAssuranceVie = compteAssuranceVie;
	}



	public Set<Client> getComptesClient() {
		return comptesClient;
	}

	public void setComptesClient(Set<Client> comptesClient) {
		this.comptesClient = comptesClient;
	}
	

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Double getSold() {
		return sold;
	}

	public void setSold(Double sold) {
		this.sold = sold;
	}
	
	
}
