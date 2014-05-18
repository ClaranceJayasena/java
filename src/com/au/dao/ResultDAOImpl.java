package com.au.dao;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.au.modelobject.SubjectObject;
import com.au.modelobject.SubjectResultObject;
import com.au.orm.Result;
import com.au.orm.Subject;
import com.au.util.logger;

/**
 * @author Clarance Jayasena
 */

@Repository
@Qualifier("resultDAO")
public class ResultDAOImpl implements ResultDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	 /**	
	 * @param subject Id of subject
	 * @return will return generated list of SubjectResult
	 */	
	@Override
	public SubjectResultObject getSubjectResult(int subject) {	
		
		logger.log("INFO", "Begin Retrieving Subject Result ... ", "sysuser");
		logger.log("INFO", "Subject parameter : " + subject, "sysuser");
					
		SubjectResultObject resultObject = new SubjectResultObject(); 		
		List<String[]> schoolResult = new ArrayList<>();		
		DecimalFormat df = new DecimalFormat("##0.00");
		
		Session session = getSessionFactory().getCurrentSession();
		try{
			boolean x = false;
			session.beginTransaction();	
			
			resultObject.setSEcho(1);
			resultObject.setITotalRecords("57");
			resultObject.setITotalDisplayRecords("57");
			
			Query query =  session.createQuery("select r from School s, Subject b, Result r where s.schoolId = r.school and b.subjectId = r.subject and b.subjectId = :subId");
			query.setParameter("subId", subject);
			@SuppressWarnings("unchecked")
			List<Result> resultList = query.list();
			for(Result s : resultList){			
				
				String y3 = df.format(s.getY3());
				String y5 = df.format(s.getY5());
				String y7 = df.format(s.getY7());
				String y9 = df.format(s.getY9());				
				String result[] = {s.getSchool().getSchoolName(),y3,y5,y7,y9};					
				schoolResult.add(result);
			}
			
			session.getTransaction().commit();			
		}catch(RuntimeException e){	
			session.getTransaction().rollback();			
			logger.log("ERROR", "Exception occur try Retrieving Subject Result - " + e.toString(), "sysuser");
			logger.log("INFO", "Transaction Rollback .... ", "sysuser");
			e.printStackTrace();
		}finally{
			if(session.isOpen()) session.clear();
		}	
		
		resultObject.setAaData(schoolResult);
		logger.log("INFO", "Transaction Complete .... ", "sysuser");
		return resultObject;			
	}
	
	
	/**		 
	 * @return will return  list of Subject
	 */	
	@Override
	public List<SubjectObject> getSubjects() {
		logger.log("INFO", "Begin Retrieving Subject Result ... ", "sysuser");
		List<SubjectObject> resultlist = new ArrayList<>();		
		Session session = getSessionFactory().getCurrentSession();
		try{
			boolean x = false;
			session.beginTransaction();			
			Query query =  session.createQuery("from Subject");			
			@SuppressWarnings("unchecked")
			List<Subject> sch = query.list();
			for(Subject i : sch){	
				SubjectObject subjectObject = new SubjectObject();
				subjectObject.setSubjectId(i.getSubjectId());
				subjectObject.setSubjectName(i.getSubjectName());
				resultlist.add(subjectObject);					
			}			
			session.getTransaction().commit();			
		}catch(RuntimeException e){				
			session.getTransaction().rollback();
			e.printStackTrace();
			logger.log("ERROR", "Exception occur try Retrieving Subject Result - " + e.toString(), "sysuser");
			logger.log("INFO", "Transaction Rollback .... ", "sysuser");
		}finally{
			if(session.isOpen()) session.clear();
		}
		logger.log("INFO", "Transaction Complete .... ", "sysuser");
		return resultlist;	
	}

}
