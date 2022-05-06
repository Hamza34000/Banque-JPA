package fr.diginamic.banque.jpa.entities;

import javax.persistence.*;

@Entity
@Table(name="livreta")
@NamedQueries({ 
    @NamedQuery(
            name = "LivretA.getCompte", 
            query = "select l from Compte l where l.compteLivretA.id = :id"
            )
    })
public class LivretA {
	
	/** @nnotation de Mapping avec la BDD*/
	@Id /** Définir la PK */
	@GeneratedValue(strategy = GenerationType.IDENTITY) /**AUTOINCREMENTAL PAR LE SGBDR */
	private int id; /** nom de la colonne */

	@Column(name = "taux", length = 100, nullable = false)
	private Double taux;
	
	

	public LivretA() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}
	
	
}
