package srcs;
import java.util.*;

public class PrimeCheck {
    
    public static void main(String[] args) {
        int maxsize = 100000;
        List<Integer> primes  = new ArrayList<>();

        //素数の列挙方法としてエラトステネスの篩を用いる。
        boolean[] isPrime = new boolean[maxsize + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= maxsize; i++) {
            if(isPrime[i]) {
                for (int j = i * i; j <= maxsize; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        //3以上の素数をリストに追加
        for (int i = 3; i <= maxsize; i++) {
            if(isPrime[i]) {
                primes.add(i);
            }
        }

        Map<String, Integer> pairCount = new HashMap<>();

        int[] validLastDigits = {1, 3, 7, 9};

        //連続ペアを調べる
        for (int i = 0; i < primes.size() - 1; i++) {
            int last1 = primes.get(i) % 10 ;
            int last2 = primes.get(i + 1) % 10;
            if (last1 == 5 || last2 == 5) continue;
            if (contains(validLastDigits, last1) && contains(validLastDigits, last2)) {
                String key = last1 + "-" + last2;
                pairCount.put(key, pairCount.getOrDefault(key, 0) + 1);
            }
        }

        //出力
        List<Map.Entry<String, Integer>> result = new ArrayList<>(pairCount.entrySet());
        result.sort((a, b) -> b.getValue() - a.getValue());
        for(Map.Entry<String, Integer> entry : result) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private static boolean contains(int[] array, int value) {
        for (int v : array) {
            if( v == value) return true;
        }
        return false;
    }
}
