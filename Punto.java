package Ejer1;


public class Punto {
 int x;
 int y;

	 public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
 
	public String toString(){
		return "(" + x + "," + y + ")";
	}
	 
}
