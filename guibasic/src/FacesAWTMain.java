import java.awt.*;
import java.awt.event.*;

public class FacesAWTMain {
    // メインメソッド：プログラムの開始点
	public static void main(String[] args){
		new FacesAWTMain(); // インスタンスを生成
	}

	// コンストラクタ：ウィンドウを作成して表示
	FacesAWTMain(){
		FaceFrame f = new FaceFrame(); // カスタムフレーム生成
		f.setSize(800,800); // ウィンドウサイズ設定
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0); // ウィンドウを閉じたときに終了
			}
		});
		f.setVisible(true); // ウィンドウを表示
	}

	// 内部クラス：顔を描画するためのフレーム
	class FaceFrame extends Frame{

        private FaceObj[] fobjs = new FaceObj[9];
	
		// コンストラクタ：FaceObjインスタンスを生成
		FaceFrame(){
			for(int j=0;j<3;j++) {
				for (int i = 0; i < 3; i++) {
					fobjs[i+3*j]= new FaceObj();
				}
			}
		}

		// 描画処理
		public void paint(Graphics g) {
			for(int j=0;j<3;j++) {
				for (int i = 0; i < 3; i++) {
					fobjs[i+3*j].setPosition(200*i+100, 200*j+100, 180, 180, i, j);
					//fobjs[i+3*j].setEmotionLevel(i,j);
					fobjs[i+3*j].drawFace(g);
				}
			}
		}

	// 顔に関するロジックを後で追加する予定のクラス
	private class FaceObj {
		// 今後、顔のスタイル・パーツ管理などをここに記述
		private int w; // 顔の幅
		private int h;
		private int xStart; // 顔の左上x座標
		private int yStart;
		private int xCenter;//顔の中心
		private int yCenter;
		private int Num1;
		private int Num2;

        public void setPosition(int x, int y, int w, int h, int Num1, int Num2) {
			this.xStart=x;
			this.yStart=y;
			this.w=w;
			this.h=h;
			this.Num1=Num1;
			this.Num2=Num2;
			xCenter = xStart + w/2;
			yCenter = yStart + h/2;
		}

        public void drawFace(Graphics g){
			// 顔の各パーツを描画
			drawRim(g); // 顔の輪郭
			drawBrow(g, 40); // まゆげ
			drawEye(g, 35); // 目
			drawNose(g, 40); // 鼻
			drawMouth(g, 100);
		}

		// 顔の枠線を描く
		public void drawRim(Graphics g) {
			g.setColor(new Color(100 + 50*Num1, 100 + 50*Num2, 50 + 50*(Num1+Num2)));
			g.fillRect(xStart, yStart, w, h);
			g.setColor(new Color(0, 0, 0));
			g.drawLine(xStart, yStart, xStart + w, yStart);
			g.drawLine(xStart, yStart, xStart, yStart + h);
			g.drawLine(xStart, yStart + h, xStart + w, yStart + h);
			g.drawLine(xStart + w, yStart, xStart + w, yStart + h);
		}

		// まゆげを描く（未実装）
		public void drawBrow(Graphics g, int bx) {
			if(Num2 == 0){
				g.drawLine(xCenter - 20, yCenter - 50, xCenter - 20 - bx, yCenter - 40);
				g.drawLine(xCenter + 20, yCenter - 50, xCenter + 20 + bx, yCenter - 40);
			}else if(Num2 == 1){
				g.drawLine(xCenter - 20, yCenter - 25, xCenter - 20 - bx, yCenter - 25);
				g.drawLine(xCenter + 20, yCenter - 25, xCenter + 20 + bx, yCenter - 25);
			}else{
				g.drawLine(xCenter - 20, yCenter - 40, xCenter - 20 - bx, yCenter - 50);
				g.drawLine(xCenter + 20, yCenter - 40, xCenter + 20 + bx, yCenter - 50);
			}
		}

		// 鼻を描く（未実装）
		public void drawNose(Graphics g, int nx) {
			g.drawLine(xCenter, yCenter - nx / 2, xCenter, yCenter + nx / 2);
		}

		// 両目を描く
		public void drawEye(Graphics g, int r) {
			g.drawOval(xCenter - 60, yCenter - 20, r, r);
			g.drawOval(xCenter + 40 - r/2, yStart + 70, r, r);
		}

        // 口を描く
		public void drawMouth(Graphics g, int mx) {
			int yMouth = yStart + h - 30;
			if(Num1 == 0){
				g.drawLine(xCenter - mx / 2, yMouth, xCenter + mx / 2, yMouth);
			}else if(Num1 == 1){
				g.drawLine(xCenter - mx / 4, yMouth, xCenter + mx / 4, yMouth);
			}else{
				g.drawLine(xCenter - mx / 10, yMouth, xCenter + mx / 10, yMouth);
			}
			
		}

	}
}
}