package autoscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
servlet-context.xml에서 component-scan으로 설정된 기본패키지에서
서비스 클래스 역할을 부여하기 위한 어노테이션
스프링 컨테이너 시작시 자동으로 스캔되어 빈이 생성된다.
 */
@Service
public class MyService {
	
	public MyService() {
		System.out.println("MyService 생성자 호출");
	}
	//DAO객체를 자동주입 받는다.
	MyDAO myDAO;
	@Autowired
	public void setMyDAO(MyDAO myDAO) {
		this.myDAO = myDAO;
		System.out.println("setMyDAO()호출-MyService");
	}
	/*
	해당 요청에 대한 비즈니스로직을 처리한다. 처리 중 DB작업이
	필요하다면 Model(DAO)을 호출한다.
	 */
	public void execute() {
		//DAO의 메소드를 호출
		myDAO.selectList();
	}

}
