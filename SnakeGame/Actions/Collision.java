package Actions;

import game.Snake;

public class Collision {
    
	public static boolean collideSelf() {
		for(int i = 0; i < Snake.tail.size(); i++) {
			if(Snake.head.getX() == Snake.tail.get(i).getX() && Snake.head.getY() == Snake.tail.get(i).getY() && !Snake.tail.get(i).isWait()) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean collideWall() {

		return (Snake.head.getX() < 0 || Snake.head.getX() > 15 || Snake.head.getY() < 0 || Snake.head.getY() > 15);
	}
	
	public static void collidePickUp() {
		if(Snake.head.getX() == Snake.pickup.getX() && Snake.head.getY() == Snake.pickup.getY()) {
			Snake.pickup.reset();
			Snake.addTail();
			Snake.score += 1;
			if(Snake.score > Snake.bestscore) {
				Snake.bestscore = Snake.score;
			}
		}
	}
}
