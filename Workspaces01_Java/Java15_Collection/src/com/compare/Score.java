package com.compare;

public class Score implements Comparable{
	
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	//기본 생성자, 파라미터 4개 생성자
	public Score() {
		
	}
	public Score(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	
	//getter setter
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

	
	
	
	
	public int getSum() {
		int sum = kor + eng + math;
		return sum;
	}
	public double getAvg() {
		double avg = (double)(kor + eng + math) / 3;
		return avg;
	}
	public String getGrade() {
		switch((int)getAvg()/ 10) {
		case 10:
		case 9:
			return "A";
		case 8:
			return "B";
		case 7:
			return "C";
		case 6:
			return "D";
		}
			return "F";
	}
	public String toString() {
		return String.format("이름 : %s\t 국어 : %d\t 영어 : %d\t 수학 : %d\n총점 : %d\t 평균 : %.2f\t 등급 : %s"
				, name, kor, eng, math, getSum(), getAvg(),getGrade());
	}
	
	@Override
	public int compareTo(Object o) {
		Score other = (Score) o;
		
		// 1 이면 앞의 인자가 더 큰값
		// 0 이면 같은 값
		// -1 이면 뒤의 인자가 더 큰값
		if(this.getKor() > other.getKor()) {
			return 1;
		} else if(this.getKor() < other.getKor()){
			return -1;
		}
		
		//this.getKor() == other.getKor()
		return 0;
	}
	
	

}
