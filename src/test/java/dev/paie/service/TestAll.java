package dev.paie.service;

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
public class TestAll {
	@Autowired
	private AvantageRepository avantageRepository;
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		Avantage avantage = new Avantage();
	}
}
