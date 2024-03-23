/* Jason Yescas
   Object-Oriented Programming : CPSC-24500-001
   3/22/2024
   Assignment 5
   Purpose: shows nodes in an x y coordinate system */

package a5;
public class Node {
	private static final int MIN_VAL = -100;
	private static final int MAX_VAL = 100;
	private int x;
	private int y;
	
	/**
	 * Default constructor that initializes x and y to 0
	 */
	public Node() {
		this(0,0);
	}
	
	/**
	 * Constructor that accepts x and y coordinates
	 * @param x
	 * @param y
	 */
	public Node(int x, int y) {
		setX(x);
		setY(y);
	}
	
	/**
	 * Copy constructor
	 * @param other
	 */
	public Node(Node other) {
		this(other.x, other.y);
	}
	
	/**
	 * Sets X coordinate if its within range
	 * @param x
	 */
	public void setX(int x) {
		validCoord(x);
		this.x = x;
	}
	
	/**
	 *  Sets Y coordinate if its within range
	 * @param y
	 */
	public void setY(int y) {
		validCoord(y);
		this.y = y;
	}
	
	/**
	 * Gets the X coordinate
	 * @return
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Gets the Y coordinate
	 * @return
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Adds another nodes coordinates to this node
	 * @param other
	 */
	public void add(Node other) {
		int newX = this.x + other.x;
		int newY = this.y + other.y;
		validCoord(newX);
		validCoord(newY);
		this.x = newX;
		this.y = newY;
	}
	
	/**
	 * Validates if the coordinate is within the range
	 * @param val
	 */
	private void validCoord(int val) {
		if (val < MIN_VAL || val > MAX_VAL) {
			throw new IllegalArgumentException("Coordinate value has to be between "+ MIN_VAL +" and "+ MAX_VAL);
		}
	}
	
	/**
	 * Returns a string of the node
	 */
	@Override
	public String toString() {
		return "("+ x +", "+ y +")";
	}
	
	/**
	 * Checks if two nodes are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Node node = (Node) obj;
		return this.x == node.x && this.y == node.y;
	}
}