package ru.shalicikkomarov;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainFrame extends JFrame {
	private Container root;
	private SnakeField snakeField;

	public MainFrame() throws IOException {
		super("Snake");
		root = getContentPane();
        snakeField = new SnakeField();
        root.add(snakeField);
        this.pack();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        new Thread(new SnakeThread()).start();
	}
    
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
					new MainFrame().setVisible(true);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });
    }
    
    class SnakeThread implements Runnable{
        @Override
        public void run() {
            while(!snakeField.GameOver) {
            	snakeField.repaint();
            }
        }
    }
}
