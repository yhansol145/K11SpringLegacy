package di;

import java.util.ArrayList;

public class Person {
	
	//3가지 형식의 멤버변수 선언
	private String name;
	private int age;
	private ArrayList<String> hobbys;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public ArrayList<String> getHobbys() {
		return hobbys;
	}
	public void setHobbys(ArrayList<String> hobbys) {
		this.hobbys = hobbys;
	}
	
	//객체가 가진 정보를 문자열 형태로 반환
	public String getInfo() {
		return String.format("이름:%s<br/>"
				+ "나이:%s<br/>"
				+ "취미:%s<br/>", name, age, hobbys);
	}

}
