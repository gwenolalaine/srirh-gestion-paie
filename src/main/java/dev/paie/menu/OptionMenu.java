package dev.paie.menu;


import java.io.IOException;

import org.springframework.stereotype.Controller;

@Controller
public abstract class OptionMenu {
	protected String libelle;
	protected Boolean execute;
	
	public String getLibelle(){
		return libelle;
	}
	
	public abstract boolean execute() throws  IOException;
}
