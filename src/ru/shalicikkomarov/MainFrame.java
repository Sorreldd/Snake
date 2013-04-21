package ru.shalicikkomarov;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class MainFrame extends JFrame {
	private Container root;
	private SnakeField snakeField;

	public MainFrame() throws IOException {
		super("Snake");
		root = getContentPane();
        snakeField = new SnakeField();
        root.add(snakeField);
        this.addKeyListener(new EventKey());
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
	class EventKey implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(Snake.isMove) {
				Snake.isMove = false;
				SnakeElem elem = Snake.sl.get(0);
				switch (key) {
					case KeyEvent.VK_UP:
						if(elem.z != 2) elem.z = 0;
						break;
					case KeyEvent.VK_DOWN:
						if(elem.z != 0) elem.z = 2;
						break;
					case KeyEvent.VK_LEFT:
						if(elem.z != 1) elem.z = 3;
						break;
					case KeyEvent.VK_RIGHT:
						if(elem.z != 3) elem.z = 1;
						break;
					default:
						break;
				}
				Snake.sl.set(0, elem);
			}
		}
		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
		}
		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
		}
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
