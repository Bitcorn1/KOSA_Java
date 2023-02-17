package test;

class MyClass {
	// 1. 생성자
	public MyClass() {
		
	}
	// 2. 필드(private)
	private int cost;
	// 3. 메소드
	
	// 4. setter & getter
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
}

public class Test {
	
	public static void main(String[] args) {
		MyClass obj = new MyClass();
		// 객체의 메소드를 이용해 객체의 필드를 제어함
		obj.setCost(100);
		// 이런 과정을 stateful이라고 함. 객체가 가지는 정보를 인스턴스 필드에 직접 저장하는
		// 방식을 지칭! 객체가 스테이트 정보 상태를 들고다니는 느낌
		// 이거에 반대되는 것이 stateless(무상태) 인스턴스가 데이터를 안가지고 있다 즉 필드를 사용하지않는다
		// 필드에 데이터를 저장하고 있지 않다 필드 사용하지 않는다.
		// 인스턴스 필드를 사용하지 않음. 필드 사용하면 해당 필드에 데이터 존재하고 서블릿 쓰레드 사용하면
		// 보통 스테이트리스 방식으로 사용함
	}
}

