package Ocom.com;

import java.awt.Color;

public class OperaColor extends Color {

	public OperaColor(int r, int g, int b, int a) {
		super(r, g, b, a);
	}

	public String getHex() {
		return toHex(getRed(), getGreen(), getBlue(), getAlpha());
	}
	public static String toHex(int r, int g, int b, int d) {
		return "#" + toBrowserHexValue(r) + toBrowserHexValue(g) + toBrowserHexValue(b);
	}
	private static String toBrowserHexValue(int number) 
	{
		StringBuilder builder = new StringBuilder(Integer.toHexString(number & 0xff));
		StringBuilder zero = new StringBuilder("0");
		while (builder.length() < 2) 
		{
			builder = zero.append(builder);
		}
		return builder.toString().toUpperCase();
	}
	public static void main(String[] args) {
		OperaColor j = new OperaColor(11, 117, 117, 1);
		double d=0.72;
		         int a1=(int)d;
		int i = (int) 0.72;

		System.out.println(j.getHex());
		System.out.println(toHex(87,239, 239, i));

	}

}
