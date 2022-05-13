package binary;

import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Bilgiler {
		protected int x;
	    protected int y;
	    protected boolean aktiflik;
	    protected int deger;
	    protected Color c;
	   
	    public Bilgiler(int x, int y,int deger,Color c) {

	        this.x = x;
	        this.y = y;
	        aktiflik = false;
	        this.deger=deger;
	        this.c=c;
	    }
	    public int aktiflikgetir() {
	    	if(aktiflik) {
	    		return 1;
	    	}
	    	else {
	    		return 0;
	    	}
	    }
	    public int getX() {
	        return x;
	    }

	    public int getY() {
	        return y;
	    }
	    public int getDeger() {
	    	return deger;
	    }
	    public boolean aftiflik() {
	    	return aktiflik;
	    }
	    public Color getrenk() {
	    	return c;
	    }
	  
}
