package dev.paie.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bulletins")
public class BulletinsController {

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerBulletin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/creerBulletin");
		mv.addObject("prefixMatricule","M00");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerBulletins() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/listerBulletins");
		mv.addObject("prefixMatricule","M00");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/visualiser")
	public ModelAndView visualiserEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/visualiserBulletins");
		mv.addObject("prefixMatricule","M00");
		return mv;
	}
}
