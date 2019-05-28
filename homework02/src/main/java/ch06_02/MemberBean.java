package ch06_02; 

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MemberBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;   			
	private Integer year;   			
	private Integer week;       			
	private String type;    			
	private String age;     			
	private String county;		
	private Integer visit;	
	private Integer tatlevisits;				
	
	public MemberBean() {
	} 
	
	public MemberBean(Integer id, Integer year, Integer week, String type, String age, String county,
			Integer visit, Integer tatlevisits) {
		super();
		this.id = id;
		this.year = year;
		this.week = week;
		this.type = type;
		this.age = age;
		this.county = county;
		this.visit = visit;
		this.tatlevisits = tatlevisits;
	}
	public String toString() {
		return "["+id+","+year+","+week+","+type+","+age+","+county+","+visit+","+tatlevisits+"]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getWeek() {
		return week;
	}

	public void setWeek(Integer week) {
		this.week = week;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public Integer getVisit() {
		return visit;
	}

	public void setVisit(Integer visit) {
		this.visit = visit;
	}

	public Integer getTatlevisits() {
		return tatlevisits;
	}

	public void setTatlevisits(Integer tatlevisits) {
		this.tatlevisits = tatlevisits;
	}	

}