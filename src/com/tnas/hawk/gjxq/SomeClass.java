package com.tnas.hawk.gjxq;

public class SomeClass {

	private int x;
	private String y;

	public SomeClass(int x1, String y1) {
		x = x1;
		y = y1;
	}

	public SomeClass() {
		x = 0;
		y = " ";
	}

	public SomeClass(SomeClass other) {
		x = other.x;
		y = other.y;
	}

	public String toString() {
		return new String(x + " " + y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SomeClass other = (SomeClass) obj;
		if (x != other.x)
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}

	public static void main(String[] args) {
		SomeClass obj_1 = new SomeClass(15, "message");
		SomeClass obj_2 = new SomeClass(obj_1);
		System.out.println(obj_2.toString());
		
		SomeClass obj_3 = new SomeClass(15, "message");
		System.out.println(obj_1.equals(obj_3));
	}

}
