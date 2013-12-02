package cn.nbcc.chap04.entities;

import java.util.ArrayList;
import java.util.Date;

public class CourseSession {
	private String csID;

	private ArrayList<Student> students = new ArrayList<Student>();
	private Date startDate;
	
	public CourseSession(String csID, Date startDate) {
		super();
		this.csID = csID;
		this.startDate = startDate;
	}
	
	
	

}
