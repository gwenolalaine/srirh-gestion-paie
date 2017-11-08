package dev.paie.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.entite.Utilisateur;
import dev.paie.entite.Utilisateur.ROLES;
import dev.paie.repository.CotisationRepository;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.repository.UtilisateurRepository;

@Service
@ImportResource(value = { 
	"classpath:entreprises.xml",
	"classpath:grades.xml",
	"classpath:profils-remuneration.xml",
	"classpath:remuneration-employe.xml"
})
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {
	

	@Autowired CotisationRepository cotisationRepository;
	@Autowired EntrepriseRepository entrepriseRepository;
	@Autowired GradeRepository gradeRepository;
	@Autowired ProfilRemunerationRepository profilRemunerationRepository;
	@Autowired RemunerationEmployeRepository remunerationEmployeRepository;
	@Autowired PeriodeRepository periodeRepository;
	@Autowired UtilisateurRepository utilisateurRepository;
	
	@Autowired Entreprise entreprise1;
	@Autowired Entreprise entreprise2;
	@Autowired Entreprise entreprise3;
	@Autowired Grade grade1;
	@Autowired Grade grade2;
	@Autowired Grade grade3;
	@Autowired @Qualifier("profil-technicien") ProfilRemuneration profiltechnicien;
	@Autowired  @Qualifier("profil-cadre") ProfilRemuneration profilcadre;
	@Autowired  @Qualifier("profil-stagiaire") ProfilRemuneration profilstagiaire;
	@Autowired RemunerationEmploye remuneration1;
	@Autowired RemunerationEmploye remuneration2;
	@Autowired private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void initialiser() {
		entrepriseRepository.save(entreprise1);
		entrepriseRepository.save(entreprise2);
		entrepriseRepository.save(entreprise3);
		gradeRepository.save(grade1);
		gradeRepository.save(grade2);
		gradeRepository.save(grade3);
		profilRemunerationRepository.save(profiltechnicien);
		profilRemunerationRepository.save(profilcadre);
		profilRemunerationRepository.save(profilstagiaire);
		remuneration1.setDateCreation(LocalDateTime.now());
		remuneration2.setDateCreation(LocalDateTime.now());
		remunerationEmployeRepository.save(remuneration1);
		remunerationEmployeRepository.save(remuneration2);
		periodeRepository.save(new Periode(LocalDate.of(2017, 01, 01), YearMonth.of(2017, 01).atEndOfMonth()));
		periodeRepository.save(new Periode(LocalDate.of(2017, 02, 01), YearMonth.of(2017, 02).atEndOfMonth()));
		periodeRepository.save(new Periode(LocalDate.of(2017, 03, 01), YearMonth.of(2017, 03).atEndOfMonth()));
		periodeRepository.save(new Periode(LocalDate.of(2017, 04, 01), YearMonth.of(2017, 04).atEndOfMonth()));
		periodeRepository.save(new Periode(LocalDate.of(2017, 05, 01), YearMonth.of(2017, 05).atEndOfMonth()));
		periodeRepository.save(new Periode(LocalDate.of(2017, 06, 01), YearMonth.of(2017, 06).atEndOfMonth()));
		periodeRepository.save(new Periode(LocalDate.of(2017, 07, 01), YearMonth.of(2017, 07).atEndOfMonth()));
		periodeRepository.save(new Periode(LocalDate.of(2017, Month.AUGUST, 01), YearMonth.of(2017, Month.AUGUST).atEndOfMonth()));
		periodeRepository.save(new Periode(LocalDate.of(2017, Month.SEPTEMBER, 01), YearMonth.of(2017, Month.SEPTEMBER).atEndOfMonth()));
		periodeRepository.save(new Periode(LocalDate.of(2017, Month.OCTOBER, 01), YearMonth.of(2017, Month.OCTOBER).atEndOfMonth()));
		periodeRepository.save(new Periode(LocalDate.of(2017, Month.NOVEMBER, 01), YearMonth.of(2017, Month.NOVEMBER).atEndOfMonth()));
		periodeRepository.save(new Periode(LocalDate.of(2017, Month.DECEMBER, 01), YearMonth.of(2017, Month.DECEMBER).atEndOfMonth()));
		
		String iciUnMotDePasse = "topSecret";
		String iciMotDePasseHashe = this.passwordEncoder.encode(iciUnMotDePasse);
		String mdp = this.passwordEncoder.encode("top");
		Utilisateur utilisateurAdmin = new Utilisateur();
		utilisateurAdmin.setMotDePasse(iciMotDePasseHashe);
		utilisateurAdmin.setNomUtilisateur("admin");
		utilisateurAdmin.setRole(ROLES.ROLE_ADMINISTRATEUR);
		utilisateurAdmin.setEstActif(true);
		
		Utilisateur utilisateurUser = new Utilisateur();
		utilisateurUser.setMotDePasse(mdp);
		utilisateurUser.setNomUtilisateur("user");
		utilisateurUser.setRole(ROLES.ROLE_UTILISATEUR);
		utilisateurUser.setEstActif(true);
		
		utilisateurRepository.save(utilisateurAdmin);
		utilisateurRepository.save(utilisateurUser);
	}

}
