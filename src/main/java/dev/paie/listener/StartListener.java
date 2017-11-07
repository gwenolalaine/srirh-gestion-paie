package dev.paie.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.paie.service.InitialiserDonneesService;

@Component
public class StartListener {
	@Autowired InitialiserDonneesService init;
	
	    @EventListener({ContextRefreshedEvent.class})
	    void contextRefreshedEvent() {
	        //init.initialiser();
	    }
}
