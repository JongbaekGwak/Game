package Play;

public class PlayFight {

	public static void fight() {

		System.out.println("전투가 시작 됩니다.");

		boolean fight = true;

		while (fight) {
			System.out.println("-------------------------------");
			System.out.println("1.공격 | 2.스킬(" + PlayMain.character.skillName + ") | 3.도망가기");
			System.out.println("4.긴급물약(2,000G)");
			System.out.println("0.메인화면");
			System.out.println("-------------------------------");
			System.out.print("선택> ");

			int att = PlayMain.scan.nextInt();

			if (att == 1) {
				System.out.println("-------------------------------");
				System.out.println("공격!");
				System.out.println();
				int dmg = ((int) PlayMain.character.ATK - PlayMonChoice.mon.DEF);
				int mDmg = ((int) PlayMain.character.mATK - PlayMonChoice.mon.mDEF);
				int attEva = (int) ((Math.random() * 100) - (PlayMonChoice.mon.LUK));
				if (attEva <= 0) {
					System.out.println("-------------------------------");
					System.out.println(PlayMonChoice.mon.name + "이 회피 하였습니다.");
					System.out.println("-------------------------------");
				} else {
					if (PlayMain.character.TYPE == 1) {
						if (dmg <= 0) {
							System.out.println("몬스터의 방어력이 높습니다");
							System.out.println(" 0의 데미지...");
							System.out.println();
						} else {
							System.out.println(PlayMonChoice.mon.name + "에게 " + dmg + "의 데미지!");
							System.out.println();
							PlayMonChoice.mon.HP -= dmg;
						}
					} else if (PlayMain.character.TYPE == 2) {
						if (mDmg <= 0) {
							System.out.println("몬스터의 마법 방어력이 높습니다");
							System.out.println(" 0의 데미지...");
							System.out.println();
						} else {
							System.out.println(PlayMonChoice.mon.name + "에게 " + mDmg + "의 데미지!");
							System.out.println();
							PlayMonChoice.mon.HP -= mDmg;
						}
					}
					if (PlayMonChoice.mon.HP <= 0) {
						PlayMonChoice.mon.HP = 0;
					}
				}
			} else if (att == 2) {

				if (PlayMain.character.MP < PlayMain.character.skillCost) {
					System.out.println("-------------------------------");
					System.out.println("마나가 부족하여 스킬을 사용할 수 없습니다.");
					System.out.println("-------------------------------");
				} else {
					System.out.println("-------------------------------");
					System.out.println(PlayMain.character.skillName + " 공격!");
					System.out.println();

					int dmg = ((int) ((PlayMain.character.ATK - PlayMonChoice.mon.DEF) * 1.5));
					int mDmg = ((int) ((PlayMain.character.INT - PlayMonChoice.mon.mDEF) * 1.5));

					int attEva = (int) ((Math.random() * 100) - (PlayMonChoice.mon.LUK));
					if (attEva == 0) {
						System.out.println("-------------------------------");
						System.out.println(PlayMonChoice.mon.name + "이 회피 하였습니다.");
						System.out.println("-------------------------------");

					} else {
						if (PlayMain.character.TYPE == 1) {
							if (dmg <= 0) {
								System.out.println("몬스터의 방어력이 높습니다");
								System.out.println(" 0의 데미지...");
								System.out.println();
							} else {
								System.out.println(PlayMonChoice.mon.name + "에게 " + dmg + "의 데미지!");
								System.out.println();
								PlayMonChoice.mon.HP -= dmg;
							}
						} else if (PlayMain.character.TYPE == 2) {
							if (mDmg <= 0) {
								System.out.println("몬스터의 마법 방어력이 높습니다");
								System.out.println(" 0의 데미지...");
								System.out.println();
							} else {
								System.out.println(PlayMonChoice.mon.name + "에게 " + mDmg + "의 데미지!");
								System.out.println();
								PlayMonChoice.mon.HP -= mDmg;
							}
						}
						PlayMain.character.MP -= PlayMain.character.skillCost;
						if (PlayMonChoice.mon.HP <= 0) {
							PlayMonChoice.mon.HP = 0;
						}
					}
				}

			} else if (att == 3) {
				PlayGame.start();
			} else if (att == 4) {
				if (PlayMain.character.Gold >= 2000) {
					PlayMain.character.Gold -= 2000;
					PlayMain.character.upDate();
					System.out.println("-------------------------------");
					System.out.println("HP,MP를 모두 회복 합니다.");
					System.out.println("현재 HP : " + PlayMain.character.HP);
					System.out.println("현재 MP : " + PlayMain.character.MP);
					System.out.println("보유 골드 : " + PlayMain.character.Gold);
					System.out.println("-------------------------------");
				} else if (PlayMain.character.Gold < 2000) {
					System.out.println("-------------------------------");
					System.out.println("골드가 부족 합니다.");
					System.out.println("보유 골드 : " + PlayMain.character.Gold);
					System.out.println("-------------------------------");
					fight();
				}
			} else if (att == 0) {
				PlayMain.character = null;
				PlayMain.main(null);

			} else {
				System.out.println("-------------------------------");
				System.out.println("잘못된 번호를 입력 하셧습니다.");
				System.out.println("-------------------------------");
				fight();
			}

			if ((PlayMonChoice.mon.HP) <= 0) {
				System.out.println("사냥에 성공 하였습니다.");
				System.out.println();
				int monExp = 0;
				int exep = PlayMain.character.Lv - PlayMonChoice.mon.Lv;
				if (exep > 0) {
					monExp += (int) ((PlayMonChoice.mon.EXP) / exep);
				} else if (exep < 0) {
					monExp += ((PlayMonChoice.mon.EXP) * (exep * -1));
				} else if (exep == 0) {
					monExp += PlayMonChoice.mon.EXP;
				}
				PlayMain.character.EXP += monExp;
				PlayMain.character.Gold += PlayMonChoice.mon.dropGold;
				System.out.println("-------------------------------");
				System.out.println("획득 골드 + " + PlayMonChoice.mon.dropGold);
				System.out.println("소지 골드 : " + PlayMain.character.Gold);
				System.out.println("EXP + " + monExp);
				System.out.println("현재 EXP : " + PlayMain.character.EXP);
				System.out.println("-------------------------------");
				if (PlayMain.character.EXP >= 100) {
					PlayMain.character.LvUp();
				}

				PlayGame.start();
			}

			System.out.println("-------------------------------");
			System.out.println(PlayMonChoice.mon.name + "의 공격");
			System.out.println();

			int monDmg = ((int) (PlayMonChoice.mon.ATK - PlayMain.character.DEF));
			int monMDmg = ((int) (PlayMonChoice.mon.mATK - PlayMain.character.mDEF));
			int monAttEva = (int) ((Math.random() * 100) - (PlayMain.character.LUK));
			if (monAttEva <= 0) {
				System.out.println("-------------------------------");
				System.out.println(PlayMonChoice.mon.name + "이 회피 하였습니다.");
				System.out.println("-------------------------------");
			} else {

				if (PlayMonChoice.mon.TYPE == 1) {
					if (monDmg <= 0) {
						System.out.println("방어력이 높습니다");
						System.out.println(" 0의 데미지...");
						System.out.println();
					} else {
						System.out.println(PlayMonChoice.mon.name + "에게 " + monDmg + "의 데미지를 받았습니다.");
						System.out.println();
						PlayMain.character.HP -= monDmg;
					}
				} else if (PlayMonChoice.mon.TYPE == 2) {
					if (monMDmg <= 0) {
						System.out.println(" 마법 방어력이 높습니다");
						System.out.println(" 0의 데미지...");
						System.out.println();
					} else {
						System.out.println(PlayMonChoice.mon.name + "에게 " + monMDmg + "의 데미지를 받았습니다.");
						System.out.println();
						PlayMain.character.HP -= monMDmg;
					}
				}
				if (PlayMain.character.HP <= 0) {
					PlayMain.character.HP = 0;
				}
				if ((PlayMain.character.HP) <= 0) {
					System.out.println("-------------------------------");
					System.out.println("사망 하였습니다.");
					System.out.println("메인으로 돌아 갑니다.");
					System.out.println("-------------------------------");
					PlayMain.character = null;
					PlayMain.main(null);
				}
			}
			System.out.println("-------------------------------");
			System.out.println("남은 HP : " + PlayMain.character.HP);
			System.out.println("남은 마나 : " + PlayMain.character.MP);
			System.out.println("남은 몬스터 HP : " + PlayMonChoice.mon.HP);
			System.out.println("-------------------------------");

		}
	}

}
