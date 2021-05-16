package Character;

public class Character {
	public String name;

	public int TYPE;

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

	public String skillName;
	public int skillCost;
	public String item[] = new String[100];

	public void upDate() {
		maxHpMp();
		hpMp();
		stat();
		sC();
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
		ATK = ((((double) STR * 2) + ((double) DEX * 0.5) + ((double) LUK * 0.5)) / 2);
		DEF = ((((double) STR * 1) + ((double) DEX * 2) + ((double) LUK * 0.5)) / 4);
		mATK = ((((double) INT * 2) + ((double) DEX * 0.5) + ((double) LUK * 0.5)) / 2);
		mDEF = ((((double) INT * 1) + ((double) DEX * 2) + ((double) LUK * 0.5)) / 4);
	}

	public void sC() {
		this.skillCost = this.Lv * 2;
	}

	public void LvUp() {
		if (TYPE == 0) {
			EXP -= 100;
			STR++;
			DEX++;
			Lv++;
			if (Lv % 2 == 0) {
				INT++;
				LUK++;
			}
		} else if (TYPE == 1) {
			EXP -= 100;
			INT++;
			DEX++;
			Lv++;
			if (Lv % 2 == 0) {
				STR++;
				LUK++;
			}
		}
		upDate();

		System.out.println("*** 레벨 업 ***");
		System.out.println("-------------------------------");
		System.out.println("Lv : " + Lv);
		System.out.println("EXP : " + EXP);
		System.out.println();
		System.out.println("스탯 : ");
		System.out.println("공격력 : " + ATK);
		System.out.println("방어력 : " + DEF);
		System.out.println("최대 HP : " + maxHP);
		System.out.println("최대 MP : " + maxMP);
		System.out.println("힘 : " + STR);
		System.out.println("민첩 : " + DEX);
		System.out.println("지능 : " + INT);
		System.out.println("운 : " + LUK);
		System.out.println("-------------------------------");
		System.out.println();
	}
}