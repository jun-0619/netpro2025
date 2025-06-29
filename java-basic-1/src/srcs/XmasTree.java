package srcs;
import java.util.Scanner;

public class XmasTree {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String line = "void";
        try{
            while(true){
                System.out.println("入力してください(一番下の葉の数の半分の幅,幹の幅,幹の長さ,雪模様(任意の文字列)) qまたはeで終了");
                //入力を受け取りカンマ区切り
                line = scanner.nextLine();
                String[] array01 = line.split(",");
                int[] arrayInt = new int[3];
                //カンマ区切りのデータが規定の形に合ってるかを確認
                if(line.equals("e")||line.equals("q")){
                    System.out.println("終了します");
                    break;
                }
                if(array01.length != 4){
                    System.out.println("変数の入力は[int,int,int,String]にしてください。");
                    continue;
                }
                for(int i = 0; i < array01.length - 1; i++){
                    try{
                        arrayInt[i] = Integer.parseInt(array01[i]);
                    } catch(NumberFormatException e){
                        System.out.println("変数の入力は[int,int,int,any]にしてください。");
                        continue;
                    }
                }
                //ツリーの描画
                for (int i = 0; i < arrayInt[0]; i++) {
                    for(int j = 0; j < arrayInt[0]-i; j++) {
                        if(i%3==0){
                            if(j%3==0){
                                System.out.print(array01[3]);
                            }else{
                                System.out.print(" ");
                            }
                        }else if(i%3==1){
                            if(j%3==1){
                                System.out.print(array01[3]);
                            }else{
                                System.out.print(" ");
                            }
                        }else if(i%3==2){
                            if(j%3==2){
                                System.out.print(array01[3]);
                            }else{
                                System.out.print(" ");
                            }
                        }
                    }
                    for(int k = 0; k <= i; k++) {   //木の左半分
                        System.out.print("*");
                    }
                    for(int k = 0; k <= i; k++) {   //木の右半分
                        System.out.print("*");
                    }
                    for(int j = 0; j < arrayInt[0]-i; j++) {
                        if(i%3==0){
                            if(j%3==0){
                                System.out.print(array01[3]);
                            }else{
                                System.out.print(" ");
                            }
                        }else if(i%3==1){
                            if(j%3==1){
                                System.out.print(array01[3]);
                            }else{
                                System.out.print(" ");
                            }
                        }else if(i%3==2){
                            if(j%3==2){
                                System.out.print(array01[3]);
                            }else{
                                System.out.print(" ");
                            }
                        }
                    }
                    System.out.println("\n");
                }
                for (int i = 0; i < arrayInt[2]; i++) {
                    for(int j = 0; j < arrayInt[0] - (arrayInt[01]/2); j++) {
                        System.out.print(" ");
                    }
                    for(int k = 0; k < arrayInt[01]; k++) {
                        System.out.print("*");
                    }
                    System.out.println("\n");
                }
            }

            scanner.close();

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
