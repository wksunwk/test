package jenum;

public class EnumTest {
	
//	public static final char RED = 'a';
//	private enum xx {SS, XX};
	
	public static void main(String[] args) {
		
		Signal color = Signal.RED;
		switch (color) {
        case RED:
            color = Signal.GREEN;
            break;
        case YELLOW:
            color = Signal.RED;
            break;
        case GREEN:
            color = Signal.YELLOW;
            break;
        }
		System.out.println(color);
		System.out.println(color.ordinal());
		System.out.println(color.compareTo(Signal.YELLOW));
		Signal[] colors=Signal.values();
        for(Signal c:colors){
               System.out.print(c+","); 
        }//
        System.out.println(Signal.valueOf("GREEN"));
        
        for(Signal c:colors){
            System.out.print(c.ordinal()+","); 
        }
		
//		Color c = Color.BLACK;
//		System.out.println(c);
	}
	
	enum Signal {
	    GREEN(1), YELLOW(2), RED(3);
	    private Signal(int index) {
	    	this.index = index;
	    }
	    private int index = 0;
	    public String toString() {
	    	return super.toString() + ": " + index;
	    }
	}
}