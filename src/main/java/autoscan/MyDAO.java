package autoscan;

import org.springframework.stereotype.Repository;

/*
servlet-context.xml에서 component-scan으로 설정된 기본패키지에서
모델(Model) 클래스 역할을 부여하기 위한 어노테이션
스프링 컨테이너 시작시 자동으로 스캔되어 빈이 생성된다.
 */
@Repository
public class MyDAO {
	
	public MyDAO() {
		System.out.println("MyDAO 생성자 호출");
	}
	
	//CRUD 작업을 진행한다.
	public void selectList() {
		System.out.println("게시판의 리스트를 출력합니다.");
	}

}
