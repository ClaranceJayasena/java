package com.au.dao;

import java.util.List;
import com.au.modelobject.SubjectObject;
import com.au.modelobject.SubjectResultObject;

/**
 * @author Clarance Jayasena
 */

public interface ResultDAO {
	
	public SubjectResultObject getSubjectResult(int subject);
	public List<SubjectObject> getSubjects();
}
