import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket; //ネットワーク関連のパッケージを利用する
import java.util.Scanner;

public class HomeWorkTCPClient {
    public static void main(String arg[]) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました");

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            while (true) {
                System.out.println("明日までに片付けなければならない課題を返します。");
                System.out.println("今日の曜日をローマ字で入力してください。(例:木曜日 -> mokuyoubi)\n終了する場合は'q'と入力してください。 ↓");
                String today = scanner.next();
                if (today.equals("q")) {
                    break;
                }

                HomeWorkSample hw = new HomeWorkSample();
                hw.setMessage(today);

                oos.writeObject(hw);
                oos.flush();

                HomeWorkSample returnHw = (HomeWorkSample) ois.readObject();

                String replayMsg = returnHw.getMessage();
                System.out.println("サーバからのメッセージ：" + replayMsg);
                String replayContent = returnHw.getContent();
                System.out.println(replayContent);
            }

            scanner.close();
            ois.close();
            oos.close();
            socket.close();

        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (BindException be) {
            be.printStackTrace();
            System.err.println("ポート番号が不正か、サーバが起動していません");
            System.err.println("サーバが起動しているか確認してください");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
