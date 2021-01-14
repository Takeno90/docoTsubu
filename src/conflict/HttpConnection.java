package conflict;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnection {
	//指定のURLに、GETリクエスト
	public void sendGet() {
		String getUrl = "http://localhost:8080/docoTsubu/CounterServlet11_2_conflict?action=good";
		HttpURLConnection connection = null;

		try {
			//接続するURLを指定
			URL url = new URL(getUrl);
			//HttpURLConnectionインスタンスの取得
			connection = (HttpURLConnection) url.openConnection();
			//リクエストのメソッドを指定
			connection.setRequestMethod("GET");
			//通信開始
			connection.connect();
			//レスポンスコードを取得
			int responseCode = connection.getResponseCode();
			System.out.println("HTTPステータス:" + responseCode);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if (connection != null) {
				//通信終了
				connection.disconnect();
			}
		}
	}

	public static void main(String[] args) {
		//動作確認
		for (int i = 0; i < 100; i++) {
			System.out.println(i + "回目");
			HttpConnection httpConn = new HttpConnection();
			//Getリクエストの実行
			httpConn.sendGet();
		}
	}
}
