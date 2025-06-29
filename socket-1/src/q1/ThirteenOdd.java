package q1;

public class ThirteenOdd {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= 1000 ; i ++){
            if((i % 13 == 0) && (i % 2 == 1)){
                sb.append(i + ", ");
            }
        }
        System.out.println(sb);
    }
}
