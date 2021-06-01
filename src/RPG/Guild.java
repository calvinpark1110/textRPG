package RPG;

import java.util.ArrayList;

public class Guild {
	final int PARTY_SIZE = 4;
	static ArrayList<Unit> guildList = new ArrayList<>();
	Unit[] partyList;

	public void guildMenu() {
		while(true) {
			System.out.println("==========[길드관리]==============");
			System.out.println("[1] 길드관리 [2] 길드원 추가 [3] 길드원삭제 \n [4]파티원고체 [5]정렬 [0] 뒤로가기");
			int sel = MainGame.scan.nextInt();
			if(sel == 1) {
				printAllUnitStatus();
			}else if(sel == 2) {
				buyUnit();
			}else if(sel == 3) {
				removeUnit();
			}else if(sel == 4) {
				switchUnit();
			}else if(sel == 5) {
//				sort();
			}
		}
	}
	
	public void setGuild() {
		Unit temp = new Unit("호랑이", 1, 100, 10, 5, 0);
		guildList.add(temp);
		temp = new Unit("강아지", 1, 80, 7, 3, 0);
		guildList.add(temp);
		temp = new Unit("사슴", 1, 50, 3, 1, 0);
		guildList.add(temp);
		temp = new Unit("두더지", 1, 70, 5, 2, 0);
		guildList.add(temp);
		temp = new Unit("돼지", 1, 200, 4, 8, 0);
		guildList.add(temp);
		temp = new Unit("사자", 1, 120, 11, 7, 0);
		guildList.add(temp);

		for (int i = 0; i < PARTY_SIZE; i++) {
			guildList.get(i).party = true;
		}
		partyList = new Unit[PARTY_SIZE];
		int n = 0;
		for (int i = 0; i < guildList.size(); i++) {
			if (guildList.get(i).party == true) {
				partyList[n] = guildList.get(i);
				n++;
			}
		}
	}

	public Unit getGuildUnit(int num) {
		return guildList.get(num);
	}

	public void printAllUnitStatus() {
		System.out.println("======================================");
		System.out.println("[골드 : " + Player.gold + "]");
		System.out.println("============= [길드원] =================");
		for (int i = 0; i < guildList.size(); i++) {
			System.out.print("[" + (i + 1) + "번]");
			System.out.print(" [이름 : " + guildList.get(i).name + "]");
			System.out.print(" [레벨 : " + guildList.get(i).level + "]");
			System.out.print(" [체력 : " + guildList.get(i).hp);
			System.out.println(" / " + guildList.get(i).maxHp + "]");
			System.out.print("[공격력 : " + guildList.get(i).att + "]");
			System.out.print(" [방어력 : " + guildList.get(i).def + "]");
			System.out.println(" [파티중 : " + guildList.get(i).party + "]");
			System.out.println("");
		}
		System.out.println("====================================");
	}

	public void printUnitStatus(int num) {
		guildList.get(num).printStatus();
	}

	public void printUnitItem(int num) {
		guildList.get(num).printEquipItem();
	}

	public void buyUnit() {
		if (Player.gold < 5000) {
			return;
		}
		String[] n1 = { "박", "이", "김", "최", "유", "지", "오" };
		String[] n2 = { "명", "기", "종", "민", "재", "석", "광" };
		String[] n3 = { "수", "자", "민", "수", "석", "민", "철" };

		String name = n1[MainGame.ran.nextInt(n1.length)];
		name += n2[MainGame.ran.nextInt(n1.length)];
		name += n3[MainGame.ran.nextInt(n1.length)];
		int ran = MainGame.ran.nextInt(8) + 2;
		int hp = ran * 11;
		int att = ran + 1;
		int def = ran / 2 + 1;
		Unit temp = new Unit(name, 1, hp, att, def, 0);
		System.out.println("=====================================");
		System.out.print("[이름 : " + name + "]");
		System.out.print(" [레벨 : " + 1 + "]");
		System.out.print(" [체력 : " + hp);
		System.out.println(" / " + hp + "]");
		System.out.print("[공격력 : " + att + "]");
		System.out.println(" [방어력 : " + def + "]");
		System.out.println("길드원을 추가합니다.");
		System.out.println("=====================================");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		guildList.add(temp);
		Player.gold -= 5000;
	}

	public void removeUnit() {
		printAllUnitStatus();
		System.out.println("삭제할 번호를 입력하세요 : ");
		int sel = MainGame.scan.nextInt();
		if (guildList.get(sel - 1).party) {
			System.out.println("파티중인 멤버는 삭제할 수 없습니다. ");
		} else {
			System.out.println("===============================");
			System.out.println("[이름 : " + guildList.get(sel - 1).name + "]");
			System.out.println("길드원을 삭제합니다. ");
			System.out.println("================================");
			guildList.remove(sel - 1);
		}
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void printParty() {
		System.out.println("================ [파티원] ===============");
		for (int i = 0; i < PARTY_SIZE; i++) {
			System.out.print("[" + (i + 1) + "번]");
			System.out.print(" [이름 : " + partyList[i].name + "]");
			System.out.print(" [레벨 : " + partyList[i].level + "]");
			System.out.print(" [체력 : " + partyList[i].hp);
			System.out.println(" / " + partyList[i].maxHp + "]");
			System.out.print("[공격력 : " + partyList[i].att + "]");
			System.out.print(" [방어력 : " + partyList[i].def + "]");
			System.out.println(" [파티중 : " + guildList.get(i).party + "]");
			System.out.println("");
		}
		System.out.println("========================================");
	}
	
	public void switchUnit() {
		printParty();
		System.out.println("교체할 번호를 입력하세요 : ");
		int num = MainGame.scan.nextInt();
		System.out.println("참가할 번호를 입력하세요 : ");
		int changeNum = MainGame.scan.nextInt();
		
		partyList[num -1].party = false;
		guildList.get(changeNum-1).party = true;
		
		System.out.println("====================================");
		System.out.print("[이름 : " + partyList[num - 1].name + "]");
		System.out.print("에서 ");
		System.out.print("[이름 : " + guildList.get(changeNum - 1).name + "]");
		System.out.println("으로 교체 합니다. ");
		System.out.println("====================================");
		int n =0;
		for(int i=0; i<guildList.size();i++) {
			if(guildList.get(i).party) {
				partyList[n] = guildList.get(i);
				n++;
			}
		}
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
