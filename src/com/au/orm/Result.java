package com.au.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Clarance Jayasena
 */

@Entity
@Table(name="Result")
public class Result {
	
	private int resultId;	
	private Subject subject;
	private School school;	
	private double y3;
	private double y5;
	private double y7;
	private double y9;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="RST_Id")
	public int getResultId() {
		return resultId;
	}
	public void setResultId(int resultId) {
		this.resultId = resultId;
	}
	
	@ManyToOne
	@JoinColumn(name="RST_Subject")
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	@ManyToOne
	@JoinColumn(name="RST_School")
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	
	@Column(name="RST_Y3")	
	public double getY3() {
		return y3;
	}
	public void setY3(double y3) {
		this.y3 = y3;
	}
	
	@Column(name="RST_Y5")	
	public double getY5() {
		return y5;
	}
	public void setY5(double y5) {
		this.y5 = y5;
	}
	
	@Column(name="RST_Y7")	
	public double getY7() {
		return y7;
	}
	public void setY7(double y7) {
		this.y7 = y7;
	}
	
	@Column(name="RST_Y9")	
	public double getY9() {
		return y9;
	}
	public void setY9(double y9) {
		this.y9 = y9;
	}

}
