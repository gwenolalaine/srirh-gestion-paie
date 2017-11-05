package dev.paie.menu;


import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dev.paie.repository.CotisationRepository;

@Controller
public class SupprimerCotisationOptionMenu extends OptionMenu {
	
	@Autowired Logger LOG;
	@Autowired  protected Scanner choix;
	@Autowired CotisationRepository cotisationRepository;
	
	protected String lib;
	
	public SupprimerCotisationOptionMenu(){
		this.lib = "Supprimer une cotisation";
	}
	/**
	 * Supprimer une pizza
	 * @throws StockageException 
	 */
	public boolean execute(){
		/** Choix de la pizza à supprimer */
		choix.nextLine();
		LOG.info("Choisir le code de la pizza à supprimer");
		cotisationRepository.findAll();
		
		String toChange = choix.nextLine().toLowerCase();
		
		if(cotisationRepository.findByCode(toChange) != null) {
			cotisationRepository.delete(cotisationRepository.findByCode(toChange));
		}
		
		return true;
	}
	
	@Override
	public String getLibelle(){
		return lib;
	}
}
