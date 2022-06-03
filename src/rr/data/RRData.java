package rr.data;

import rr.model.MMap;
import rr.ui.RRImage;

public class RRData {
	public static int mode=0;//难度模式
	public static int robot_red_x,robot_red_y;//记录红色机器人原始坐标
	public static int robot_blue_x,robot_blue_y;//记录蓝色机器人原始坐标
	public static int robot_green_x,robot_green_y;//记录绿色机器人原始坐标
	public static int robot_yellow_x,robot_yellow_y;//记录黄色机器人原始坐标
	public static int robot_white_x,robot_white_y;//记录白色机器人原始坐标
	public static int robot_red_x_m,robot_red_y_m;//记录红色机器人当前坐标
	public static int robot_blue_x_m,robot_blue_y_m;//记录蓝色机器人当前坐标
	public static int robot_green_x_m,robot_green_y_m;//记录绿色机器人当前坐标
	public static int robot_yellow_x_m,robot_yellow_y_m;//记录黄色机器人当前坐标
	public static int robot_white_x_m,robot_white_y_m;//记录白色机器人当前坐标
	public static RRImage im=new RRImage();//图片管理类
	public static MMap map=new MMap();//地图数据类
	public static int steps=0;//当前回合
	public static String target;//当前对局中间显示的卡片id
	public static int second=3;//当第一个玩家决定步数后，开始倒计时
	public static int selectx=-1,selecty=-1;//点击选中的机器人棋子坐标
	public static int gotox,gotoy;//机器人移动的方向终点坐标
	public static double movex,movey;//机器人移动时相对原坐标的偏移量
	public static boolean animation=false;//是否开始播放动画
	public static String selectcolor=null;//选中的机器人棋子颜色
	public static int playeractive=0;//玩家走动的步数记录
	public static boolean isplayer1=false;//是否为玩家1操作证明
	public static boolean isallplayeractive=false;//是否所有玩家都证明完了
}
