package com.project.thecode.controllers;

import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodeController{
	//Member variables go here
	private String code = "bushido";

	public CodeController(){

	}
	
	@RequestMapping("")
	public String index(@ModelAttribute("errs") String errs){
		System.out.println(errs);
		return "index";
	}
	@PostMapping("/guess")
	public String guess(@RequestParam("guess") String guess, RedirectAttributes flash){
		if (guess.equals(code)){
			return "redirect:/success";
		} else {
			flash.addFlashAttribute("errs", "You must train harder!");
			return "redirect:/";
		}
	}
	@RequestMapping("/success")
	public String success(){
		return "success";
	}	
}
