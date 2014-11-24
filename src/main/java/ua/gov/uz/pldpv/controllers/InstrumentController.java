package ua.gov.uz.pldpv.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.gov.uz.pldpv.entities.Company;
import ua.gov.uz.pldpv.entities.Department;
import ua.gov.uz.pldpv.entities.Instrument;
import ua.gov.uz.pldpv.repositories.CompanyRepository;
import ua.gov.uz.pldpv.repositories.InstrumentRepository;

@Controller
@RolesAllowed({"COMPANY_ADMIN","ADMIN"})
public class InstrumentController {
	@Autowired
	InstrumentRepository instrumentRepository;
	@Autowired
	CompanyRepository companyRepository;
	@Autowired
	AccessConfirmationController accessConfirmation;
	
	@RequestMapping(value="instrument",params="add",method=RequestMethod.GET)
	public String getAddInstrument(Model model){
		model.addAttribute("railwayServices",accessConfirmation.getUsersRailwayServices());
		model.addAttribute("companies", accessConfirmation.getUserCompanies());
		return "instrument/add";
	}
	
	@RequestMapping(value="instrument",params="all",method=RequestMethod.GET)
	public String getAllInstrument(Model model){
		model.addAttribute("instruments",instrumentRepository.findByDepartmentIn(accessConfirmation.getDepartmentsForAuthenticateUser()));
		return "instrument/list";
	}
	@RequestMapping(value="instrument",params="edit",method=RequestMethod.GET)
	public String getEditInstrument(@RequestParam Long id,Model model){
		Instrument instrument=instrumentRepository.findOne(id);
		if (!accessConfirmation.accessConfirmation(instrument.getDepartment().getCompany().getId()))
			throw new AccessDeniedException("You have no permissions");
		
		model.addAttribute("instrument",instrument);
		return "instrument/edit";
	}
	
	@RequestMapping(value="instrument",params="view",method=RequestMethod.GET)
	public String getViewInstrument(@RequestParam Long id, Model model){
		Instrument instrument=instrumentRepository.findOne(id);
		if (!accessConfirmation.accessConfirmation(instrument.getDepartment().getCompany().getId()))
			throw new AccessDeniedException("You have no permissions");
		model.addAttribute(instrument);
		return "instrument/view";
	}
	
	@RequestMapping(value="instrument",params="add",method=RequestMethod.POST)
	public String postAddInstrument(){
		
		
		return "instrument/add";
	}
	

	
	
}
