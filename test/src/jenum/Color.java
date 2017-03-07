package jenum;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum Color {
	RED(255, 0, 0), BLUE(0, 0, 255), BLACK(0, 0, 0), YELLOW(255, 255, 0), GREEN(
			0, 255, 0);
	private int redValue;
	private int greenValue;
	private int blueValue;

	private Color(int rv, int gv, int bv) {
		this.redValue = rv;
		this.greenValue = gv;
		this.blueValue = bv;
	}

	public String toString() { // ∏≤∏«¡À∏∏¿‡EnumµƒtoString()
		return super.toString() + "(" + redValue + "," + greenValue + ","
				+ blueValue + ")";
	}
	
	public static void main(String[] args) {
//		System.out.println(EnumTest.Signal.RED);
//		Map<String, Object> m = new HashMap<String, Object>();
//		m.put("ss", EnumTest.Signal.YELLOW);
//		System.out.println(m.get("ss"));
		Color color = Color.BLACK;
//		System.out.println(color);
//		Color[] cs = Color.values();
//		for (Color c : cs) {
//			System.out.println(c.ordinal() + ": " + c);
//		}
//		System.out.println(Color.valueOf("BLUE"));
		System.out.println(color.name() + "," + color.blueValue);
	}
}
