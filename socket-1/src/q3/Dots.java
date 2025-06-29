package q3;

public class Dots {
    public static void main(String[] args) {
        int n = 7; // ギザギザ模様の最大長さ
        // 模様を3回繰り返す
        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < n; i++){ //上半分
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j <= i; j++){
                    sb.append("●");
                }
                System.out.println(sb);
            }
            for (int i = 0; i < n; i++){ //下半分
                StringBuilder sb2 = new StringBuilder();
                for (int j = 0; j < n - i; j++){
                    sb2.append("●");
                }
                System.out.println(sb2);
            }
        }
    }
}
