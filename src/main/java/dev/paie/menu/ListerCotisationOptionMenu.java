package dev.paie.menu;


import java.io.IOException;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dev.paie.repository.CotisationRepository;

@Controller
public class ListerCotisationOptionMenu extends OptionMenu{
	
	@Autowired CotisationRepository cotisationRepository;
	@Autowired Logger LOG;

	String lib;
	
	public ListerCotisationOptionMenu(){
		this.lib = "Lister des cotisations";
	}
	
	@Override
	public boolean execute() throws IOException{
		cotisationRepository.findAll();
		return true;
	}
	
	@Override
	public String getLibelle(){
		return lib;
	}
}
