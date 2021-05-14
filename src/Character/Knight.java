package Character;

public class Knight extends Character {
	public Knight() {
		name = "기사";
		skillName = "강타";
		STR = 10;
		DEX = 10;
		INT = 4;
		LUK = 4;
		ATK = ((((double) STR * 10) + ((double) DEX * 0.5) + ((double) LUK * 0.5)) / 2);
		DEF = ((((double) STR * 1) + ((double) DEX * 5) + ((double) LUK * 10)) / 2);
		mATK = ((((double) INT * 10) + ((double) DEX * 0.5) + ((double) LUK * 0.5)) / 2);
		mDEF = ((((double) INT * 1) + ((double) DEX * 5) + ((double) LUK * 10)) / 2);
	}

}
