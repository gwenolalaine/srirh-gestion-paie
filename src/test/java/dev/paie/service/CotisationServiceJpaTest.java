package dev.paie.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Cotisation;

@ContextConfiguration(classes = { ServicesConfig.class })
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {
	@Autowired private CotisationService cotisationService;
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		Cotisation cotisation = new Cotisation("Cot", "Cotisation", new BigDecimal(14), new BigDecimal(18));
		
		cotisationService.sauvegarder(cotisation);
		
		List<Cotisation> cotisations = cotisationService.lister();
		Optional<Cotisation> optCotisation = cotisations.stream().filter(g->g.getCode().equals("Cot")).findFirst();
		Cotisation newCotisation = optCotisation.get();
		
		newCotisation.setLibelle("PasCotisation");
		newCotisation.setCode("CotCot");
		newCotisation.setTauxPatronal(new BigDecimal(15));
		
		cotisationService.mettreAJour(newCotisation);

		List<Cotisation> cotisations1 = cotisationService.lister();
		Optional<Cotisation> optCotisation1 = cotisations.stream().filter(g->g.getCode().equals("CotCot")).findFirst();
		
		assertThat(optCotisation1.get()).isEqualTo(newCotisation);
		
	}
}