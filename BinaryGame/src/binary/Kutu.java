package binary;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;


public class Kutu extends JPanel implements ActionListener{
	private int Toplam;
	private int Toplam2;
	private int skor;
	private int onceki=0;
	private int level=1;
	private Random rand;
	private int rastgele=50;
	private int rastgele2=1;
	private int rastgele3=1;
	private Color c=Color.YELLOW;
	private Color c1=Color.BLUE;
	private Timer timer;
	private double ÝNÝTAL_Y=0;
	private ArrayList<Kutular> kutu;
	private final int sabitWIDTH = 70;
	private final int sabitHEIGHT = 70;
	private final Font smallFont = new Font("Helvetica", Font.BOLD, 14);
	private final static double [] pos = {0, 75,150,225,300,375,450,525,600};
	private final static int [] decimal = {256,128,64,32,16,8,4,2,1};    
	private final static int [] degisim = {6,4,5,8,3,5,6,5,4};   
	JTextField text1;
	
	public Kutu() {
		initKutu();
		initKutular();
		
		RandomYap(rastgele);
		RandomYap2(2);
		
	}
	
	public void initKutu() {
		setFocusable(true);
        setBackground(c1);          
        timer = new Timer(30,this);
        timer.start();
        
	}
	public void initKutular() {

        kutu = new ArrayList<>();
        int sayac=0;
        for (double p : pos) {
        	kutu.add(new Kutular((int)p,(int)ÝNÝTAL_Y,decimal[sayac], c));
            sayac++;
            
        }
        text1 = new JTextField("");
        
		add(text1);
    }
		 
	
	public void Drawkutu(Graphics g) {
		Rectangle2D rect ;
		Rectangle2D rect2 ;
		int sayac=0;
		for (Kutular kutular : kutu) {
			rect =new Rectangle2D.Double(kutular.getX(),kutular.getY(),sabitWIDTH,sabitWIDTH);
			rect2 =new Rectangle2D.Double(kutular.getX(),610,sabitWIDTH,sabitWIDTH-20);
		    Graphics2D g1 = (Graphics2D)g;
		    g1.setPaint(kutular.getrenk());
		    g1.fillRect(kutular.getX(), kutular.getY(), sabitWIDTH, sabitWIDTH);
		    g1.fillRect(kutular.getX(),610,sabitWIDTH,sabitWIDTH-20);
	        g1.draw(rect);
	        g1.draw(rect2);
	        g1.setColor(Color.black);
	        g1.setFont(smallFont);
	        g1.drawString(""+kutular.aktiflikgetir(), kutular.getX()+sabitWIDTH/2-5, kutular.getY()+sabitWIDTH/2);
	        g1.drawString(""+decimal[sayac] , kutular.getX()+sabitWIDTH/2-10, 635);
	        g1.setColor(Color.white);
	        if(rastgele2==1) {
	        	 g1.drawString("Bulmanýz Gereken Deger: " + rastgele, 701, 200);
	        	 text1.setVisible(false);
	        }
	        g1.drawString("Eski Binary Degeri:" + Integer.toString(onceki, 2), 701, 300);
	        
	       
	        
	     
	        g1.drawString("Skorunuz: " + skor, 701, 150);
	        g1.drawString("Level: " + level, 701, 100);
	        g1.drawLine(0, 600, 700, 600);
	        g1.drawLine(700, 0, 700, 600);
	        sayac++;
	        
		}
		text1.setBounds(701,230, 200, 30);
		
			
		
	}	
		
	public void RandomYap3() {
		rand =new Random();
		rastgele3=rand.nextInt(10) + 1;
		
			
	}
	public void RandomYap(int x) {
		rand =new Random();
		rastgele=rand.nextInt(x) + 1;
		rastgele=rastgele+rastgele3;
		if(rastgele2==1)
			text1.setText(""+rastgele);
			
	}
	public void RandomYap2(int x) {
		rand =new Random();
		rastgele2=rand.nextInt(x) + 1;
		if(rastgele2==2) {
			text1.setVisible(true);
			text1.setText(""+0);
		}
			
	}
	
	@Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
        Drawkutu(g);
       
                
    }
	public void check2() {
		if(rastgele2==2) {
			Toplam2=rastgele;
			for (Kutular kutular : kutu) {
				if(Toplam2-kutular.getDeger()>=0) {
					Toplam2-=kutular.getDeger();
					kutular.aktiflik=true;
    				kutular.c=c.RED;
				}
			}
			
		}
	}
	public void check() {
		
		if(rastgele2==1) {
			
			this.addMouseListener(new MouseListener() {
				
		        @Override
		        public void mouseClicked(MouseEvent e ) {
		        	
		           	for (Kutular kutular : kutu) {	 
		           		
		        		if((e.getX()>=kutular.getX() && e.getX()<=kutular.getX()+sabitWIDTH) &&
		        				(e.getY()+200>=kutular.getY()&& e.getY()<=kutular.getY()+sabitHEIGHT)) {
		        			
		        			if(kutular.aftiflik()) {
		        				Toplam-=kutular.getDeger();
		        				kutular.aktiflik=false;
		        				kutular.c=c.YELLOW;
		        				break;
		           				
		        			}
		        			else {
		        				Toplam+=kutular.getDeger();
		        				kutular.aktiflik=true;
		        				kutular.c=c.RED;
		        				break;
		        			}
			            	
			             }
			        }
		           	
		        }
		         	        
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
			
		}
		//if(this.getMouseListeners()[0] != null) {
			//this.removeMouseListener(this.getMouseListeners()[0]);
		/*for(MouseListener a:this.getMouseListeners()) {
			this.removeMouseListener(a);
		}
		*/
		//}
		
	}
	public void kontrol(){
		if(rastgele2==2) {
			int cevir=0;
			try {
				cevir = Integer.parseInt(text1.getText());
	        } catch (NumberFormatException n) {
	            cevir=0;
	        }
			
			if(rastgele==cevir) {
				onceki=rastgele;
	        	for (Kutular kutular : kutu) {
					kutular.aktiflik=false;
					kutular.c=c.YELLOW;
		        }
	        	if(skor%100==0 && skor!=0) {
					level++;
				}
	        	if(skor<=100) {
					RandomYap(50);
				}
				if(skor>100 && skor<=200) {
					RandomYap(100);
					
				}
				if(skor>200 && skor<=300) {
					RandomYap(200);
					
				}
				if(skor>300 && skor<=400) {
					RandomYap(300);
					
				}
				if(skor>400) {
					RandomYap(511);
					
				}
				
				
				skor+=50;
				RandomYap2(2);
	        }
	        
			
			
		}
		if(rastgele==Toplam){
			Toplam=0;
			onceki=rastgele;
			for (Kutular kutular : kutu) {
				kutular.aktiflik=false;
				kutular.c=c.YELLOW;
	        }
			if(skor%100==0  && skor!=0) {
				level++;
			}
			if(skor<=100) {
				RandomYap(50);
			}
			if(skor>100 && skor<=200) {
				RandomYap(100);
				
			}
			if(skor>200 && skor<=300) {
				RandomYap(200);
				
			}
			if(skor>300 && skor<=400) {
				RandomYap(300);
				
			}
			if(skor>400) {
				RandomYap(511);
				
			}
			skor+=50;
			RandomYap2(2);
			
		}
		repaint();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		int sayac=0;
		for (Kutular kutular : kutu) {
			kutular.move(degisim[sayac]);
			sayac++;
        }
		RandomYap3();
		check();
		check2();
		kontrol();
		repaint();
		
	}

	
	


}
