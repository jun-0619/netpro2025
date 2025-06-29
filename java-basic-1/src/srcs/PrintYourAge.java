package srcs;
//ユーザの現在の年齢を入力し、10年後の年齢を表示するプログラム
import java.time.LocalDate;
import java.util.Scanner;

public class PrintYourAge {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);   //Scanner生成
        String line = "";
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
            try {
                while(!line.equals("q")
                ||!line.equals("e")){
                    System.out.println("何歳ですか?(数え年)");
                    line = scanner.nextLine();
                    int age = Integer.parseInt(line);
                    if(age < 0 || age > 120){
                        System.out.println("年齢が許容値を超えています。");
                        break;
                    }
                    int birthYear = currentYear - age ;
                    String jpCulender = "";
                    if(2019 <= birthYear){
                        jpCulender = "令和" + (birthYear - 2018) + "年";
                        if(birthYear == 2019){
                            jpCulender = "令和元年" ;
                        }
                    }else if(1989 <= birthYear || birthYear <= 2018){
                        jpCulender = "平成" + (birthYear - 1988) + "年";
                        if(birthYear == 1989){
                            jpCulender = "平成元年" ;
                        }
                    }else if(1926 <= birthYear || birthYear <= 1988){
                        jpCulender = "昭和" + (birthYear - 1925) + "年";
                        if(birthYear == 1926){
                            jpCulender = "昭和元年" ;
                        }
                    }else if(1912 <= birthYear || birthYear <= 1925){
                        jpCulender = "大正" + (birthYear - 1911) + "年";
                        if(birthYear == 1912){
                            jpCulender = "大正元年" ;
                        }
                    }else if(1868 <= birthYear || birthYear <= 1911){
                        jpCulender = "明治" + (birthYear - 1867) + "年";
                        if(birthYear == 1868){
                            jpCulender = "明治元年" ;
                        }
                    }
                    System.out.println("あなたは" + age + "歳ですね。");
                    System.out.println("あなたは" + jpCulender + "生まれですね。");
                    System.out.println("あなたは2030年に、" + (age + (2030 - currentYear)) + "歳ですね。");
            }

            scanner.close(); // Scannerの終了
            System.out.println("終了します");

            }catch(Exception e){
                System.out.println(e);
            }

	}
}