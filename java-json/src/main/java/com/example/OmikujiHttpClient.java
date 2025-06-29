package com.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OmikujiHttpClient {

    public static void main(String[] args) {
        // TODO: HttpClient のインスタンスを生成する
        HttpClient client = HttpClient.newHttpClient(); 

        // サーバーの URL を文字列で持っておく
        String url = "http://localhost:8000/api/omikuji";

        // 100 回リクエストを送信するループ
        for (int i = 1; i <= 100; i++) {
            try {
                // TODO: HttpRequest を組み立てる
                // 例: HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
                HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

                // TODO: client.send(...) を使ってリクエストを送信し、レスポンスを HttpResponse<String> で受け取る
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                // TODO: ステータスコードとレスポンスボディをコンソールに出力する
                // 例: System.out.printf("Request %3d: HTTP %d ‒ Body: %s%n", i, response.statusCode(), response.body());
                System.out.printf("Request %3d: HTTP %d ‒ Body: %s%n", i, response.statusCode(), response.body());

            } catch (IOException | InterruptedException e) {
                // TODO: 例外発生時に、何番目のリクエストでエラーが起きたか分かるようにスタックトレースを出力する
                e.printStackTrace();
                System.out.println(i);
            }
        }
    }
}