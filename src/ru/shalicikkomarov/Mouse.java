package ru.shalicikkomarov;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

public class Mouse {
	int mx, my, k;
	Random r = new Random();
	Point points[] = new Point[16 * 12];
	public Mouse() {
		k = 0;
		for(int i = 0; i < 16; i++) {
			for(int j = 0; j < 12; j++) {
				if(SnakeField.state[i][j] != 1) {
					points[k] = new Point(i, j);
					k++;
				}
			}
		}
		k = r.nextInt(k);
	}
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.drawOval(points[k].x * Cnst.FCELL, points[k].y * Cnst.FCELL, Cnst.FCELL, Cnst.FCELL);
	}
}
