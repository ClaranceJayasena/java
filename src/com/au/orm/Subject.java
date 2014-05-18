package com.au.orm;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Clarance Jayasena
 */

@Entity
@Table(name="Subject")
public class Subject {
	
	public int subjectId;
	private String subjectName;	
	private List<Subject> subject;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SUB_Id")
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	
	@Column(name="SUB_Name",length=200)
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}	

	@OneToMany(targetEntity=Result.class,mappedBy="subject",fetch=FetchType.LAZY)
	public List<Subject> getSubject() {
		return subject;
	}
	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}
	
	

}
