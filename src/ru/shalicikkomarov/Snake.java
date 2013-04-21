package ru.shalicikkomarov;

import java.awt.*;
import java.util.ArrayList;

public class Snake {
	static ArrayList<SnakeElem> sl = new ArrayList<SnakeElem>();
	SnakeElem e, newE;
	private long nowTime = 0, lastTime = 0;
	public static boolean isMove;
	
	public Snake() {
		sl.add(new SnakeElem(1, 0, 1));
		sl.add(new SnakeElem(0, 0, 1));
		isMove = true;
	}
	public void render(Graphics g, SnakeField io, Mouse mikki) {
		nowTime = System.currentTimeMillis();
		g.setColor(Color.RED);
		for(int i = 0; i < sl.size(); i++) {
			e = sl.get(i);
			g.fillOval(e.x * Cnst.FCELL, e.y * Cnst.FCELL, Cnst.FCELL, Cnst.FCELL);
		}
		if(nowTime - lastTime > 200) {
			e = sl.get(sl.size() - 1);
			newE = new SnakeElem(e.x, e.y, e.z);
			move();
			e = sl.get(0);
			if(e.x == mikki.mx / Cnst.FCELL && e.y == mikki.my / Cnst.FCELL) {
				mikki.mouseDead = true;
				sl.add(newE);
			}
			isMove = true;
			lastTime = nowTime;
		}
		
	}

	private void move() {
		for(int i = 0; i < sl.size(); i++) {
			e = sl.get(i);
			switch(e.z) {
				case 0:
					e.y--;
					break;
				case 1:
					e.x++;
					break;
				case 2:
					e.y++;
					break;
				case 3: 
					e.x--;
					break;
				default: 
					break;
			}
			if(e.x < 0) e.x = 15;
			if(e.y < 0) e.y = 11;
			e.x %= 16;
			e.y %= 12;
			sl.set(i, e);
		}
		for(int i = sl.size() - 1; i > 0; i--) {
			e = sl.get(i);
			e.z = sl.get(i - 1).z;
			sl.set(i, e);
		}
	}
	public boolean isOver() {
		for(int i = 0; i < 16; i++) 
			for(int j = 0; j < 12; j++) 
				SnakeField.state[i][j] = 0;
		for(int i = 0; i < sl.size(); i++) {
			e = sl.get(i);
			if(SnakeField.state[e.x][e.y] == 1) return true;
			else SnakeField.state[e.x][e.y] = 1;
		}
		return false;
	}
}
