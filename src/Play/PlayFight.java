package Play;

import java.util.Scanner;

import Monster.Monster;
import Monster.Goblin;

public class PlayFight {
	private static Scanner scan = new Scanner(System.in);

	public static void fight() {
		Monster mon;
		int monNo = (int) (Math.random() * 2);
		if (monNo == 0) {
			mon = new Goblin();
		} else {
			mon = new Goblin();
		}

		System.out.println("전투가 시작 됩니다.");
		System.out.println(mon.name + "를 만났습니다.");

		boolean fight = true;

		while (fight) {
			System.out.println("--------------------------");
			System.out.println("1.공격 | 2." + PlayMain.character.skillName + " | 3.도망가기 | 4.긴급물약(2,000G");
			System.out.println("0.메인화면");
			System.out.println("--------------------------");
			System.out.print("선택> ");

			int att = scan.nextInt();

			if (att == 1) {
				System.out.println("공격!");
				int dmg = ((int) PlayMain.character.ATK - mon.DEF);
				int attEva = (int) ((Math.random() * 100) - (mon.DEF));
				if (attEva == 0) {
					System.out.println(mon.name + "이 회피 하였습니다.");
				} else {
					if (dmg <= 0) {
						System.out.println("몬스터의 방어력이 높습니다");
						System.out.println(" 0의 데미지...");
					} else {
						System.out.println(mon.name + "에게 " + dmg + "의 데미지!");
						mon.HP -= dmg;
					}
					System.out.println("남은 몬스터 HP : " + mon.HP);
					if ((mon.HP) <= 0) {
						System.out.println("사냥에 성공 하였습니다.");
						int monExp = 0;
						int exep = PlayMain.character.Lv - mon.Lv;
						if (exep > 0) {
							monExp += (int) ((mon.EXP) / exep);
						} else if (exep < 0) {
							monExp += ((mon.EXP) * (exep * -1));
						} else if (exep == 0) {
							monExp += mon.EXP;
						}
						PlayMain.character.EXP += monExp;
						if (PlayMain.character.EXP == 100) {
							PlayMain.character.EXP -= 100;
							PlayMain.character.STR++;
							PlayMain.character.DEX++;
							PlayMain.character.Lv++;
							if (PlayMain.character.Lv % 2 == 0) {
								PlayMain.character.INT++;
								PlayMain.character.LUK++;
							}
							PlayMain.character.upDate();
							System.out.println("*** 레벨 업 ***");
							System.out.println("HP를 모두 회복 합니다.");
							PlayMain.character.HP = PlayMain.character.maxHP;
						}
						PlayMain.character.Gold += mon.dropGold;
						System.out.println("획득 골드 + " + mon.dropGold);
						System.out.println("소지 골드 : " + PlayMain.character.Gold);
						System.out.println("EXP + " + monExp);
						System.out.println("현재 EXP : " + PlayMain.character.EXP);
						PlayGame.start();
					}
				}
			} else if (att == 2) {
				System.out.println(PlayMain.character.skillName + " 공격!");
				int dmg = ((int) ((PlayMain.character.ATK - mon.DEF) * 1.5));
				int attEva = (int) ((Math.random() * 100) - (mon.DEF));
				if (attEva == 0) {
					System.out.println(mon.name + "이 회피 하였습니다.");
				} else {
					if (dmg <= 0) {
						System.out.println("몬스터의 방어력이 높습니다");
						System.out.println(" 0의 데미지...");
					} else {
						System.out.println(mon.name + "에게 " + dmg + "의 데미지!");
						mon.HP -= dmg;
					}
					System.out.println("남은 몬스터 HP : " + mon.HP);
					if ((mon.HP) <= 0) {
						System.out.println("사냥에 성공 하였습니다.");
						int monExp = 0;
						int exep = PlayMain.character.Lv - mon.Lv;
						if (exep > 0) {
							monExp += (int) ((mon.EXP) / exep);
						} else if (exep < 0) {
							monExp += ((mon.EXP) * (exep * -1));
						} else if (exep == 0) {
							monExp += mon.EXP;
						}
						PlayMain.character.EXP += monExp;
						if (PlayMain.character.EXP == 100) {
							PlayMain.character.EXP -= 100;
							PlayMain.character.STR++;
							PlayMain.character.DEX++;
							PlayMain.character.Lv++;
							if (PlayMain.character.Lv % 2 == 0) {
								PlayMain.character.INT++;
								PlayMain.character.LUK++;
							}
							PlayMain.character.upDate();
							System.out.println("*** 레벨 업 ***");
							System.out.println("HP를 모두 회복 합니다.");
							PlayMain.character.HP = PlayMain.character.maxHP;
						}
						PlayMain.character.Gold += mon.dropGold;
						System.out.println("획득 골드 + " + mon.dropGold);
						System.out.println("소지 골드 : " + PlayMain.character.Gold);
						System.out.println("EXP + " + monExp);
						System.out.println("현재 EXP : " + PlayMain.character.EXP);
						PlayGame.start();
					}
				}
			} else if (att == 3) {
				PlayGame.start();
			} else if (att == 4) {
				if (PlayMain.character.Gold >= 2000) {
					PlayMain.character.Gold -= 2000;
					PlayMain.character.HP = PlayMain.character.maxHP;
					System.out.println("HP를 모두 회복 합니다.");
					System.out.println("현재 HP : " + PlayMain.character.HP);
					System.out.println("보유 골드 : " + PlayMain.character.Gold);
				} else if (PlayMain.character.Gold < 2000) {
					System.out.println("골드가 부족 합니다.");
					System.out.println("보유 골드 : " + PlayMain.character.Gold);
					System.out.println("마을로 돌아 갑니다.");
					PlayGame.start();
				}
			} else if (att == 0) {
				PlayMain.character = null;
				PlayMain.main(null);
			}
			System.out.println("--------------------------");
			System.out.println(mon.name + "의 공격");
			int monDmg = ((int) (mon.ATK - PlayMain.character.DEF));
			int monAttEva = (int) ((Math.random() * 100) - (PlayMain.character.DEF));
			if (monAttEva == 0) {
				System.out.println(mon.name + "이 회피 하였습니다.");
			} else {
				if (monDmg <= 0) {
					System.out.println("방어력이 높습니다");
					System.out.println(" 0의 데미지...");
				} else {
					System.out.println(mon.name + "에게 " + monDmg + "의 데미지를 받았습니다.");
					PlayMain.character.HP -= monDmg;
				}
				System.out.println("남은 HP : " + PlayMain.character.HP);
				if ((PlayMain.character.HP) <= 0) {
					System.out.println("사망 하였습니다.");
					System.out.println("메인으로 돌아 갑니다.");
					PlayMain.character = null;
					PlayMain.main(null);
				}
			}
		}

	}
}
