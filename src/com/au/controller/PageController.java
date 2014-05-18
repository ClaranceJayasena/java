package com.au.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.au.service.ResultService;

/**
 * @author Clarance Jayasena
 */

@Controller
public class PageController {
	
	@Autowired
	private ResultService resultService;		

	public ResultService getResultService() {
		return resultService;
	}
	public void setResultService(ResultService resultService) {
		this.resultService = resultService;
	}


	@RequestMapping(value="/resultpage",method = RequestMethod.GET)
	public String viewDeliveryMethod(HttpServletResponse res, HttpServletRequest req, Model model){		
		model.addAttribute("subjectlist",getResultService().getSubjects());
		return "resultpage";
	}

}
