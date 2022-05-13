package binary;

import java.awt.Color;

public class Kutular extends Bilgiler {
	 private final int INITIAL_Y = 0;
	 
	    public Kutular(int x, int y,int deger,Color c) {
	        super(x, y, deger,c);
	        
	       
	    }

	    public void move(int degisim) {

	        if (y > 500) {
	            y = INITIAL_Y;
	        }

	        y += degisim;
	    }
}
