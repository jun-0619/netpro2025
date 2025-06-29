package src05;

import java.io.Serializable;
import java.util.Arrays;

public class TaskObject implements Serializable,ITask {
    int Number;

    @Override
    public void setExecNumber(int x) {
        this.Number = x ;
    }

    @Override
    public void exec() {
        int maxsize = Number;

        //素数を列挙
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
                Number = i;
            }
        }
    }

    @Override
    public int getResult() {
        return Number;
    }
    
}
