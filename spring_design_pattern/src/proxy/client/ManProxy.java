package proxy.client;

public class ManProxy {
	
	public void develop() {
		
		System.out.println("출근 카드를 찍는다.");
		
		try {
			new Man().develop();
		} catch (Exception e) {
			System.out.println("쉬는 날이었다.");
		} finally {
			System.out.println("집에 간다.");
		}
	}

}
