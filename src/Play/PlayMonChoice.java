package Play;

import Monster.Goblin;
import Monster.Monster;

public class PlayMonChoice {
	
	public static Monster mon;
	
	public static void MonChoice() {
		int monNo = (int) (Math.random() * 2);
		if (monNo == 0) {
			mon = new Goblin();
		} else {
			mon = new Goblin();
		}
	}

}
