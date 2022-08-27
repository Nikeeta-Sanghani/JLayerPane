/*
 * THIS IS AN EXAMPLE FOR OVERLAPING OF THREE JLAYER SMALLER SIZE THAN THE WHOLE PANE
 * TO OVERLAP OTHER LAYER WHEN CLICKED ON
 */
package jlayerpane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class Jlayeredpane  {
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLayeredPane jp;
    JFrame frame;
     
    public Jlayeredpane() {
	label1=new JLabel();
	label1.setOpaque(true);
	label1.setBounds(50,50, 200, 200);
	label1.setBackground(Color.RED);
	
	label2=new JLabel();
	label2.setOpaque(true);
	label2.setBounds(100,100, 200, 200);
	label2.setBackground(Color.GREEN);
	
	label3=new JLabel();
	label3.setOpaque(true);
	label3.setBounds(150,150, 200, 200);
	label3.setBackground(Color.BLUE);
	
	jp=new JLayeredPane();
    jp.setBounds(0, 0,500, 500);
	jp.add(label1);
	jp.add(label2);
	jp.add(label3);
	
	frame=new JFrame("JLayeredPane");
	frame.add(jp);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(new Dimension (500,500));
	frame.setLayout(null);
	frame.setVisible(true);

	label1.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	         // System.out.println("You clicked label1");
	          jp.remove(label1);
	          jp.remove(label2);
	          jp.remove(label3);
	          
	        //  jp.add(label1,JLayeredPane.DRAG_LAYER);
	        //  jp.add(label2,JLayeredPane.MODAL_LAYER);
	        //  jp.add(label3,JLayeredPane.PALETTE_LAYER);
	          //instead of above you can write better as below
	          
	          jp.add(label1,Integer.valueOf(3));
		      jp.add(label2,Integer.valueOf(2));
		      jp.add(label3,Integer.valueOf(1));
	          jp.repaint();
	            }
	        });
	label2.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	         // System.out.println("You clicked label2");
	          jp.remove(label1);
	          jp.remove(label2);
	          jp.remove(label3);
	          
	          jp.add(label1,Integer.valueOf(1));
	          jp.add(label2,Integer.valueOf(2));
	          jp.add(label3,Integer.valueOf(0));
	          jp.repaint();
	            }
	        });
	
	label3.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	          System.out.println("You clicked label3");
	          jp.remove(label1);
	          jp.remove(label2);
	          jp.remove(label3);
	          
	          jp.add(label1,Integer.valueOf(0));
		      jp.add(label2,Integer.valueOf(1));
		      jp.add(label3,Integer.valueOf(2));
	          jp.repaint();
	            }
	        });
	}
    
} // end of class