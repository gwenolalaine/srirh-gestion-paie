package dev.paie.menu;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class Menu {

	@Autowired
	private ApplicationContext context;
	@Autowired
	Scanner scanner;
	@Autowired
	Logger LOG;
	
	ListerCotisationOptionMenu lister;
	AjouterCotisationOptionMenu add;
	SupprimerCotisationOptionMenu delete;
	
	Map<Integer, OptionMenu> options = new HashMap();
	
	
	@Autowired
	public Menu(ListerCotisationOptionMenu lister, AjouterCotisationOptionMenu add, SupprimerCotisationOptionMenu delete) {
		this.lister = lister;
		this.add = add;
		this.delete = delete;
	}

	@PostConstruct
	public void init(){
		Map<String, OptionMenu> resultatRecherhe = context.getBeansOfType(OptionMenu.class);
		AtomicInteger incr = new AtomicInteger();
		
		resultatRecherhe.forEach((id, option) ->{
			options.put(incr.incrementAndGet(),option);
		});
	}
	
	public void demarrer() throws IOException{
		boolean continuer = true;
			/** Liste des intructions pour l'utilisateurs */
		while(continuer) {
			LOG.info("***** Pizzeria Administration *****\r");
			

			options.forEach((cle, valeur) -> {
				System.out.println(cle + ". " + valeur.getLibelle());
			});
			
			int saisie = scanner.nextInt();
			
			continuer = options.get(saisie).execute();
		}
	}
}
