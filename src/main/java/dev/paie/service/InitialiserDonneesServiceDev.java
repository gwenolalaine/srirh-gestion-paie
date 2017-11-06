package dev.paie.service;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.CotisationRepository;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Service
@ImportResource(value = { 
	"classpath:cotisations-non-imposables.xml",
	"classpath:entreprise.xml",
	"classpath:grade.xml",
	"classpath:profilRemuneration.xml",
	"classpath:remunerationEmploye.xml",
	"classpath:cotisations-imposables.xml"})
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {
	@Autowired CotisationRepository cotisationRepository;
	@Autowired EntrepriseRepository entrepriseRepository;
	@Autowired GradeRepository gradeRepository;
	@Autowired ProfilRemunerationRepository profilRemunerationRepository;
	@Autowired RemunerationEmployeRepository remunerationEmployeRepository;
	@Autowired PeriodeRepository periodeRepository;
	
	@Autowired Entreprise entreprise;
	@Autowired Grade grade;
	@Autowired ProfilRemuneration profilRemuneration;
	@Autowired RemunerationEmploye remunerationEmploye;
	
	@Autowired private ApplicationContext context;
	
	@Override
	public void initialiser() {
		
		Map<String, Cotisation> cotisations = context.getBeansOfType(Cotisation.class);
		
		Collection<Cotisation> cots = cotisations.values();
		
		for(Cotisation cot : cots) {
			cotisationRepository.save(cot);
		}
		
		entrepriseRepository.save(entreprise);
		gradeRepository.save(grade);
		profilRemunerationRepository.save(profilRemuneration);
		remunerationEmployeRepository.save(remunerationEmploye);
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
		
	}

}
