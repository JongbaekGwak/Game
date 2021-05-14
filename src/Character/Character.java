package Character;

public class Character {
	public String name;
	
	public String skillName;
	
	public int Lv = 1;
	public int EXP = 0;
	
	public int Gold = 0;
	
	public int STR;
	public int DEX;
	public int INT;
	public int LUK;
	
	public int maxHP;
	public int maxMP;
	
	public int HP;
	public int MP;
	
	public double ATK;
	public double DEF;
	public double mATK;
	public double mDEF;
	
	public String item[] = new String[100];
	
	public void upDate() {
		maxHpMp();
		hpMp();
		stat();
	}
	
	public void maxHpMp() {
		maxHP = (STR * 10);
		maxMP = (INT * 10);
	}
	
	public void hpMp() {
		HP = maxHP;
		MP = maxMP;
	}
	
	public void stat() {
		ATK = ((((double) STR * 10) + ((double) DEX * 0.5) + ((double) LUK * 0.5)) / 2);
		DEF = ((((double) STR * 1) + ((double) DEX * 5) + ((double) LUK * 10)) / 2);
		mATK = ((((double) INT * 10) + ((double) DEX * 0.5) + ((double) LUK * 0.5)) / 2);
		mDEF = ((((double) INT * 1) + ((double) DEX * 5) + ((double) LUK * 10)) / 2);
	}
	
	
}
