package srcs;
import java.util.Random;

public class TheBoilingEarthEraC {
    public static void main(String[] args){
        double[][] temperatures = new double[10][31];
        double averageTemp = 29.0;
        for(int i = 0 ; i <= 9 ; i++){
            for(int j = 0 ; j <= 30 ; j++){
            Random rand = new Random();
            double tempWidth = rand.nextDouble(100) - 50;
            temperatures[i][j] =  averageTemp + (tempWidth / 10);
            System.out.println((2016 + i) + "年7月" + (j + 1) + "日: " + String.format("%.1f",temperatures[i][j]) + "℃");
            }
            averageTemp += 0.3;
        }

        System.out.println("猛暑日連続ペア");
        for(int i = 0 ; i <= 9 ; i++){
            for(int j = 1 ; j <= 30 ; j++){
                if(temperatures[i][j-1] >= 35 && temperatures[i][j] >= 35){
                    System.out.println((2016 + i) + "年7月" + j + "日: " + String.format("%.1f",temperatures[i][j-1]) + "℃"
                                        +" と " + (2016 + i) + "年7月" + (j + 1) + "日: " + String.format("%.1f",temperatures[i][j]) + "℃");
                }
            }
        }
    }
}
