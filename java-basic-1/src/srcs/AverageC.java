package srcs;
import java.util.Arrays;
import java.util.Random;

public class AverageC {
    public static void main(String[] args) {

        /*
         * // Subjectクラスのインスタンスとして、englishを
         * // 作る
         * Subject english = new Subject(80);
         * // 同様に、math
         * Subject math = new Subject(70);
         *
         * // english の name に "英語" を設定する
         * english.name = "英語";
         * int a = english.getScore();
         * System.out.println("英語の点は" + a + "ですね");
         * int b;
         * b = math.getScore();
         * System.out.println("数学の点は" + b + "ですね");
         * int ave=(a+b)/2;
         * System.out.println("平均点は" + ave + "ですね");
         */

        int studentSize = 100;
        float scoreAverage = 0;
        Subject[] math = new Subject[studentSize];
        Random rand = new Random();
        for (int i = 0; i < studentSize; i++) {
            math[i] = new Subject(rand.nextInt(101));
            math[i].setStudentid(i + studentSize);
            scoreAverage += math[i].getScore();
        }
        scoreAverage = Math.round((scoreAverage / studentSize) *10);
        scoreAverage /= 10;
        System.out.println("受験者全体での平均点は" + scoreAverage + "です。");

        int h = 0;
        int [] passed = new int [math.length];
        for(Subject m : math){
                passed[h] = m.getScore();
                h++;
        }

        Integer[] passedIntegers = new Integer[passed.length];
        for(int i = 0; i < passed.length; i++){
            passedIntegers[i] = passed[i];
        }
        Arrays.sort(passedIntegers);

        System.out.println("合格者の一覧は以下。\n受験番号,点数");
        for(int i = 0; i < passed.length; i++){
            if(passedIntegers[i] >= 80){
                for(int j = 0; j < math.length; j++){
                    if(math[j].getScore() == passedIntegers[i]){
                        System.out.println(math[j].getStudentid() + "," + passedIntegers[i]);
                        math[j].setScore(0);
                    }
                }
            }
        }
    }
}
