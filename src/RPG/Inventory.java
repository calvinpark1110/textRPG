package RPG;

import java.util.ArrayList;

public class Inventory {
	ArrayList<Item> itemList = new ArrayList<>();

	public void inventoryMenu() {
		while(true) {
			System.out.println("=========[인벤메뉴]=============");
			System.out.println("[1] 착용 [2] 판매 [0] 뒤로가기");
			int sel = MainGame.scan.nextInt();
			if(sel == 0) {
				break;
			}else if(sel == 1) {
				equipMenu();
			}else if(sel == 2) {
				sellMenu();
			}
		}
	}
	public void equipMen() {
		
	}
}
