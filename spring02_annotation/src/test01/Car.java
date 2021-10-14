package test01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//어노테이션으로 component를 등록해놓으면, component-scan 할 때 찾아서 이 클래스의 인스턴스를 bean으로 등록하라는 뜻
@Component 
public class Car {

	//@Autowired : 타입을 기준으로 빈을 찾아서 의존성 주입
	//				해당 타입의 빈이 2개 이상일 경우 빈의 id와 변수명을 기준으로 의존성 주입
	
	@Autowired //car의 bean을 등록하는 과정에서 (applicationContext에서 wheel타입의 bean을 찾아서 그 bean을 car의 wheel이라는 변수에 알아서 주입해줌
	@Qualifier(value="wheelBean") //주입 받을 bean의 아이디를 직접 지정할 수 있음(wheel 타입의 bean이 여러개 존재할경우 사용)
	private Wheel wheel;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(Wheel wheel) {
		super();
		this.wheel = wheel;
	}

	public Wheel getWheel() {
		return wheel;
	}

	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}

	@Override
	public String toString() {
		return "Car [wheel=" + wheel + "]";
	}
	
	

}
