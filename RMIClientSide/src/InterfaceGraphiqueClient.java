import java.awt.*;
import java.awt.event.*;
import java.rmi.Naming;

import javax.swing.*;

public class InterfaceGraphiqueClient {
	Box panel1;
	JPanel panel2;
	
	public InterfaceGraphiqueClient(final JFrame frame){
        //Build the first login panel
        panel1 = Box.createVerticalBox();
        panel1.setBackground(Color.orange);
        panel1.setOpaque(true);
        panel1.add(Box.createVerticalGlue());
        //panel1.add(new JTextField(10));
        //panel1.add(jlabel);
        JButton login = new JButton("Login");
        login.addActionListener(new ActionListener(){
        
        public void actionPerformed(ActionEvent arg0) {
			frame.setContentPane(getPanel2());
	        frame.validate();
        }});
        
        AdditionInterface hello;
        try {
			hello = (AdditionInterface)Naming.lookup("rmi://127.0.0.1:16000/ABC");
			String[] info = hello.informations();
		    JLabel jlabel = new JLabel(info[0]);
		    jlabel.setFont(new Font("Verdana",1,20));
		    JLabel jlabel1 = new JLabel(info[1]);
		    jlabel1.setFont(new Font("Verdana",1,20));
		    JLabel jlabel2 = new JLabel(info[2]);
		    jlabel2.setFont(new Font("Verdana",1,20));
		    panel1.add(jlabel);
		    panel1.add(jlabel1);
		    panel1.add(jlabel2);
		    JTextField t1 = new JTextField("enter your name");  
		    //t1.setBounds(50,50, 200,30);  
		    JTextField t2 = new JTextField("enter your age");  
		    //t2.setBounds(50,150, 200,30);  
		    JTextField t3 = new JTextField("enter your budget");
		    panel1.add(t1);
		    panel1.add(t2);
		    panel1.add(t3);
        }catch (Exception err) {
        	System.out.println("HelloClient exception: " + err);
        }
        
        panel1.add(login);
        panel1.add(Box.createVerticalGlue());
        
      //Build second panel
        panel2 = new JPanel();
        panel2.setBackground(Color.blue);
        panel2.setOpaque(true);
        JButton logout = new JButton("Logout");
        logout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
					frame.setContentPane(getPanel1());
	                frame.validate();
        }});
        panel2.add(logout, BorderLayout.CENTER);
    }
	

    public Container getPanel1(){
        return panel1;
    }
    public Container getPanel2(){
        return panel2;
    }
}
