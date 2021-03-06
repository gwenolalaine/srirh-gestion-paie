package dev.paie.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="resultatCalculRemuneration")
public class ResultatCalculRemuneration {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String salaireDeBase;
	@Column
	private String salaireBrut;
	@Column
	private String totalRetenueSalarial;
	@Column
	private String totalCotisationsPatronales;
	@Column
	private String netImposable;
	@Column
	private String netAPayer;
	/**
	 * @return the salaireDeBase
	 */
	public String getSalaireDeBase() {
		return salaireDeBase;
	}
	/**
	 * @param salaireDeBase the salaireDeBase to set
	 */
	public void setSalaireDeBase(String salaireDeBase) {
		this.salaireDeBase = salaireDeBase;
	}
	/**
	 * @return the salaireBrut
	 */
	public String getSalaireBrut() {
		return salaireBrut;
	}
	/**
	 * @param salaireBrut the salaireBrut to set
	 */
	public void setSalaireBrut(String salaireBrut) {
		this.salaireBrut = salaireBrut;
	}
	/**
	 * @return the totalRetenueSalarial
	 */
	public String getTotalRetenueSalarial() {
		return totalRetenueSalarial;
	}
	/**
	 * @param totalRetenueSalarial the totalRetenueSalarial to set
	 */
	public void setTotalRetenueSalarial(String totalRetenueSalarial) {
		this.totalRetenueSalarial = totalRetenueSalarial;
	}
	/**
	 * @return the totalCotisationsPatronales
	 */
	public String getTotalCotisationsPatronales() {
		return totalCotisationsPatronales;
	}
	/**
	 * @param totalCotisationsPatronales the totalCotisationsPatronales to set
	 */
	public void setTotalCotisationsPatronales(String totalCotisationsPatronales) {
		this.totalCotisationsPatronales = totalCotisationsPatronales;
	}
	/**
	 * @return the netImposable
	 */
	public String getNetImposable() {
		return netImposable;
	}
	/**
	 * @param netImposable the netImposable to set
	 */
	public void setNetImposable(String netImposable) {
		this.netImposable = netImposable;
	}
	/**
	 * @return the netAPayer
	 */
	public String getNetAPayer() {
		return netAPayer;
	}
	/**
	 * @param netAPayer the netAPayer to set
	 */
	public void setNetAPayer(String netAPayer) {
		this.netAPayer = netAPayer;
	}
}
