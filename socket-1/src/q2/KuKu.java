package q2;

public class KuKu {
    public static void main(String[] args) {
        for(int i = 1 ; i <= 9 ; i++){
            StringBuilder sb = new StringBuilder();
            sb.append("|");
            for(int j = 1 ; j <= 9 ; j++){
                if(i*j < 10){
                    sb.append(" " + (i*j) + "|");
                }else{
                    sb.append( (i*j) + "|");
                }
            }
            System.out.println(sb);
        }
    }
}
