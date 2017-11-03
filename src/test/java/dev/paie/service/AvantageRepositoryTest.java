package dev.paie.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;
import dev.paie.repository.AvantageRepository;

@ContextConfiguration(classes = { ServicesConfig.class })
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {
	@Autowired
	private AvantageRepository avantageRepository;

	@Before
	public void init() {
		avantageRepository.deleteAll();
	}

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// TODO sauvegarder un nouvel avantage
		Avantage avantage = new Avantage();
		avantage.setCode("Av");
		avantage.setMontant(new BigDecimal(15));
		avantage.setNom("Avantage");
		avantageRepository.save(avantage);
		// TODO vérifier qu'il est possible de récupérer le nouvel avantage via la
		// méthode findOne
		Avantage avantage2 = avantageRepository.findByCode("Av");
		Avantage recupAvantage = avantageRepository.findOne(avantage2.getId());

		assertThat(recupAvantage.getCode()).isEqualTo(avantage.getCode());
		// TODO modifier un avantage

		Avantage av = avantageRepository.findByCode("Av");
		av.setCode("Bouh");
		avantageRepository.save(av);
		// TODO vérifier que les modifications sont bien prises en compte via la méthode
		// findOne
		avantageRepository.findOne(1);

		assertThat(av.getCode()).isEqualTo("Bouh");
	}
}
