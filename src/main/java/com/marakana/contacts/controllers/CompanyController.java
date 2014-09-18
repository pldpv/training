package com.marakana.contacts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.marakana.contacts.entities.Company;
import com.marakana.contacts.entities.RailwayService;
import com.marakana.contacts.repositories.CompanyRepository;
import com.marakana.contacts.repositories.RailwayServiceRepository;

@Controller
public class CompanyController {

	@Autowired
	RailwayServiceRepository railwayServiceRepository;
	@Autowired
	CompanyRepository companyRepository;

	@RequestMapping(value = "/company", params = "add", method = RequestMethod.GET)
	public String getAddCompany(
			@RequestParam("railwayService_id") long railwayServiceId,
			Model model) {
		model.addAttribute("railwayService",
				railwayServiceRepository.findOne(railwayServiceId));
		return "admin/company/add";
	}

	@RequestMapping(value = "/company", params = "edit", method = RequestMethod.GET)
	public String getEditCompany(@RequestParam long id, Model model) {
		Company company = companyRepository.findOne(id);
		model.addAttribute("company", company);
		return "admin/company/edit";
	}

	@RequestMapping(value = "/company", method = RequestMethod.GET)
	public String getViewCompany(@RequestParam long id, Model model) {
		model.addAttribute("company", companyRepository.findOne(id));
		return "admin/company/view";
	}

	@RequestMapping(value = "/company", params = "add", method = RequestMethod.POST)
	public String postAddCompany(
			@RequestParam("railwayService_id") long railwayServiceId,
			@RequestParam String name, @RequestParam String director) {
		RailwayService railwayService = railwayServiceRepository
				.findOne(railwayServiceId);
		Company company = new Company(name, director, null, null,
				railwayService);
		company = companyRepository.save(company);
		return "redirect:" + company.getUrl();
	}

	@RequestMapping(value = "/company", params = "edit", method = RequestMethod.POST)
	public String postEditCompany(@RequestParam long id,
			@RequestParam String name, @RequestParam String director) {
		Company company = companyRepository.findOne(id);
		company.setName(name);
		company.setDirector(director);
		company = companyRepository.save(company);
		return "redirect:" + company.getUrl();
	}

	@RequestMapping(value = "/company", params = "delete", method = RequestMethod.POST)
	public String postDeleteCompany(@RequestParam long id) {
		Company company=companyRepository.findOne(id);
		companyRepository.delete(company);
		return "redirect:"+company.getRailwayService().getUrl();
	}
}
