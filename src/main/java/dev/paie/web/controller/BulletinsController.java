package dev.paie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/bulletins")
public class BulletinsController {
	@Autowired BulletinSalaireRepository bsr;
	@Autowired PeriodeRepository pr;
	@Autowired RemunerationEmployeRepository rer;
	@Autowired BulletinService bulletinService;
	
	@Secured("ROLE_ADMINISTRATEUR")
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerBulletin() {
		ModelAndView mv = new ModelAndView();
	
		mv.setViewName("bulletins/creerBulletin");
		mv.addObject("periodes", pr.findAll());
		mv.addObject("employes", rer.findAll());
		return mv;
	}
	
	@Secured({"ROLE_ADMINISTRATEUR", "ROLE_UTILISATEUR"})
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerBulletins() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/listerBulletins");
		mv.addObject("bulletins", bsr.findAll());
		return mv;
	}
	
	@Secured({"ROLE_ADMINISTRATEUR", "ROLE_UTILISATEUR"})
	@RequestMapping(method = RequestMethod.GET, path = "/visualiser/{id}")
	@Transactional
	public ModelAndView visualiserEmploye(@PathVariable int id) {
		ModelAndView mv = new ModelAndView();
		BulletinSalaire bulletin = bsr.findOne(id);
		mv.setViewName("bulletins/visualiserBulletin");
		mv.addObject("bulletin",bulletin);
		mv.addObject("cotisationsI",bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables());
		mv.addObject("cotisationsNI",bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables());
	
		return mv;
	}
	
	@Secured("ROLE_ADMINISTRATEUR")
	@RequestMapping(method = RequestMethod.POST, path = "/lister")
	public ModelAndView submitForm(int periode, String matricule, String prime) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/listerBulletins");
		mv.addObject("bulletins", bsr.findAll());
		
		bulletinService.sauvegarderBulletin(periode, matricule, prime);
		return mv;
	}
}
