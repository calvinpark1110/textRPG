package RPG;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class MainGame {
	static Scanner scan = new Scanner(System.in);
	static Random ran = new Random();
	public MainGame() {
		Player player = new Player();
		Shop shop = new Shop();
		FileDate fileData = new FileDate();
		while(true) {
			System.out.println("========[메인메뉴]=========");
			System.out.println("[1] 길드관리 [2] 상점 [3] 인벤토리");
			System.out.println("[4] 저장 [5] 로드 [0] 종료");
			int sel = scan.nextInt();
			if(sel == 1) {
				player.guildMenu();
			}else if(sel == 2) {
				shop.showmenu();
			}else if(sel == 3) {
				player.inventoryMenu();
			}else if(sel == 4) {
				try {
				
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			else {
				System.out.println("게임을 종료합니다. ");
				break;
			}
		}
		MainGame.scan.close();
	}
}
