package q4;

import java.util.Random;
import java.util.Scanner;

public class Dice {
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        Random random = new Random(); 
        int i = 0; // 試行回数

        while (true) {
			//Diceを振る処理
            String line = "" + scanner.nextLine();
            if(line.equals("quit")||line.equals("exit")||line.equals("0")){
                System.out.println("Diceプログラムを終了します");
                break;
            }
            i+=1;
            System.out.println(random.nextInt(7) + "(累計" + i + "回目)");
        }
        //終了処理
        scanner.close();
    }
}
