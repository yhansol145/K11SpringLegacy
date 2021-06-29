package autoscan;

import java.util.Random;

import org.springframework.stereotype.Repository;

@Repository
public class LottoDAO {
	
	public LottoDAO() {
		System.out.println("LottoDAO생성자 호출");
	}
	
	//1~6사이의 난수를 생성한다.
	public int getLottoNumber() {
		Random rand = new Random();
		//생성된 난수는 서비스 객체로 반환한다.
		return rand.nextInt(6)+1;
	}

}
