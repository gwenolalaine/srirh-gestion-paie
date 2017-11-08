package dev.paie.web.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.repository.ResultatCalculRemunerationRepository;
import dev.paie.service.CalculerRemunerationServiceSimple;

@Transactional
@Service
public class BulletinService {
	
	@Autowired BulletinSalaireRepository bsr;
	@Autowired PeriodeRepository pr;
	@Autowired RemunerationEmployeRepository rer;
	@Autowired CalculerRemunerationServiceSimple calculer;
	@Autowired ResultatCalculRemunerationRepository rcrr;
	
	@Transactional(timeout=60)
	public void sauvegarderBulletin(int periode, String matricule, String prime) {
		BulletinSalaire bulletin = new BulletinSalaire();
		bulletin.setPeriode(pr.findOne(periode));
		bulletin.setRemunerationEmploye(rer.findByMatricule(matricule));
		bulletin.setPrimeExceptionnelle(new BigDecimal(prime));
		bulletin.setDateCreation(LocalDateTime.now());
		ResultatCalculRemuneration resultat = calculer.calculer(bulletin);
		rcrr.save(resultat);
		bulletin.setResultat(resultat);
		bsr.save(bulletin);
	}
}
