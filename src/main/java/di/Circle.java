package di;

//그래프 상에서 원을 표현한 클래스
public class Circle {
	
	//중심점에 해당하는 Point객체와 반지름을 멤버변수로 가짐
	Point point;
	int radian;
	
	//생성자 없이 getter, setter만 정의
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	public int getRadian() {
		return radian;
	}
	public void setRadian(int radian) {
		this.radian = radian;
	}
	
	@Override
	public String toString() {
		return point + "반지름:"+ radian;
	}

}
