package q8;

import java.io.*;
import java.net.*;

public class SimpleAddressServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8088)) {
            System.out.println("サーバがポート8088で起動しました。");
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    String townName = in.readLine();
                    String postalCode;
                    
                    // TODO クライアントから受け取った町名が, ハードコードされている町名と一致すれば, その町名の郵便番号を返す
                    if(townName.equals("千住曙町")){
                        postalCode = "120-0023";
                    }if(townName.equals("千住旭町")){
                        postalCode = "120-0026";
                    }if(townName.equals("千住東")){
                        postalCode = "120-0025";
                    }if(townName.equals("千住大川町")){
                        postalCode = "120-0024";
                    }if(townName.equals("千住関屋町")){
                        postalCode = "120-0022";
                    }if(townName.equals("千住宮本町")){
                        postalCode = "120-0021";
                    }if(townName.equals("千住仲町")){
                        postalCode = "120-0032";
                    }if(townName.equals("千住橋戸町")){
                        postalCode = "120-0033";
                    }if(townName.equals("千住緑町")){
                        postalCode = "120-0034";
                    }else{
                        postalCode = "不明";
                    }
                    System.out.println(postalCode);

                    out.write(postalCode);

                    //close処理
                    in.close();
                    out.close();
                    
                } catch (IOException e) {
                    System.err.println("クライアントとの通信中にエラーが発生しました: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("サーバの起動中にエラーが発生しました: " + e.getMessage());
        }
    }
}
