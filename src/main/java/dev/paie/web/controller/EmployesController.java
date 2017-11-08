package dev.paie.web.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/employes")
public class EmployesController {
	@Autowired RemunerationEmployeRepository rer;
	@Autowired EntrepriseRepository er;
	@Autowired ProfilRemunerationRepository prr;
	@Autowired GradeRepository gr;
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		mv.addObject("entreprises", er.findAll());
		mv.addObject("profils", prr.findAll());
		mv.addObject("grades", gr.findAll());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	@Secured({"ROLE_ADMINISTRATEUR", "ROLE_UTILISATEUR"})
	public ModelAndView listerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listeEmployes");
		
		mv.addObject("employes", rer.findAll());
		return mv;
	}
	
	
	@RequestMapping(method = RequestMethod.POST, path = "/lister")
	@Secured({"ROLE_ADMINISTRATEUR"})
	public ModelAndView submitForm(String matricule, Integer entreprise, Integer profil, Integer grade) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listeEmployes");
		
		RemunerationEmploye employe = new RemunerationEmploye();
		employe.setMatricule(matricule);
		employe.setEntreprise(er.findOne(entreprise));
		employe.setGrade(gr.findOne(grade));
		employe.setProfilRemuneration(prr.findOne(grade));
		employe.setDateCreation(LocalDateTime.now());
		rer.save(employe);
		
		mv.addObject("employes", rer.findAll());
		return mv;
	}
}
