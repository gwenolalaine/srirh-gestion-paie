package dev.paie.entite;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="profilRemuneration")
public class ProfilRemuneration {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String code;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="CotNI_Prof",
		joinColumns=
			@JoinColumn(name="id_Profil", referencedColumnName="id"),
		inverseJoinColumns=
			@JoinColumn(name="id_Cotisation", referencedColumnName="id")
	)
	private List<Cotisation> cotisationsNonImposables;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="CotI_Prof",
		joinColumns=
			@JoinColumn(name="id_Profil", referencedColumnName="id"),
		inverseJoinColumns=
			@JoinColumn(name="id_Cotisation", referencedColumnName="id")
	)
	private List<Cotisation> cotisationsImposables;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="Avantage_Prof",
		joinColumns=
			@JoinColumn(name="id_Profil", referencedColumnName="id"),
		inverseJoinColumns=
			@JoinColumn(name="id_Avantage", referencedColumnName="id")
	)
	private List<Avantage> avantages;

	public ProfilRemuneration() {

	}

	public ProfilRemuneration(String code, List<Cotisation> cotisationsNonImposables, List<Cotisation> cotisationsImposables, List<Avantage> avantages) {
		this.code = code;
		this.cotisationsNonImposables = cotisationsNonImposables;
		this.cotisationsImposables = cotisationsImposables;
		this.avantages = avantages;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Cotisation> getCotisationsNonImposables() {
		return cotisationsNonImposables;
	}

	public void setCotisationsNonImposables(List<Cotisation> cotisationsNonImposables) {
		this.cotisationsNonImposables = cotisationsNonImposables;
	}

	public List<Cotisation> getCotisationsImposables() {
		return cotisationsImposables;
	}

	public void setCotisationsImposables(List<Cotisation> cotisationsImposables) {
		this.cotisationsImposables = cotisationsImposables;
	}

	public List<Avantage> getAvantages() {
		return avantages;
	}

	public void setAvantages(List<Avantage> avantages) {
		this.avantages = avantages;
	}

}
