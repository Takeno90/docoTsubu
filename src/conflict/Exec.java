package conflict;

//追加スレッドの定義
class AddThread extends Thread{
	//スレッド内の処理
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("thread:" + i);
			//HttpConnectionクラス
			HttpConnection httpConn = new HttpConnection();
			//Getリクエストの実行
			httpConn.sendGet();
		}
	}
}
//1つのファイルに複数のクラス書けるが、publicは1つのみ。publicのクラスをファイル名にする。
//テスト実行クラス
public class Exec {
	//同時実行による競合テスト
	public static void main(String[] args) {
		//別スレッドの開始
		Thread th = new AddThread();
		th.start(); //run()ではなく、start()を実行!
		//メインスレッド内の処理
		for (int i = 0; i < 100; i++) {
			System.out.println("main:" + i);
			//HttpConnectionクラス
			HttpConnection httpConn = new HttpConnection();
			//Getリクエストの実行
			httpConn.sendGet();
		}
	}
}