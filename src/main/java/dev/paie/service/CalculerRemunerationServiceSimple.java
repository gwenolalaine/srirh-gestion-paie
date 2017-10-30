package dev.paie.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {

	@Autowired
	private PaieUtils paieUtils;
	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		String salaire_base = paieUtils.formaterBigDecimal(bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase().multiply(bulletin.getRemunerationEmploye().getGrade().getTauxBase()));
		String salaire_brut = paieUtils.formaterBigDecimal(new BigDecimal(salaire_base).add(bulletin.getPrimeExceptionnelle()));
		String total_retenue_salariale = paieUtils.formaterBigDecimal(bulletin.getRemunerationEmploye()
				.getProfilRemuneration()
				.getCotisationsNonImposables().stream()
				.filter(c -> c.getTauxSalarial() != null)
				.map(c->c.getTauxSalarial().multiply(new BigDecimal(salaire_brut)))
				.reduce((c1,  c2)-> c1.add(c2))
				.get());
		String total_cotisations_patronales = paieUtils.formaterBigDecimal(bulletin.getRemunerationEmploye()
				.getProfilRemuneration()
				.getCotisationsNonImposables().stream()
				.filter(c -> c.getTauxPatronal() != null)
				.map(c->c.getTauxPatronal().multiply(new BigDecimal(salaire_brut)))
				.reduce((c1,  c2)-> c1.add(c2))
				.get());
		String net_imposable = paieUtils.formaterBigDecimal(new BigDecimal(salaire_brut).subtract(new BigDecimal(total_retenue_salariale)));
		String net_a_payer = paieUtils.formaterBigDecimal(new BigDecimal(net_imposable).subtract(bulletin.getRemunerationEmploye()
				.getProfilRemuneration()
				.getCotisationsImposables().stream()
				.filter(c -> c.getTauxSalarial() != null)
				.map(c->c.getTauxSalarial().multiply(new BigDecimal(salaire_brut)))
				.reduce((c1,  c2)-> c1.add(c2)).get()));
		
		ResultatCalculRemuneration resultat = new ResultatCalculRemuneration();
		resultat.setNetAPayer(net_a_payer);
		resultat.setNetImposable(net_imposable);
		resultat.setSalaireBrut(salaire_brut);
		resultat.setSalaireDeBase(salaire_base);
		resultat.setTotalCotisationsPatronales(total_cotisations_patronales);
		resultat.setTotalRetenueSalarial(total_retenue_salariale);
		
		return resultat;
	}

}
