package com.kosmo.k11springlegacy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import autoscan.LottoService;
import autoscan.LottoVO;
import autoscan.MyService;

/*
servlet-context.xml에서 component-scan으로 설정된 기본패키지에서
컨트롤러 클래스 역할을 부여하기 위한 어노테이션
스프링 컨테이너 시작시 자동으로 스캔되어 빈이 생성된다.
 */
@Controller
public class ServiceController {
	
	/*
	서비스 객체를 주입받는다. @Autowired는 멤버변수, 생성자, 
	setter메소드에 사용할 수 있다.
	 */
	MyService myService;
	@Autowired
	public void setMyService(MyService myService) {
		this.myService = myService;
		System.out.println("setMyService()호출-ServiceController");
	}
	
	/*
	컨트롤러는 요청을 분석한 후 적절한 서비스 객체를 호출한다.
	이때 컨트롤러가 받은 모든 요청(request객체)을 모두 전달한다.
	 */
	@RequestMapping("/service/myService.do")
	public String myService() {
		myService.execute();
		return "07Service/myService";
	}
	
	
	/*
	서비스 객체의 호출을 위해 빈을 자동주입 받는다.
	일반적으로 setter메소드 없이 멤버변수에 직접 어노테이션을
	부착한다.
	 */
	@Autowired
	private LottoService lottoService;
	
	/*
	사용자가 HTML페이지에서 링크를 클릭할때 전달하는 userLottoNum 파라미터를
	lottoVO 객체가 받아서 사용하게 된다.
	 */
	@RequestMapping("/service/myLotto.do")
	public String myLotto(LottoVO lottoVO, Model model) {
		
		//커맨드객체를 통해 전달받은 파라미터를 getter를 통해 얻어와서
		//getLottoProcess() 메소드로 전달한다.
		lottoVO = lottoService.getLottoProcess(lottoVO.getUserLottoNum(),
				lottoVO);
		return "07Service/myLotto";
	}
	
}
