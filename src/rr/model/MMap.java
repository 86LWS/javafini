package rr.model;

import java.util.Random;

import rr.data.RRData;

public class MMap {
	private String[][] map=new String[16][16];
	private String[][] wall=new String[16][16];
	private String[] mode1wall=new String[] {"blue-1","blue-2","blue-3","blue-4","red-1","red-2","red-3","red-4","green-1","green-2","green-3","green-4","yellow-1","yellow-2","yellow-3","yellow-4"
			,"spawn-red","spawn-blue","spawn-green","spawn-yellow"};
	private String[] mode2wall=new String[] {"spawn-white"};
	private String[] mode3wall=new String[] {"mirror-blue","mirror-red","mirror-green","mirror-yellow","mirror-white"};
	/**
	 * 创建地图
	 */
	public void iniMap() {
		map=new String[16][16];
		wall=new String[16][16];
		Random ra=new Random();
		//初始化地图
		for(int i=0;i<16;i++)for(int j=0;j<16;j++) {
			map[i][j]=null;
			wall[i][j]=null;
		}
		wall[7][7]="wall1";
		wall[7][8]="wall2";
		wall[8][7]="wall4";
		wall[8][8]="wall3";
		map[7][7]="no-entry-zone";
		map[7][8]="no-entry-zone";
		map[8][7]="no-entry-zone";
		map[8][8]="no-entry-zone";
		//填充mode1
		for(int i=0;i<mode1wall.length;i++) {
			while(true) {
				int x=ra.nextInt(16),y=ra.nextInt(16);
				if(map[x][y]==null && wall[x][y]==null) {
					map[x][y]=mode1wall[i];
					if(i<mode1wall.length-4)wall[x][y]="wall"+(ra.nextInt(4)+1);
					if(mode1wall[i].equals("spawn-red")) {
						RRData.robot_red_x=x;
						RRData.robot_red_y=y;
						RRData.robot_red_x_m=x;
						RRData.robot_red_y_m=y;
					}else if(mode1wall[i].equals("spawn-blue")) {
						RRData.robot_blue_x=x;
						RRData.robot_blue_y=y;
						RRData.robot_blue_x_m=x;
						RRData.robot_blue_y_m=y;
					}else if(mode1wall[i].equals("spawn-green")) {
						RRData.robot_green_x=x;
						RRData.robot_green_y=y;
						RRData.robot_green_x_m=x;
						RRData.robot_green_y_m=y;
					}else if(mode1wall[i].equals("spawn-yellow")) {
						RRData.robot_yellow_x=x;
						RRData.robot_yellow_y=y;
						RRData.robot_yellow_x_m=x;
						RRData.robot_yellow_y_m=y;
					}
					break;
				}
			}
		}
		for(int i=0;i<8;i++) {
			while(true) {
				int x=ra.nextInt(16),y=ra.nextInt(16);
				if(map[x][y]==null) {
					wall[x][y]="wall"+(ra.nextInt(4)+1);
					break;
				}
			}
		}
		//填充mode2
		if(RRData.mode==2) {
			for(int i=0;i<mode2wall.length;i++) {
				while(true) {
					int x=ra.nextInt(16),y=ra.nextInt(16);
					if(map[x][y]==null) {
						map[x][y]=mode2wall[i];
						if(mode1wall[i].equals("spawn-white")) {
							RRData.robot_white_x=x;
							RRData.robot_white_y=y;
							RRData.robot_white_x_m=x;
							RRData.robot_white_y_m=y;
						}
						break;
					}
				}
			}
		}
		//填充mode3
		if(RRData.mode==3) {
			for(int i=0;i<mode3wall.length;i++) {
				while(true) {
					int x=ra.nextInt(16),y=ra.nextInt(16);
					if(map[x][y]==null) {
						map[x][y]=mode3wall[i]+"-"+(ra.nextInt(2)+1);
						break;
					}
				}
			}
		}
	}
	public String[][] getMap(){
		return map;
	}
	public String[][] getWall(){
		return wall;
	}
}
