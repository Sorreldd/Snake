package ru.shalicikkomarov;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class SnakeField extends JPanel {
	private static BufferedImage img, gameover;
	public static BufferedImage imgmouse;
	private int backWidth, backHeight;
	private File file;
	private URL url;
	public static int state[][] = new int[16][12];
	static Mouse mouse;
	static Snake snake;
	static boolean GameOver;
	
	public SnakeField() throws IOException {
		this.setPreferredSize(new Dimension(Cnst.FWIDTH, Cnst.FHEIGHT));
		url = this.getClass().getResource("res/background.jpg");
		file = new File(url.getPath());
		img = ImageIO.read(file);
		backWidth = img.getWidth();
		backHeight = img.getHeight();
		url = this.getClass().getResource("res/spmouse.png");
		file = new File(url.getPath());
		imgmouse = ImageIO.read(file);
		url = this.getClass().getResource("res/gameover.jpg");
		file = new File(url.getPath());
		gameover = ImageIO.read(file);
		snake = new Snake();
		GameOver = false;
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, Cnst.FWIDTH, Cnst.FHEIGHT, 0, 0, backWidth, backHeight, this);
		g.setColor(Color.BLACK);
		for(int i = 0; i < 16; i++)
			for(int j = 0; j < 12; j++) 
				g.drawRect(i * Cnst.FCELL, j * Cnst.FCELL, Cnst.FCELL, Cnst.FCELL);
		mouse.render(g, this);
		GameOver = snake.isOver();
		if(GameOver) {
			g.drawImage(gameover, 0, 0, Cnst.FWIDTH, Cnst.FHEIGHT, 0, 0, gameover.getWidth(), gameover.getHeight(), this); 
			g.setColor(Color.RED);
			g.drawString("Press ENTER to continue...", 330, 500);
		}
		if(mouse.mouseDead)mouse = new Mouse();
	}
}
