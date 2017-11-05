package dev.paie.menu;


import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dev.paie.entite.Cotisation;
import dev.paie.repository.CotisationRepository;

@Controller
public class AjouterCotisationOptionMenu extends OptionMenu{
	
	@Autowired Logger LOG;

	@Autowired CotisationRepository cotisationRepository;
	
	@Autowired protected Scanner choix;
	
	protected String lib;
	
	public AjouterCotisationOptionMenu(){
		this.lib = "Créer une cotisation";
	}
	
	
	public boolean execute() throws IOException {
		/** Choix des paramètres de la pizzas */
		
		choix.nextLine();

		LOG.info("Veuillez saisir le code");
		String code = choix.nextLine();
		
		LOG.info("Veuillez saisir le libelle (sans espace)");
		String libelle = choix.nextLine();
		
		LOG.info("Veuillez choisir le taux salarial");
		String tauxSalarialStr = choix.nextLine().toUpperCase().trim();
		BigDecimal tauxSalarial = new BigDecimal(tauxSalarialStr);
		
		LOG.info("Veuillez le taux patronal");
		String tauxPatronalStr = choix.nextLine();
		BigDecimal tauxPatronal = new BigDecimal(tauxPatronalStr);
		
		cotisationRepository.save(new Cotisation(code, libelle, tauxSalarial, tauxPatronal));
		return true;
	}
	
	@Override
	public String getLibelle(){
		return lib;
	}
}
