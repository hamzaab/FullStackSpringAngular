package com.sip.ams.controllers;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sip.ams.entities.Etudiant;

@Controller
public class EtudiantController {
	
	List<Etudiant> etudiants =  new ArrayList<>() ;
	{
	Etudiant e1 = new Etudiant(1, "hamza", "hamza@gmail.com");
	Etudiant e2 = new Etudiant(2, "ali", "ali@gmail.com");
	Etudiant e3 = new Etudiant(3, "ahmed", "ahmed@gmail.com");
	etudiants.add(e1);
	etudiants.add(e2);
	etudiants.add(e3);
	}
	
	@RequestMapping("/home")
	public String message(Model model)
	{
		System.out.println("Bienvenue au BootCamp");
		String formation = "fullstack 100% Spring boot";
		String lieu ="Sesame";
		model.addAttribute("training", formation);
		model.addAttribute("location", lieu);
		return "info";
	}

	
	@RequestMapping("/produits")
	//public String listProduct(Model model)
	public ModelAndView listProduct(Model model)
	{	
		System.out.println("List Product");
		
		
		ModelAndView mv = new ModelAndView();
		List<String> produits =  new ArrayList<>() ;
		produits.add("voiture");
		produits.add("moto");
		produits.add("bus");
		produits.add("camion");
		
		
		//en commentaire : OLD method
		
		//model.addAttribute("mesP", produits); 
		mv.addObject("mesP", produits); 
		
	
		//return "products";
		mv.setViewName("products");
		return mv ;
		
	}

	
	@RequestMapping("/students")
	public ModelAndView listStudent(Model model)
	{	
		
		ModelAndView mv = new ModelAndView();
		
		
		System.out.println(etudiants);
		
		//en commentaire : OLD method
		
		//model.addAttribute("mesP", produits); 
		mv.addObject("mesEtudiant", etudiants); 
		
	
		//return "products";
		mv.setViewName("listeStudent");
		return mv ;
		
	}
	
	// @GetMapping("/add")
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addStudentForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addEtudiant");
		return mv;

	}
	 
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addStudent(@RequestParam("id") int id, @RequestParam("nomEtudiant") String nom,
			@RequestParam("email") String email) {
		// ModelAndView mv = new ModelAndView();
		// mv.setViewName("listStudents");
		// return mv;
		Etudiant e = new Etudiant(id, nom, email);
		etudiants.add(e);
		return "redirect:students";

	}

	
}