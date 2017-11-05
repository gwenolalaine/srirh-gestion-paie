package dev.paie.console;

import java.io.IOException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.paie.config.ServicesConfig;
import dev.paie.menu.Menu;

public class PaieConsole {
	
	public static void main(String[] args) throws IOException{
		
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServicesConfig.class)) {
			Menu menu = context.getBean(Menu.class);
			/** Boolean pour sortir de la boucle */
			boolean out = false;
			/** Boucle du scanner */
			while(!out){
				menu.demarrer();
			}
			
		}	
	}
}
