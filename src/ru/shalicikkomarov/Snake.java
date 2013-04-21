package ru.shalicikkomarov;

import java.awt.*;
import java.util.ArrayList;


public class Snake {
	ArrayList<SnakeElem> sl = new ArrayList<SnakeElem>();
	SnakeElem e;
	public Snake() {
		sl.add(new SnakeElem(1, 0, 1));
		sl.add(new SnakeElem(0, 0, 1));
	}
	public void render(Graphics g, SnakeField io) {
		g.setColor(Color.RED);
		for(int i = 0; i < sl.size(); i++) {
			e = sl.get(i);
			g.drawOval(e.x * Cnst.FCELL, e.y * Cnst.FCELL, Cnst.FCELL, Cnst.FCELL);
		}
	}
}
