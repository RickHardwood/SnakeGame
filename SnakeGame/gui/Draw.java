package gui;

import javax.swing.*;

import game.Snake;

import java.awt.*;

public class Draw extends JLabel {
	
	Point p;
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

		// Draw Background
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, Gui.width, Gui.height);

		// Draw Snake Tail
		g.setColor(new Color(175, 0, 255));
		for (int i = 0; i < Snake.tail.size(); i++) {
			p = Snake.ptc(Snake.tail.get(i).getX(), Snake.tail.get(i).getY());
			g.fillRect(p.x, p.y, 32, 32);
		}

		// Draw Snake Head
		g.setColor(new Color(13, 8, 81));
		p = Snake.ptc(Snake.head.getX(), Snake.head.getY());
		g.fillRect(p.x, p.y, 32, 32);
		
		//Draw PickUp
		g.setColor(new Color(204, 51, 0));
		p = Snake.ptc(Snake.pickup.getX(), Snake.pickup.getY());
		g.fillRect(p.x, p.y, 32, 32);

		// Draw Grid
		g.setColor(Color.GRAY);
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				g.drawRect(i * 32 + Gui.xoff, j * 32 + Gui.yoff, 32, 32);
			}
		}

		// Draw Border
		g.setColor(Color.BLACK);
		g.drawRect(Gui.xoff, Gui.yoff, 512, 512);
		repaint();
		
		//Draw Score
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("Score: "+Snake.score, 5, 25);
		g.drawString("Best: "+Snake.bestscore, 655, 25);
	}
}
