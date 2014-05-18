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
@Table(name="School")
public class School {
	
	private int schoolId;
	private String schoolName;
	private List<Result> school;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SCH_Id")
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	
	@Column(name="SHC_Name",length=200)
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	@OneToMany(targetEntity=Result.class,mappedBy="school",fetch=FetchType.LAZY)
	public List<Result> getSchool() {
		return school;
	}
	public void setSchool(List<Result> school) {
		this.school = school;
	}
	

}
