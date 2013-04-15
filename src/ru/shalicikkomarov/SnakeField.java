package ru.shalicikkomarov;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class SnakeField extends JPanel {
	private BufferedImage img;
	private int backWidth, backHeight;
	File file;
	public static int state[][] = new int[16][12];
	Mouse mouse;
	
	public SnakeField() throws IOException {
		this.setPreferredSize(new Dimension(Cnst.FWIDTH, Cnst.FHEIGHT));
		URL url = this.getClass().getResource("res/background.jpg");
		file = new File(url.getPath());
		img = ImageIO.read(file);
		backWidth = img.getWidth();
		backHeight = img.getHeight();
		mouse = new Mouse();
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, Cnst.FWIDTH, Cnst.FHEIGHT, 0, 0, backWidth, backHeight, this);
		g.setColor(Color.BLACK);
		for(int i = 0; i < 16; i++)
			for(int j = 0; j < 12; j++) 
				g.drawRect(0 + i * 40, 0 + j * 40, Cnst.FCELL, Cnst.FCELL);
		mouse.render(g);
	}
}
