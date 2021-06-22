package common;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/*
유효성 검증을 위한 클래스 정의를 위해 Validator 인터페이스를 구현한다.
차후 supports(), validate() 두개의 메소드를 오버라이딩 한다.
 */
public class MemberValidator implements Validator{
	
	/*
	supports()
		: 매개변수로 전달된 객체가 유효성 검증을 지원할 수 있는
		커맨드 객체인지 판단한다. 만약 해당 메소드를 통과하지 못하면
		유효성 검증을 위한 validate() 메소드는 아예 호출되지 않는다.
		해당 메소드는 자동으로 호출된다.
	 */
	@Override
	public boolean supports(Class<?> clazz) { 
		return MemberDTO.class.isAssignableFrom(clazz);
	}
	
	/*
	validate()
		: supports()가 true를 반환하는 경우에만 호출되는 메소드로
		실제 폼값에 대한 검증을 진행한다.
		매개변수1 : 폼값을 저장한 커맨드 객체
		매개변수2 : 에러정보를 저장할 Errors 타입의 변수
	 */
	@Override
	public void validate(Object obj, Errors errors) {
		
		System.out.println("validate() 메소드 호출됨");
		
		//커맨드객체를 Object로 받으므로 사용하기 위해 형변환 필요
		MemberDTO memberDTO = (MemberDTO)obj;
		
		//검증1 : 단순 if문을 사용하는 방식(아이디 검증)
		String member_id = memberDTO.getId();
		if(member_id==null || member_id.trim().isEmpty()) {
			System.out.println("아이디가 null입니다. ㅜㅜ");
			//검증에 실패한 경우 해당 메소드를 통해 검증결과 반환
			errors.rejectValue("id", "idError");
		}
		
		//검증2 : 내장메소드를 통한 검증(패스워드 검증)
		/*
		유효성 검증을 위해 전달되는 객체는 커맨드객체가 아니라면 validate()
		메소드 내 진입자체가 불가능하므로, 해당 함수에서 "pw"라는 문장은
		getter()를 호출하여 저장된 패스워드를 얻어온다고 생각하면 된다.
		 */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pw", "pwError");
		
		//검증3 : 사용자정의 메소드를 통해 검증(이름 검증)
		boolean nameValidate = myEmptyOrWhitespace(memberDTO.getName());
		if(nameValidate==false) {
			System.out.println("이름이 null입니다. ㅠㅠ");
			errors.rejectValue("name", "nameError");
		}
	}
	
	//사용자정의 메소드 : 값이 null이거나 길이가 0일때 false반환
	public boolean myEmptyOrWhitespace(String value) {
		if(value==null || value.trim().length()==0) {
			return false;
		}
		else {
			return true;
		}
	}
}
