package autoscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LottoService {
	
	public LottoService() {
		System.out.println("LottoService생성자 호출");
	}
	
	/*
	서비스 객체는 비즈니스 로직을 수행하는 중 DB작업이 필요한 경우
	Model을 호출하므로 DAO 빈을 자동주입 받는다.
	 */
	@Autowired
	LottoDAO lottoDAO = null;
	
	//DAO에서 생성한 난수와 매개변수로 전달된 수를 비교한다.
	public LottoVO getLottoProcess(int lottoNum, LottoVO lottoVO) {
		
		//DAO를 호출하여 난수를 생성한다.
		int randomNumber = lottoDAO.getLottoNumber();
		//DAO가 반환한 난수를 VO객체에 저장한다.
		lottoVO.setRandomLottoNum(randomNumber);
		
		//번호를 로그에 출력한다.
		System.out.println("--- 난수: " + randomNumber);
		System.out.println("--- 입력한 수: " + lottoNum);
		
		//두 번호를 비교해서 결과를 저장한다.
		if(randomNumber == lottoNum)
			lottoVO.setResult("추카추카");
		else
			lottoVO.setResult("아쉽..");
		
		return lottoVO;
	}

}
