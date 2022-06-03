package rr.control;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import rr.data.RRData;
import rr.function.FUNCanvas;

public class CMaster implements Initializable{
	@FXML
	private Label score1;
	@FXML
	private Label score2;
	@FXML
	private ComboBox<Integer> player1steps;
	@FXML
	private ComboBox<Integer> player2steps;
	@FXML
	private Label tip;
	@FXML
	private Label tip2;
	@FXML
	private Canvas canvas;
	@FXML
	private Button reset;
	@FXML
	private Label player1name;
	@FXML
	private Label player2name;
	
	private FUNCanvas can=new FUNCanvas();
	//用来生成中心卡片用
	private String[] card=new String[] {"blue-1","blue-2","blue-3","blue-4","red-1","red-2","red-3","red-4","green-1","green-2","green-3","green-4","yellow-1","yellow-2","yellow-3","yellow-4"};
	/**
	 * 初始化地图、下拉选择器内容
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<101;i++) {
					player1steps.getItems().add(i);
					player2steps.getItems().add(i);
				}
				player1steps.getSelectionModel().select(100);
				player2steps.getSelectionModel().select(100);
				tip.setText("explain:\n"
						+ "1. Flop and specify the destination.\n"
						+ "2. Find the way to reach the destination with the least number of steps, press the space, and select your own number of steps on the interface.\n"
						+ "3. Within the specified time, find a method to reach the destination with fewer steps, press the space, and select or update the steps on the interface.\n"
						+ "4. At the end of the time, the player with the least number of steps will start to prove his method. If he proves successful, he will win. Otherwise, "
							+ "it will be the turn of the next player with the least number of steps until the end.");
				tip.setTextFill(Color.WHITE);
				tip2.setText("1. first select the chess piece to move.\n"
						+ "2. use the direction keys to control movement.");
				RRData.map.iniMap();
				can.draw(canvas.getGraphicsContext2D());
				canvas.requestFocus();
			}
		});
	}
	/**
	 * 当下拉选择器有所动作触发
	 */
	public void onActive() {
		if(RRData.steps==1) {
			RRData.steps=2;
			can.draw(canvas.getGraphicsContext2D());
			canvas.requestFocus();
			new jishi().start();
		}
	}
	/**
	 * 画布被点击
	 */
	public void onClickForCanvas(MouseEvent e) {
		if(RRData.steps==3) {
			int y=(int)((e.getX()-8)/44);
			int x=(int)((e.getY()-8)/44);
			//判断是否点中机器人棋子
			if((RRData.robot_blue_x_m==x && RRData.robot_blue_y_m==y)||(RRData.robot_green_x_m==x && RRData.robot_green_y_m==y)||(RRData.robot_red_x_m==x && RRData.robot_red_y_m==y)
					||(RRData.robot_yellow_x_m==x && RRData.robot_yellow_y_m==y)||(RRData.robot_white_x_m==x && RRData.robot_white_y_m==y)) {
				if(RRData.animation==false) {
					RRData.selectx=x;
					RRData.selecty=y;
					if(RRData.robot_blue_x_m==x && RRData.robot_blue_y_m==y)RRData.selectcolor="blue";
					else if(RRData.robot_green_x_m==x && RRData.robot_green_y_m==y)RRData.selectcolor="green";
					else if(RRData.robot_red_x_m==x && RRData.robot_red_y_m==y)RRData.selectcolor="red";
					else if(RRData.robot_yellow_x_m==x && RRData.robot_yellow_y_m==y)RRData.selectcolor="yellow";
					else if(RRData.robot_white_x_m==x && RRData.robot_white_y_m==y)RRData.selectcolor="white";
					can.draw(canvas.getGraphicsContext2D());
				}
			}
		}
	}
	/**
	 * 画布鼠标移动
	 */
	public void onMoveForCanvas() {
		
	}
	/**
	 * 监听按键
	 */
	public void onKeyPress(KeyEvent e) {
		if(e.getCode()==KeyCode.SPACE) {//空格按下
			if(RRData.steps==0) {
				RRData.steps=1;
				RRData.target=card[new Random().nextInt(card.length)];
				can.draw(canvas.getGraphicsContext2D());
			}
		}else if((e.getCode()==KeyCode.UP || e.getCode()==KeyCode.W) && RRData.selectx>-1 && RRData.selecty>-1 && RRData.animation==false && RRData.steps==3){//上键按下
			int a=0;
			while(true) {
				if(RRData.selectx-a>=0) {
					if(RRData.map.getWall()[RRData.selectx-a][RRData.selecty]==null)a++;
					else if(a==0 &&(RRData.map.getWall()[RRData.selectx-a][RRData.selecty].charAt(4)=='3' || RRData.map.getWall()[RRData.selectx-a][RRData.selecty].charAt(4)=='4')) a++;
					else if(a>0 &&(RRData.map.getWall()[RRData.selectx-a][RRData.selecty].charAt(4)=='3' || RRData.map.getWall()[RRData.selectx-a][RRData.selecty].charAt(4)=='4')) {a--;break;}
					else break;
					if((RRData.robot_blue_x_m==(RRData.selectx-a) && RRData.robot_blue_y_m==(RRData.selecty))||(RRData.robot_red_x_m==(RRData.selectx-a) && RRData.robot_red_y_m==(RRData.selecty))
							||(RRData.robot_green_x_m==(RRData.selectx-a) && RRData.robot_green_y_m==(RRData.selecty))||(RRData.robot_yellow_x_m==(RRData.selectx-a) && RRData.robot_yellow_y_m==(RRData.selecty))
							||(RRData.robot_white_x_m==(RRData.selectx-a) && RRData.robot_white_y_m==(RRData.selecty))){a--;break;}
				}else break;
			}
			RRData.gotox=RRData.selectx-a;
			RRData.gotoy=RRData.selecty;
			if(RRData.gotox<0)RRData.gotox=0;
			RRData.animation=true;
			new ani().start();
		}else if((e.getCode()==KeyCode.DOWN || e.getCode()==KeyCode.S) && RRData.selectx>-1 && RRData.selecty>-1 && RRData.animation==false && RRData.steps==3){//下键按下
			int a=0;
			while(true) {
				if(RRData.selectx+a<=15) {
					if(RRData.map.getWall()[RRData.selectx+a][RRData.selecty]==null)a++;
					else if(a==0 && (RRData.map.getWall()[RRData.selectx+a][RRData.selecty].charAt(4)=='1' || RRData.map.getWall()[RRData.selectx+a][RRData.selecty].charAt(4)=='2')) a++;
					else if(a>0 && (RRData.map.getWall()[RRData.selectx+a][RRData.selecty].charAt(4)=='1' || RRData.map.getWall()[RRData.selectx+a][RRData.selecty].charAt(4)=='2')) {a--;break;}
					else break;
					if((RRData.robot_blue_x_m==(RRData.selectx+a) && RRData.robot_blue_y_m==(RRData.selecty))||(RRData.robot_red_x_m==(RRData.selectx+a) && RRData.robot_red_y_m==(RRData.selecty))
							||(RRData.robot_green_x_m==(RRData.selectx+a) && RRData.robot_green_y_m==(RRData.selecty))||(RRData.robot_yellow_x_m==(RRData.selectx+a) && RRData.robot_yellow_y_m==(RRData.selecty))
							||(RRData.robot_white_x_m==(RRData.selectx+a) && RRData.robot_white_y_m==(RRData.selecty))) {a--;break;}
				}else break;
			}
			RRData.gotox=RRData.selectx+a;
			RRData.gotoy=RRData.selecty;
			if(RRData.gotox>15)RRData.gotox=15;
			RRData.animation=true;
			new ani().start();
		}else if((e.getCode()==KeyCode.LEFT || e.getCode()==KeyCode.A) && RRData.selectx>-1 && RRData.selecty>-1 && RRData.animation==false && RRData.steps==3){//左键按下
			int a=0;
			while(true) {
				if(RRData.selecty-a>=0) {
					if(RRData.map.getWall()[RRData.selectx][RRData.selecty-a]==null)a++;
					else if(a==0 && (RRData.map.getWall()[RRData.selectx][RRData.selecty-a].charAt(4)=='2' || RRData.map.getWall()[RRData.selectx][RRData.selecty-a].charAt(4)=='3')) a++;
					else if(a>0 && (RRData.map.getWall()[RRData.selectx][RRData.selecty-a].charAt(4)=='2' || RRData.map.getWall()[RRData.selectx][RRData.selecty-a].charAt(4)=='3')) {a--;break;}
					else break;
					if((RRData.robot_blue_x_m==(RRData.selectx) && RRData.robot_blue_y_m==(RRData.selecty-a))||(RRData.robot_red_x_m==(RRData.selectx) && RRData.robot_red_y_m==(RRData.selecty-a))
							||(RRData.robot_green_x_m==(RRData.selectx) && RRData.robot_green_y_m==(RRData.selecty-a))||(RRData.robot_yellow_x_m==(RRData.selectx) && RRData.robot_yellow_y_m==(RRData.selecty-a))
							||(RRData.robot_white_x_m==(RRData.selectx) && RRData.robot_white_y_m==(RRData.selecty-a))) {a--;break;}
				}else break;
			}
			RRData.gotoy=RRData.selecty-a;
			RRData.gotox=RRData.selectx;
			if(RRData.gotoy<0)RRData.gotoy=0;
			RRData.animation=true;
			new ani().start();
		}else if((e.getCode()==KeyCode.RIGHT || e.getCode()==KeyCode.D) && RRData.selectx>-1 && RRData.selecty>-1 && RRData.animation==false && RRData.steps==3){//右键按下
			int a=0;
			while(true) {
				if(RRData.selecty+a<=15) {
					if(RRData.map.getWall()[RRData.selectx][RRData.selecty+a]==null)a++;
					else if(a==0 &&(RRData.map.getWall()[RRData.selectx][RRData.selecty+a].charAt(4)=='1' || RRData.map.getWall()[RRData.selectx][RRData.selecty+a].charAt(4)=='4'))a++;
					else if(a>0 &&(RRData.map.getWall()[RRData.selectx][RRData.selecty+a].charAt(4)=='1' || RRData.map.getWall()[RRData.selectx][RRData.selecty+a].charAt(4)=='4')) {a--;break;}
					else break;
					if((RRData.robot_blue_x_m==(RRData.selectx) && RRData.robot_blue_y_m==(RRData.selecty+a))||(RRData.robot_red_x_m==(RRData.selectx) && RRData.robot_red_y_m==(RRData.selecty+a))
							||(RRData.robot_green_x_m==(RRData.selectx) && RRData.robot_green_y_m==(RRData.selecty+a))||(RRData.robot_yellow_x_m==(RRData.selectx) && RRData.robot_yellow_y_m==(RRData.selecty+a))
							||(RRData.robot_white_x_m==(RRData.selectx) && RRData.robot_white_y_m==(RRData.selecty+a))) {a--;break;}
				}else break;
			}
			RRData.gotoy=RRData.selecty+a;
			RRData.gotox=RRData.selectx;
			if(RRData.gotoy>15)RRData.gotoy=15;
			RRData.animation=true;
			new ani().start();
		}
	}
	/**
	 * 按下reset
	 */
	public void onPressForReset() {
		reset.setStyle("-fx-background-color:#eeeeee");
		RRData.map.iniMap();
		canvas.requestFocus();
		RRData.steps=0;
		RRData.selectx=-1;
		RRData.selecty=-1;
		RRData.selectcolor=null;
		player1name.setTextFill(Color.WHITE);
		player2name.setTextFill(Color.WHITE);
		RRData.second=3;
		RRData.playeractive=0;
		can.draw(canvas.getGraphicsContext2D());
	}
	/**
	 * 松开reset
	 */
	public void onReleaseForReset() {
		reset.setStyle("-fx-background-color:#ffffff");
	}
	private class jishi extends Thread{
		@Override
		public void run() {
			try {
				while(RRData.steps==2) {
					Thread.sleep(1000);
					RRData.second--;
					if(RRData.second<=0) {//计时结束
						RRData.steps=3;
						player1steps.setEditable(false);
						player2steps.setEditable(false);
						if(player1steps.getSelectionModel().getSelectedIndex()<player2steps.getSelectionModel().getSelectedIndex())RRData.isplayer1=true;
						if(RRData.isplayer1)player1name.setTextFill(Color.GREEN);
						else player2name.setTextFill(Color.GREEN);
					}
					Platform.runLater(new Runnable() {	
						@Override
						public void run() {
							can.draw(canvas.getGraphicsContext2D());
						}
					});
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private class ani extends Thread{
		private int xx=0,yy=0;
		public ani() {
			if(RRData.gotox>RRData.selectx)xx=4;
			else if(RRData.gotox<RRData.selectx)xx=-4;
			if(RRData.gotoy>RRData.selecty)yy=4;
			else if(RRData.gotoy<RRData.selecty)yy=-4;
		}
		@Override
		public void run() {
			try {
				RRData.playeractive++;
				while(RRData.animation) {
					RRData.movex+=xx;
					RRData.movey+=yy;
					if(Math.abs(RRData.movex/44.0+RRData.selectx-RRData.gotox)<0.1 && Math.abs(RRData.movey/44.0+RRData.selecty-RRData.gotoy)<0.1) {
						//判断移动的机器人颜色
						if(RRData.selectcolor.equals("blue")) {
							RRData.robot_blue_x_m=RRData.gotox;
							RRData.robot_blue_y_m=RRData.gotoy;
						}else if(RRData.selectcolor.equals("red")) {
							RRData.robot_red_x_m=RRData.gotox;
							RRData.robot_red_y_m=RRData.gotoy;
						}else if(RRData.selectcolor.equals("green")) {
							RRData.robot_green_x_m=RRData.gotox;
							RRData.robot_green_y_m=RRData.gotoy;
						}else if(RRData.selectcolor.equals("yellow")) {
							RRData.robot_yellow_x_m=RRData.gotox;
							RRData.robot_yellow_y_m=RRData.gotoy;
						}else if(RRData.selectcolor.equals("white")) {
							RRData.robot_white_x_m=RRData.gotox;
							RRData.robot_white_y_m=RRData.gotoy;
						}
						//计算步数是否用完
						if(RRData.playeractive<=((RRData.isplayer1)?player1steps.getSelectionModel().getSelectedIndex():player2steps.getSelectionModel().getSelectedIndex())) {
							if(RRData.map.getMap()[RRData.gotox][RRData.gotoy]!=null)if(RRData.map.getMap()[RRData.gotox][RRData.gotoy].equals(RRData.target)) {//成功
								RRData.steps=4;
								Platform.runLater(new Runnable() {
									@Override
									public void run() {
										if(RRData.isplayer1)score1.setText((Integer.valueOf(score1.getText())+1)+"");
										else score2.setText((Integer.valueOf(score2.getText())+1)+"");
									}
								});
							}else if(RRData.isallplayeractive) {//都失败
								onPressForReset();
							}
						}else {//用完了，没有成功
							if(RRData.isplayer1) {
								player1name.setTextFill(Color.WHITE);
								player2name.setTextFill(Color.GREEN);
							}else {
								player2name.setTextFill(Color.WHITE);
								player1name.setTextFill(Color.GREEN);
							}
							RRData.robot_blue_x_m=RRData.robot_blue_x;
							RRData.robot_blue_y_m=RRData.robot_blue_y;
							RRData.robot_red_x_m=RRData.robot_red_x;
							RRData.robot_red_y_m=RRData.robot_red_y;
							RRData.robot_green_x_m=RRData.robot_green_x;
							RRData.robot_green_y_m=RRData.robot_green_y;
							RRData.robot_yellow_x_m=RRData.robot_yellow_x;
							RRData.robot_yellow_y_m=RRData.robot_yellow_y;
							RRData.robot_white_x_m=RRData.robot_white_x;
							RRData.robot_white_y_m=RRData.robot_white_y;
							RRData.playeractive=0;
							RRData.isplayer1=!RRData.isplayer1;
							RRData.isallplayeractive=true;
						}
						RRData.selectx=-1;
						RRData.selecty=-1;
						RRData.selectcolor=null;
						RRData.gotox=-1;
						RRData.gotoy=-1;
						RRData.animation=false;
						RRData.movex=0;
						RRData.movey=0;
					}
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							can.draw(canvas.getGraphicsContext2D());
							canvas.requestFocus();
						}
					});
					Thread.sleep(50);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
