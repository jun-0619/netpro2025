package src05;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket;
import java.util.Scanner;

public class TaskClientWhile {
    public static void main(String[] args) {
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
                //入力の処理
                System.out.println("素数を探索する範囲の最大数を入力してください。");
                String str = scanner.next();
                int number = Integer.parseInt(str);
                TaskObject inputTO = new TaskObject();
                inputTO.setExecNumber(number);

                //サーバーへ送信
                oos.writeObject(inputTO);
                oos.flush();

                //1以下の値が送られたら終了処理
                if(number <= 1){
                    System.out.println("1以下の値を入力したので通信を終了します。");
                    break;
                }

                //サーバーからの返信処理
                TaskObject returnTO = (TaskObject) ois.readObject();
                int returnNumber = returnTO.getResult();
                System.out.println("サーバーから送られた値:" + returnNumber);
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
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
