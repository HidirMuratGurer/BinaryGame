package binary;

import java.awt.Color;

import javax.swing.JFrame;


public class MainClass extends JFrame {
	
	public MainClass() {

        initUI();
    }

    private void initUI() {
    	
        add(new Kutu());
       
        setResizable(false);
        pack();
        setBackground(Color.BLUE);
        setSize(950,700);
       
        setTitle("Binary Game");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.white);
    }
    public static void main(String[] args) {

    	MainClass ex = new MainClass();
        ex.setVisible(true);
		
    }
}