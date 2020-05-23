import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RemoteException;


public class AdditionClient {
	
	private JFrame frame;
	private int niv;
	private int bud;
	private int qual;
	private int pay;
	private String restaurant = "";
	private String to_save = "";

	
	AdditionInterface hello;
	
	public static void main (String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdditionClient window = new AdditionClient();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public AdditionClient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() { 
		//AdditionInterface hello;
        try {
	    	hello = (AdditionInterface)Naming.lookup("rmi://127.0.0.1:15000/ABC");
			frame = new JFrame();
			frame.setBounds(100, 100, 596, 415);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPanel panel = new JPanel();
			frame.getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel Bonjour = new JLabel("Bonjour");
			Bonjour.setBounds(18, 18, 365, 14);
			panel.add(Bonjour);
			
			JLabel Meteo = new JLabel(hello.informations()[0]+"\r\n");
			Meteo.setBounds(220, 317, 400, 14);
			panel.add(Meteo);
			
			JLabel Tarif = new JLabel(hello.informations()[1]+"\r\n");
			Tarif.setBounds(220, 343, 400, 14);
			panel.add(Tarif);
			
			JLabel Horaires = new JLabel(hello.informations()[2]+"\r\n");
			Horaires.setBounds(220, 369, 400, 14);
			panel.add(Horaires);
			
			JLabel label = new JLabel(hello.informations()[3]+"\r\n");
			label.setBounds(380, 18, 180, 14);
			panel.add(label);
			/////////////etat de l'utilisateur/////////////
			JButton niv_1 = new JButton("tres fatigue");
			niv_1.setBounds(18, 55, 180, 40);
			panel.add(niv_1);
			niv_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						setNiv(1);
						hello.niveaux(1);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			JButton niv_2 = new JButton("fatigue");
			niv_2.setBounds(200, 55, 180, 40);
			panel.add(niv_2);
			niv_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						setNiv(2);
						hello.niveaux(2);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			JButton niv_3 = new JButton("pas fatigue");
			niv_3.setBounds(380, 55, 180, 40);
			panel.add(niv_3);
			niv_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						setNiv(3);
						hello.niveaux(3);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			/////////////qualite du produit/////////////
			JButton qual_1 = new JButton("mediocre");
			qual_1.setBounds(18, 125, 135, 40);
			panel.add(qual_1);
			qual_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						setQual(1);
						hello.qualite(1);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			
			JButton qual_2 = new JButton("moyenne");
			qual_2.setBounds(154, 125, 135, 40);
			panel.add(qual_2);
			qual_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						setQual(2);
						hello.qualite(2);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			JButton qual_3 = new JButton("bonne");
			qual_3.setBounds(290, 125, 135, 40);
			panel.add(qual_3);
			qual_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						setQual(3);
						hello.qualite(3);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			JButton qual_4 = new JButton("tres bonne");
			qual_4.setBounds(425, 125, 135, 40);
			panel.add(qual_4);
			qual_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						setQual(4);
						hello.qualite(4);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			/////////////origin du produit/////////////
			JButton pay_1 = new JButton("local");
			pay_1.setBounds(18, 195, 270, 40);
			panel.add(pay_1);
			pay_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						setPay(1);
						hello.pays(1);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			JButton pay_2 = new JButton("ce n'est pas important");
			pay_2.setBounds(290, 195, 270, 40);
			panel.add(pay_2);
			pay_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						setPay(2);
						hello.pays(2);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			SpinnerModel value =  new SpinnerNumberModel(5, 5, 300, 5);
			JSpinner spinner = new JSpinner(value);
			spinner.setBounds(18, 265, 180, 30);
			panel.add(spinner);
			
			JLabel proposition = new JLabel(getRestaurant());
			proposition.setBounds(250, 265, 300, 23);
			panel.add(proposition);
			
			JButton btnConfirmer = new JButton("confirmer");
			btnConfirmer.setBounds(6, 340, 89, 23);
			panel.add(btnConfirmer);
			btnConfirmer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						setBud((Integer) spinner.getValue());
						setRestaurant(hello.propose(getNiv(), getBud(), getQual(), getPay()));
						String[] fullTime = hello.informations()[3].split(":");
						int hour = Integer.parseInt(fullTime[0]);
						
						if(hour > 22 || hour < 8) {
							proposition.setText("Desole le parc est ferme");
						}else if(hello.draham()) {
							proposition.setText("votre budget total est insuffisant");
						}else {
							proposition.setText("Je propose cette boutique : " + getRestaurant());
							setTo_save(hello.confirmer(getNiv(), getBud(), getQual(), getPay()));
						}	
							
						
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			
			
			
        }catch (Exception err) {
        	System.out.println("HelloClient exception: " + err);
        }
	}
	public int getNiv() {
		return niv;
	}
	public void setNiv(int niv) {
		this.niv = niv;
	}
	public int getBud() {
		return bud;
	}
	public void setBud(int bud) {
		this.bud = bud;
	}
	public int getQual() {
		return qual;
	}
	public void setQual(int qual) {
		this.qual = qual;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public String getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}
	public String getTo_save() {
		return to_save;
	}
	public void setTo_save(String to_save) {
		this.to_save = to_save;
	}
}
