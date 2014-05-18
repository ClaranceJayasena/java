package com.au.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.au.service.ResultService;
import com.au.util.ValidateUtil;

/**
 * @author Clarance Jayasena
 */

@Controller
public class ResultController {
	
	@Autowired
	private ResultService resultService;
	
	public ResultService getResultService() {
		return resultService;
	}
	public void setResultService(ResultService resultService) {
		this.resultService = resultService;
	}

	 @ResponseBody	
	 @RequestMapping(value = "/result.html", method = RequestMethod.GET)
	 public void fetchFlowDowns(HttpServletResponse resp, HttpServletRequest req) throws Exception {
	
		String subject = req.getParameter("subject");
		
		if(ValidateUtil.isValidString(subject)){
			resp.setContentType("text/html");
			resp.setHeader("Cache-Control", "no-cache");			
			PrintWriter out = resp.getWriter();			
			out.write(getResultService().getSubjectResult(subject));					
			out.close();	
		}

	}

}
