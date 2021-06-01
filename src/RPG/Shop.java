package RPG;

import java.util.ArrayList;

public class Shop {
	ArrayList<Item> itemList = new ArrayList<>();

	public Shop() {
		Item temp = new Item();
		temp.kind = Item.WEAPON;
		temp.name = "나무검";
		temp.power = 3;
		temp.price = 1000;
		itemList.add(temp);

		temp = new Item();
		temp.kind = Item.WEAPON;
		temp.name = "철검";
		temp.power = 10;
		temp.price = 2000;
		itemList.add(temp);

		temp = new Item();
		temp.kind = Item.WEAPON;
		temp.name = "기관총";
		temp.power = 100;
		temp.price = 5000;
		itemList.add(temp);

		temp = new Item();
		temp.kind = Item.ARMOR;
		temp.name = "Trainning";
		temp.power = 5;
		temp.price = 1;
		itemList.add(temp);

		temp = new Item();
		temp.kind = Item.ARMOR;
		temp.name = "가죽갑옷";
		temp.power = 10;
		temp.price = 5;
		itemList.add(temp);

		temp = new Item();
		temp.kind = Item.ARMOR;
		temp.name = "강철갑옷";
		temp.power = 100;
		temp.price = 20;
		itemList.add(temp);

		temp = new Item();
		temp.kind = Item.RING;
		temp.name = "silver ring";
		temp.power = 5;
		temp.price = 10;
		itemList.add(temp);

		temp = new Item();
		temp.kind = Item.RING;
		temp.name = "Gold Ring";
		temp.power = 100;
		temp.price = 50;
		itemList.add(temp);
	}

	public void showmenu() {
		while (true) {
			System.out.println("========[상점]=============");
			System.out.println("[1] 무기 [2] 갑옷 [3] 반지 [0] 뒤로가기");
			int sel = MainGame.scan.nextInt();
			if (sel == 0) {
				break;
			} else if (sel == Item.WEAPON) {
				System.out.println("========WEAPON=======");
			} else if (sel == Item.ARMOR) {
				System.out.println("========ARMOR========");
			} else if (sel == Item.RING) {
				System.out.println("=========Ring========");
			}
			printItem(sel);
		}
	}

	public void printItem(int num) {
		int cnt = 0;
		for(int i=0; i<itemList.size();i++) {
			if(itemList.get(i).kind != num) {
				continue;
			}
			System.out.println("[" + (cnt +1) + " 번]");
			System.out.println("이름 : " +itemList.get(i).name);
			System.out.println("능력치 : " + itemList.get(i).power);
			System.out.println("가격 : " + itemList.get(i).price);
			System.out.println("");
			cnt ++;
		}
	}
}
