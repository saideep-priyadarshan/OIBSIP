import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Number_Guess_Game extends JFrame {
	 JTextField textfield1, textfield2,textfield3;
	    JLabel jLabel; 
	    GuessButton guessButton;
	    RetryButton retryButton;    
	    static int random=(int) (Math.random()*100); 
	    int count=0;
	    public Number_Guess_Game()
	    { 
	        Container c = getContentPane();
	        c.setLayout(null);   
	        c.setBackground(Color.BLACK); 
	        JLabel labelpic = new JLabel("");
	        JLabel j=new JLabel("Guess The Number");
	        j.setForeground(Color.WHITE);
	        j.setFont(new Font("Courier",Font.BOLD,22));
	        j.setSize(370,35);
	        j.setLocation(115,35); 
	        JLabel j1=new JLabel("Hint: Number is between 1-100");
            j1.setForeground(Color.WHITE);
	        j1.setFont(new Font("tunga",Font.PLAIN,17));
	        j1.setSize(270,20);
	        j1.setLocation(102,80);
	        textfield1=new JTextField(10);
	        textfield1.setSize(50,30);
	        textfield1.setLocation(279,125);       
	        jLabel=new JLabel(" ");
	        jLabel.setFont(new Font("tunga",Font. ITALIC,16));
	        jLabel.setSize(370,20);
	        jLabel.setLocation(94,165);
	        textfield2=new JTextField(20);
	        textfield2.setSize(30,20);
	        textfield2.setLocation(171,260);
	        JLabel j2=new JLabel("Attempts used");
            j2.setForeground(Color.WHITE);
	        j2.setFont(new Font("tunga",Font.BOLD,12));
	        j2.setSize(270,20);
	        j2.setLocation(81,260);
	        JLabel j3=new JLabel("Enter your Guess: ");
            j3.setForeground(Color.WHITE);
	        j3.setFont(new Font("tunga",Font.BOLD,13));
	        j3.setSize(340,20);
	        j3.setLocation(104,130);
            JLabel j4=new JLabel("(Max Attempts: 8)");
            j4.setForeground(Color.WHITE);
            j4.setFont(new Font("tunga",Font.BOLD,12));
	        j4.setSize(270,20);
	        j4.setLocation(265,260);
	        JButton b1=new JButton("Guess");
	        b1.setSize(80,30);
	        b1.setLocation(119,200);
	        guessButton=new GuessButton();        
	        b1.addActionListener(guessButton);     
	        JButton b2=new JButton("Retry");    
	        b2.setSize(80,30);
	        b2.setLocation(240,200);    
	        retryButton=new RetryButton();        
	        b2.addActionListener(retryButton);    
	        c.add(jLabel);    
	        c.add(labelpic);
	        c.add(j);    
	        c.add(j1);
	        c.add(j3);
	        c.add(textfield1);
	        c.add(textfield2);
            c.add(j4);
	        c.add(b1);    
	        c.add(b2);        
	        c.add(j2);     
	        textfield2.setEditable(false);    
	        setTitle("Number Guessing Game by Saideep");        
	        setSize(450,550);
	        setVisible(true);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	    }

	    private class GuessButton implements ActionListener
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	            int a = Integer.parseInt(textfield1.getText());
	            count=count+1;
	            if(count>8)
	            {
	            	jLabel.setText("Attempts Exceeded!!!, Click on Retry");  
	                jLabel.setForeground(Color.MAGENTA);
	                count=0;
	            }
	            else {
	            if(a<random)
	            {
	                jLabel.setText("Wrong Guess!! "+a+" is Lower, Try Again");
	                jLabel.setForeground(Color.red);
	            }    
	            else if(a>random)
	            {
	                jLabel.setText("Wrong Guess!! "+a+" is Higher, Try Again");
	                jLabel.setForeground(Color.red);
	            }
	            else
	            {
	                jLabel.setText("Guess is Correct, You Win!!!!");  
	                jLabel.setForeground(Color.green);
	            }
	            textfield1.requestFocus();
	            textfield1.selectAll();

	            textfield2.setText(count+"");
	            }
	        }
	    }

	    private class RetryButton implements ActionListener
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	            random=(int) (Math.random()*100);
	            textfield1.setText("");
	            textfield2.setText("");
	            jLabel.setText("Try Again and Guess the Number");
	            jLabel.setForeground(Color.black);
	            textfield2.setText("");
	            count=0;
	            textfield1.setEditable(true);    
	            textfield1.requestFocus();
	        }
	    }

	    public static void main(String[] args) {

	    	new Number_Guess_Game();
	    	}	
}