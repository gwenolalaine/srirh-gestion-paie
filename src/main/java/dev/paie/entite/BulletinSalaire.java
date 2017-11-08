package dev.paie.entite;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="bulletinSalaire")
public class BulletinSalaire {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="remunerationEmployeId")
	private RemunerationEmploye remunerationEmploye;
	@ManyToOne
	@JoinColumn(name="periodeID")
	private Periode periode;
	@Column
	private BigDecimal primeExceptionnelle;
	@Column
	private LocalDateTime dateCreation;
	@OneToOne
	private ResultatCalculRemuneration resultat;
	
	public BulletinSalaire() {
	}
	
	public BulletinSalaire(RemunerationEmploye remunerationEmploye, Periode periode, BigDecimal primeExceptionnelle) {
		this.remunerationEmploye = remunerationEmploye;
		this.periode = periode;
		this.primeExceptionnelle = primeExceptionnelle;
	}
	
	public RemunerationEmploye getRemunerationEmploye() {
		return remunerationEmploye;
	}
	public void setRemunerationEmploye(RemunerationEmploye remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
	}
	public Periode getPeriode() {
		return periode;
	}
	public void setPeriode(Periode periode) {
		this.periode = periode;
	}
	public BigDecimal getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}
	public void setPrimeExceptionnelle(BigDecimal primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the dateCreation
	 */
	public LocalDateTime getDateCreation() {
		return dateCreation;
	}
	/**
	 * @param dateCreation the dateCreation to set
	 */
	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}
	/**
	 * @return the resultat
	 */
	public ResultatCalculRemuneration getResultat() {
		return resultat;
	}
	/**
	 * @param resultat the resultat to set
	 */
	public void setResultat(ResultatCalculRemuneration resultat) {
		this.resultat = resultat;
	}
	
	public String getDateDeCreationFormat(){
        return this.dateCreation.format(DateTimeFormatter.ofPattern("HH:mm:ss dd:MM:yyyy"));
    }
	
	
	
}
