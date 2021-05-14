package Character;

public class Character {
	public String name;
	public String skillName;
	public int Lv = 1;
	public int EXP =0;
	public int Gold =0;
	public int STR;
	public int DEX;
	public int INT;
	public int LUK;
	public final int maxHP = (STR * 10);
	public final int maxMP = (INT * 10);
	public int HP = maxHP;
	public int MP = maxMP;
	public double ATK;
	public double DEF;
	public double mATK;
	public double mDEF;
	public String item[] = new String[100];
}
