package game;

import java.awt.*;
import java.util.ArrayList;

import gui.Gui;

public class Snake {

	public static int score = 0, bestscore = 0;
	
	public static boolean waitToMove = false;

	public static Head head = new Head(7, 7);
	
	public static ArrayList<Tail> tail = new ArrayList<>();
	
	public static PickUp pickup = new PickUp();

	public static void addTail() {
		if (tail.size() < 1) {
			tail.add(new Tail(head.getX(), head.getY()));
		} else {
			tail.add(new Tail(tail.get(tail.size() - 1).x, tail.get(tail.size() - 1).y));
		}
	}

	public static void move() {
		// Move Tail
		if (tail.size() >= 2) {
			for (int i = tail.size() - 1; i >= 1; i--) {
				if (tail.get(i).isWait()) {
					tail.get(i).setWait(false);
				} else {
					tail.get(i).setX(tail.get(i - 1).getX());
					tail.get(i).setY(tail.get(i - 1).getY());
				}
			}
		}

		// Move first tail to Head
        if(tail.size() >= 1) {
			if (tail.get(0).isWait()) {
				tail.get(0).setWait(false);
			} else {
				tail.get(0).setX(head.getX());
				tail.get(0).setY(head.getY());
			}
		}

		// Move Head
		switch (head.getDir()) {
		case RIGHT:
			head.setX(head.getX() + 1);
			break;
		case UP:
			head.setY(head.getY() - 1);
			break;
		case LEFT:
			head.setX(head.getX() - 1);
			break;
		case DOWN:
			head.setY(head.getY() + 1);
			break;
        }
	}

	// Position to Coordinates
	public static Point ptc(int x, int y) {
		Point p = new Point(0, 0);
		p.x = x * 32 + Gui.xoff;
		p.y = y * 32 + Gui.yoff;
		return p;
	}
}
