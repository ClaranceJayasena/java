package com.au.service;

import java.util.List;
import com.au.modelobject.SubjectObject;

/**
 * @author Clarance Jayasena
 */
public interface ResultService {
	
	public String getSubjectResult(String subject);
	public List<SubjectObject> getSubjects();

}
