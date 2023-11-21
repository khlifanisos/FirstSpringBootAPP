package tn.iit.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import tn.iit.dao.ClientDao;
import tn.iit.entity.Client;
import tn.iit.entity.Compte;
import tn.iit.service.ClientService;
import tn.iit.service.CompteService;

@Controller
@RequestMapping("/comptes")
public class CompteController {

	private final CompteService compteService;
	private final ClientService clientService;
	private final ClientDao clientDao;

	@Autowired
	public CompteController(CompteService compteService ,ClientService clientService ,ClientDao clientDao) {
		super();
		this.compteService = compteService;
		this.clientService = clientService;
		this.clientDao =clientDao;
	}
	
	

	
	

	@PostMapping("/save")
	public String save(@RequestParam(name = "cin") String cin, @RequestParam(name = "solde") float solde) {
		//FIXME
		Client client =clientService.findById(cin);
		Compte compte =new Compte(solde, client);
		
		compteService.saveOrUpdate(compte);
		return "redirect:/comptes/all";
	}

	@GetMapping("/all")
	public ModelAndView getAll() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("comptes", compteService.findAll());
		modelAndView.setViewName("comptes"); // va à la page comptes.html (sans extension)
	
		 
		 
		return modelAndView;
	}
	
	@GetMapping("/all-json")
	@ResponseBody
	public List<Compte> getAllJson() {
		return compteService.findAll();
	}

	@PostMapping("/delete-ajax")
	@ResponseBody
	public void deleteAjax(@RequestParam(name = "rib") Long rib) {
		compteService.delete(rib);
		}
	
	@GetMapping("/delete/{rib}")
	public String delete(@PathVariable(name = "rib") Long rib) {
		compteService.delete(rib);
		return "redirect:/comptes/all";
	}

	@GetMapping("/edit/{rib}")
	public ModelAndView edit(@PathVariable(name = "rib") Long rib) {
		ModelAndView modelAndView = new ModelAndView();
		Compte compte = compteService.findById(rib);
		modelAndView.addObject("compte", compte);
		modelAndView.setViewName("edit-compte");
		return modelAndView;
	}

	
	@PostMapping(value = "/update")
	public String update(@ModelAttribute Compte compte) {
		compteService.saveOrUpdate(compte);
		return "redirect:/comptes/all";
	}
	
}
