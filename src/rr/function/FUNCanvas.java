package rr.function;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import rr.data.RRData;
/**
 * 画布绘画
 * @author Administrator
 *
 */
public class FUNCanvas {
	public void draw(GraphicsContext g) {
		//背景
		g.setFill(Color.rgb(102, 85, 68));
		g.fillRect(0, 0, 720, 720);
		//格子
		for(int i=0;i<16;i++)for(int j=0;j<16;j++)
			g.drawImage((i%2==0 && j%2==0)?RRData.im.getImageOfId("bg-1"):RRData.im.getImageOfId("bg-1"), i*44+8, j*44+8, 44, 44);
		//card
		for(int i=0;i<16;i++)for(int j=0;j<16;j++)if(RRData.map.getMap()[i][j]!=null)
			g.drawImage(RRData.im.getImageOfId(RRData.map.getMap()[i][j]), j*44+8, i*44+8, 44, 44);
		//墙
		for(int i=0;i<16;i++)for(int j=0;j<16;j++)if(RRData.map.getWall()[i][j]!=null)
			g.drawImage(RRData.im.getImageOfId(RRData.map.getWall()[i][j]), j*44+8, i*44+8, 44, 44);
		//棋子
		g.drawImage(RRData.im.getImageOfId("player-blue")
				,RRData.robot_blue_y_m*44+8+((RRData.animation && RRData.selectcolor.equals("blue"))?RRData.movey:0)
				,RRData.robot_blue_x_m*44+8+((RRData.animation && RRData.selectcolor.equals("blue"))?RRData.movex:0), 44, 44);
		g.drawImage(RRData.im.getImageOfId("player-red")
				,RRData.robot_red_y_m*44+8+((RRData.animation && RRData.selectcolor.equals("red"))?RRData.movey:0)
				,RRData.robot_red_x_m*44+8+((RRData.animation && RRData.selectcolor.equals("red"))?RRData.movex:0), 44, 44);
		g.drawImage(RRData.im.getImageOfId("player-green")
				,RRData.robot_green_y_m*44+8+((RRData.animation && RRData.selectcolor.equals("green"))?RRData.movey:0)
				,RRData.robot_green_x_m*44+8+((RRData.animation && RRData.selectcolor.equals("green"))?RRData.movex:0), 44, 44);
		g.drawImage(RRData.im.getImageOfId("player-yellow")
				,RRData.robot_yellow_y_m*44+8+((RRData.animation && RRData.selectcolor.equals("yellow"))?RRData.movey:0)
				,RRData.robot_yellow_x_m*44+8+((RRData.animation && RRData.selectcolor.equals("yellow"))?RRData.movex:0), 44, 44);
		if(RRData.mode>1)g.drawImage(RRData.im.getImageOfId("player-white")
				,RRData.robot_white_y_m*44+8+((RRData.animation && RRData.selectcolor.equals("white"))?RRData.movey:0)
				,RRData.robot_white_x_m*44+8+((RRData.animation && RRData.selectcolor.equals("white"))?RRData.movex:0), 44, 44);
		//选中
		if(RRData.selectcolor!=null) {
			g.setStroke(Color.RED);
			g.setLineWidth(2);
			g.beginPath();
			g.strokeRect(RRData.selecty*44+10, RRData.selectx*44+10, 40, 40);
			g.closePath();
		}
		//目的
		if(RRData.target!=null)g.drawImage(RRData.im.getImageOfId(RRData.target), 316, 316,88,88);
		//提示
		g.setLineWidth(1);
		if(RRData.steps==0) {//准备
			g.setFill(Color.RED);
			g.setFont(new Font(40));
			g.fillText("Press the spacebar to start", 105, 340);
		}else if(RRData.steps==1) {//第一次不限时，寻找路线
			g.setFill(Color.GREEN);
			g.setFont(new Font(36));
			g.fillText("End the round after selecting", 100, 340);
			g.fillText("the number of steps", 185, 380);
		}else if(RRData.steps==2) {//倒计时
			g.setFill(Color.RED);
			g.setFont(new Font(40));
			g.fillText("Time", 320, 320);
			g.fillText(RRData.second+"", 360-(RRData.second+"").length()*10, 360);
		}else if(RRData.steps==4) {//结束
			g.setFill(Color.RED);
			g.setFont(new Font(40));
			if(RRData.isplayer1)g.fillText("Player 1 is win!", 217, 340);
			else g.fillText("Player 2 is win!", 217, 340);
		}
	}
}
