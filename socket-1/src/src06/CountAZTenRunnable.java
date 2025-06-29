package src06;
// Runnable インターフェースを実装することで、このクラスのインスタンスはスレッドとして実行可能になります。
public class CountAZTenRunnable implements Runnable {
    char index = ' ';
    private static final Object lock = new Object();
    private static int turn = 0; // 今どのスレッドの番か
    private final int myIndex;

    public CountAZTenRunnable(int myIndex){
        this.myIndex = myIndex;
    }
    // main メソッドはプログラムのエントリーポイントです。
    public static void main(String[] args){
        // 2つの文字を初期化します。
        char[] AtoZ = new char[26];
        CountAZTenRunnable[] cts = new CountAZTenRunnable[26];
        Thread[] ths = new Thread[26];
        for(int i = 0; i < AtoZ.length; i++){
            if(i == 0){
                AtoZ[0] = 97;
            }else{
                AtoZ[i] = (char)(97 + i);
            }

            System.out.println(AtoZ[i]);
        }
        for(int i = 0; i < AtoZ.length; i++){
            cts[i] = new CountAZTenRunnable(i);
            cts[i].setChar(AtoZ[i]);
            ths[i] = new Thread(cts[i], "th-" + i);
            ths[i].start();
        }


        // この try-catch ブロックは、0 から 9 までの値を 500 ミリ秒間隔で出力するループを実行します。
        try {
            for(int i = 0; i < 10; i++) {
                // メインスレッドを 500 ミリ秒間一時停止します。
                Thread.sleep(500);  // ミリ秒単位のスリープ時間
            }
        }
        catch(InterruptedException e) {
            // スレッドが中断された場合は、例外を出力します。
            System.err.println(e);
        }
    }

    // run メソッドは、新しいスレッドが実行するコードを含みます。
    public void run() {
        // この try-catch ブロックは、0 から 9 までの値を 1000 ミリ秒間隔で出力するループを実行します。
            for(int i = 0; i < 10; i++) {
            synchronized (lock) {
                while (turn != myIndex) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 出力
                System.out.println(index + "" + i);

                // 次のターンへ（a → b → c → ... → z → a ...）
                turn = (turn + 1) % 26;
                lock.notifyAll();
            }
            }
    }

    public void setChar(char c){
        index = c;
    }

}
