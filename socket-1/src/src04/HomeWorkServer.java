import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HomeWorkServer {

    private static String dayTranslation(String day) {
        String result = "";
        if (day.equals("getuyoubi") || day.equals("gethuyoubi") || day.equals("monday")) {
            result = "月曜日";
        }
        if (day.equals("kayoubi") || day.equals("tuesday")) {
            result = "火曜日";
        }
        if (day.equals("suiyoubi") || day.equals("wednesday")) {
            result = "水曜日";
        }
        if (day.equals("mokuyoubi") || day.equals("thursday")) {
            result = "木曜日";
        }
        if (day.equals("kinnyoubi") || day.equals("kinyoubi") || day.equals("friday")) {
            result = "金曜日";
        }
        if (day.equals("doyoubi") || day.equals("saturday")) {
            result = "土曜日";
        }
        if (day.equals("nitiyoubi") || day.equals("nichiyoubi") || day.equals("sunday")) {
            result = "日曜日";
        }
        return result;
    }

    private static String serverProcess(String content) {
        StringBuilder sb = new StringBuilder();
        sb.append("明日が締切の課題は以下の通りです。\n");
        switch (content) {
            case "月曜日":
                sb.append("1.データ解析\n2.ヒューマンインタラクションおよび演習\n3.CGモデリング\n");
                break;
            case "火曜日":
                sb.append("無し\n");
                break;
            case "水曜日":
                sb.append("無し\n");
                break;
            case "木曜日":
                sb.append("1.ネットワークプログラミングとクラウド開発及び演習\n2.インタラクティブメディアとデザイン\n");
                break;
            case "金曜日":
                sb.append("無し\n");
                break;
            case "土曜日":
                sb.append("無し\n");
                break;
            case "日曜日":
                sb.append("基礎ゼミ\n");
                break;
        }
        if (content.equals("火曜日") || content.equals("水曜日") || content.equals("金曜日") || content.equals("土曜日")) {
            sb.append("明日は休みです。やったね。\n");
            if (content.equals("火曜日") || content.equals("金曜日")) {
                sb.append("明後日も休みです。やったね。");
            }
        }
        String result = sb.toString();
        return result;
    }

    public static void main(String arg[]) {
        try {
            /* 通信の準備をする */
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            scanner.close();
            System.out.println("localhostの" + port + "番ポートで待機します");
            ServerSocket server = new ServerSocket(port); // ポート番号を指定し、クライアントとの接続の準備を行う

            Socket socket = server.accept(); // クライアントからの接続要求を待ち、
            // 要求があればソケットを取得し接続を行う
            System.out.println("接続しました。相手の入力を待っています......");

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            while (true) {
                HomeWorkSample present = (HomeWorkSample) ois.readObject();// Integerクラスでキャスト。

                String msgPresent = dayTranslation(present.getMessage());
                if (msgPresent.equals("q")) {
                    System.out.println("終了指令を受け取ったため、通信を終了します。");
                    break;
                }
                System.out.println("今日の曜日は" + msgPresent);

                HomeWorkSample response = new HomeWorkSample();
                response.setMessage("サーバーです。今日も一日お疲れ様です。\n" + "本日は" + msgPresent + "ですね。");
                response.setContent(serverProcess(msgPresent));

                oos.writeObject(response);
                oos.flush();
            }

            // close処理

            ois.close();
            oos.close();
            // socketの終了。
            socket.close();
            server.close();

        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (BindException be) {
            be.printStackTrace();
            System.out.println("ポート番号が不正、ポートが使用中です");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
