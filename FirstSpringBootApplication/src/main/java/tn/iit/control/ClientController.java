package tn.iit.control;

import java.util.ArrayList;
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

import tn.iit.entity.Client;
import tn.iit.entity.Compte;
import tn.iit.service.ClientService;




@Controller
@RequestMapping("/clients")
public class ClientController {

	private final ClientService clientService;;
	@Autowired
	public ClientController(ClientService clientService) {
		super();
			this.clientService = clientService;
	}

	
	
	
	
	@PostMapping("/save")
	public String save(@RequestParam(name = "nom") String nom, @RequestParam(name = "prenom") String prenom ,@RequestParam(name = "cin") String cin)  {
		//FIXME
		Client client = new Client(cin , nom , prenom , null);
		clientService.saveOrUpdate(client);
		return "redirect:/clients/all";
	}

	@GetMapping("/all")
	public ModelAndView getAll() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("clients", clientService.findAll());
		modelAndView.setViewName("clients"); // va à la page comptes.html (sans extension)
		return modelAndView;
	}
	
	@GetMapping("/all-json")
	@ResponseBody
	public List<Client> getAllJson() {
		return clientService.findAll();
	}

	
	@GetMapping("/allCin")
	@ResponseBody
	public List<String> getAllCin() {
		List<String> a = new ArrayList<String>();
		List<Client> c =clientService.findAll();
		
		
		 for (int i = 0; i < c.size(); i++) {
			 a.add(c.get(i).getCin());			 
		 }
		return a;
	}
	
	
	@PostMapping("/delete-ajax")
	@ResponseBody
	public void deleteAjax(@RequestParam(name = "cin") String cin) {
		clientService.delete(cin);
		}
	
	@PostMapping(value = "/update")
	public String update(@ModelAttribute Client client) {
		clientService.saveOrUpdate(client);
		return "redirect:/clients/all";
	}
	
	

	@GetMapping("/edit/{cin}")
	public ModelAndView edit(@PathVariable(name = "cin") String cin) {
		ModelAndView modelAndView = new ModelAndView();
		Client client = clientService.findById(cin);
		modelAndView.addObject("client", client);
		modelAndView.setViewName("edit-client");
		return modelAndView;
	}
	@GetMapping("/delete/{cin}")
	public String delete(@PathVariable(name = "cin") String cin) {
		clientService.delete(cin);
		return "redirect:/clients/all";
	}
}
