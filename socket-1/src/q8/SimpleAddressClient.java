package q8;

import java.io.*;
import java.net.*;

public class SimpleAddressClient {
    public static void main(String[] args) {
        String townName = "千住旭町"; // ここを必要に応じて変更 FIXME

        try (Socket socket = new Socket("localhost", 8088);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            System.out.println("接続成功");
			// FIXME サーバに町名の文字列を送信する
			out.write(townName);
			// FIXME サーバからの返信を受け取る
			String inPostalCode = in.readLine();
            System.out.println(townName);
            System.out.println(inPostalCode);
            in.close();
            out.close();
        } catch (IOException e) {
            System.err.println("サーバとの通信中にエラーが発生しました: " + e.getMessage());
        }
    }
}
