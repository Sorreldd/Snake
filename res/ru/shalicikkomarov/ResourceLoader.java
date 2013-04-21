package ru.shalicikkomarov;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ResourceLoader {
	static ResourceLoader rl = new ResourceLoader();
	public static BufferedImage getImage(String filename) throws IOException {
		BufferedImage bf = ImageIO.read(rl.getClass().getResource("images/" + filename));
		return bf;
	}
}
