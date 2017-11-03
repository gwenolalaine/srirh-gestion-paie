package dev.paie.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Grade;

@ContextConfiguration(classes = { ServicesConfig.class })
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest{
	@Autowired private GradeService gradeService;
	
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// TODO sauvegarder un nouveau grade
		Grade nouveauGrade = new Grade();
		nouveauGrade.setCode("MAS");
		nouveauGrade.setNbHeuresBase(new BigDecimal(74));
		nouveauGrade.setTauxBase(new BigDecimal(12));
		gradeService.sauvegarder(nouveauGrade);
		
		List<Grade> grades = gradeService.lister();
		Optional<Grade> oldGrade = grades.stream().filter(g->g.getCode().equals("MAS")).findFirst();
		
		oldGrade.get().setCode("Bop");
		oldGrade.get().setNbHeuresBase(new BigDecimal(75));
		gradeService.mettreAJour(oldGrade.get());
		
		List<Grade> grades1 = gradeService.lister();
		Optional<Grade> newGrade = grades1.stream().filter(g->g.getCode().equals("Bop")).findFirst();
		
		// TODO vérifier que les modifications sont bien prises en compte via la méthode lister
		assertThat(newGrade.get().getNbHeuresBase()).isEqualTo(new BigDecimal(75));
	}
}
