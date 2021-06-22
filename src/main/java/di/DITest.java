package di;

class Person {
	String name;
	int age;
	//public Person() {}
	private Person() {}
}

public class DITest {
	
	/*
	강한결합(독립성 낮음) : new를 통해 직접 객체를 생성
		결합도가 높기 때문에 Person클래스의 변화에 직접적인 영향을 받음
	 */
	public static void aPerson() {
		Person person1 = new Person();
		person1.name = "홍길동";
	}
	
	/*
	약한결합(독립성 높음) : 미리 생성된 객체를 주입(Injection)받음
		결합도가 낮아지기 때문에 Person클래스에 변화가 생기더라도
		직접적인 영향을 받지 않는다. 또한 코드도 좀 더 간결해짐
	 */
	public static void bPerson(Person p) {
		p.age = 35;
	}
	
	public static void main(String[] args) {
		
	}

}
