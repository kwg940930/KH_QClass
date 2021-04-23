package com.el.dto;

public class Score {
	
	private int kor;
	private int eng;
	private int math;
	private String name;
	private int sum;
	private Double avg;
	private String grade;
	
	public Score(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng= eng;
		this.math = math;
		setSum();
		setAvg();
		setGrade();
	}
	
	public Score(String name, int kor, int eng, int math,  int sum, Double avg, String grade) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.name = name;
		this.sum = sum;
		this.avg = avg;
		this.grade = grade;
	}
	public Score() {
		super();
	}
	public int getSum() {
		return sum;
	}
	public void setSum() {
		this.sum = kor + eng + math;
	}
	public Double getAvg() {
		return avg;
	}
	public void setAvg() {
		this.avg = getSum()/3.0;
	}
	public String getGrade() {
		return grade;
	}
	
	public void setGrade() {
		
		if(getAvg() <= 100 && 90 <= getAvg()) {
			grade = "A";
		}else if(getAvg() < 90 && 80 <= getAvg()) {
			grade = "B";
		}else if(getAvg() < 80 && 70 <= getAvg()){
			grade = "C";
		}else if(getAvg() < 70 && 60 <= getAvg()) {
			grade = "D";
		}else {
			grade = "F";
		}
	}
	
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
