
public class Character {
	String name;
	String skillQ;
	String skillW;
	String skillE;
	String skillR;

	protected void move() {
		System.out.println("이동 합니다");
	}

	protected void attack() {
		System.out.println("공격 합니다");
	}

	protected void skill(String skillName) {
		System.out.println(skillName + " 스킬 합니다");
	}

	protected void stop() {
		System.out.println("멈춥니다");
	}
	
	protected void cell(String item) {
		System.out.println(item + " 을 구입 합니다");
	}
	
	
}
