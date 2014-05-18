package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.au.dao.ResultDAO;
import com.au.modelobject.SubjectObject;
import com.au.util.ConvertUtil;
import com.google.gson.Gson;

/**
 * @author Clarance Jayasena
 */
@Service
@Qualifier("resultService")
public class ResultServiceImpl implements ResultService {
	
	@Autowired
	private ResultDAO resultDAO;	

	public ResultDAO getResultDAO() {
		return resultDAO;
	}
	public void setResultDAO(ResultDAO resultDAO) {
		this.resultDAO = resultDAO;
	}


	@Override
	public String getSubjectResult(String subject) {
		Gson gson = new Gson();
		return gson.toJson(getResultDAO().getSubjectResult(ConvertUtil.intConvert(subject)));	
	}

	@Override
	public List<SubjectObject> getSubjects() {		
		return getResultDAO().getSubjects();
	}

}
