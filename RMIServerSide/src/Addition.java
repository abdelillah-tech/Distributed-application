import java.rmi.*;

import java.rmi.server.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Addition extends UnicastRemoteObject implements AdditionInterface{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int niv;
	private int bud;
	private int qual;
	private int pay;
	private int dra;
	
	public int getDra() {
		return dra;
	}

	public void setDra(int dra) {
		this.dra = dra;
	}

	public Addition () throws RemoteException {
		this.niv = 3;
		this.bud = 5;
		this.qual = 2;
		this.pay = 1;
	};
	
	public Addition (int niv, int bud, int qual, int pay) throws RemoteException {
		this.niv = niv;
		this.bud = bud;
		this.qual = qual;
		this.pay = pay;
	}
	
	public 	String[] informations() {
		setDra(300);
		String meteo = "";
		String[] info = new String[4];
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now(); 
		String time = dtf.format(now).split("\\s")[1].split("\\.")[0];
		
		int k = new Random().nextInt(4);
		switch(k) {
		case 0 :
			meteo = "il fait beau";
			break;
		case 1 :
			meteo = "il pleut";
			break;
		case 2 :
			meteo = "il neige";
			break;
		case 3 :
			meteo = "il fait mauvais";
			break;
		case 4 :
			meteo = "il ya des nuages";
			break;
		}
		info[0] = meteo;
		info[1] = "les tarifs :\n enfant : 10e , adulte : 20e";
		info[2] = "le parc ouvre ces porte tout les jours de 08h00 a 22h00";
		info[3] = time;
		
		return info;
	}
	
    
    public void niveaux(int n) {
    	
    	switch(n) {
    		case 1 :
    			System.out.println("tres fatigue");
    			this.setNiv(1);
    			break;
    		case 2 :
    			System.out.println("fatigue");
    			this.setNiv(2);
    			break;
    		case 3 :
    			System.out.println("pas fatigue");
    			this.setNiv(3);
    			break;
    		default :
    			this.setNiv(3);
    	}
    }
    
    public void budget(int bud) {
    	this.setBud(bud); 
    }
    
    public void qualite(int n) {
    	switch(n) {
    		case 1 :
    			System.out.println("mediocre");
    			this.setQual(1);
    			break;
    		case 2 :
    			System.out.println("moyenne");
    			this.setQual(2);
    			break;
    		case 3 :
    			System.out.println("bonne");
    			this.setQual(3);
    			break;
    		case 4 :
    			System.out.println("tres bonne");
    			this.setQual(4);
    			break;
    		default :
    			System.out.println("moyenne");
    			this.setQual(2);
    	}
    }
    
    public void pays(int n) {
    	switch(n) {
    		case 1 :
    			System.out.println("locale");
    			this.setPay(1);
    			break;
    		case 2 :
    			System.out.println("ce n'est pas important");
    			this.setPay(2);
    			break;
    		default :
    			System.out.println("ce n'est pas important");
    			this.setPay(2);
    	}
    }	
    public Boolean draham() {
    	int pri = getDra();
    	pri = pri - getBud();
    	if(pri > 0) {
    		setDra(pri);
    		return false;
    	}else
    		return true;
    }
    
    public String propose(int niv, int bud, int qual, int pay) {
    	String store = "";
    	if(bud < 50 && bud >= 5)
    		store = "keepItSimple";
    	if(bud < 100 && bud >= 50) {
    		if(niv == 1) {
    			store = "souvenirsDeReve";
    		}
    		if(niv == 2) {
    			if(qual <= 2) {
    				store = "keepItSimple";
    			}
    			if(qual > 2) {
    				store = "souvenirsDeReve";
    			}
    		}
    		if(niv == 3) {
    			store = "CouCouMonParc";
    		}
    	}
    	if(bud >= 100) {
    		if(niv == 1) {
    			store = "LuxMemories";
    		}
    		if(niv == 2) {
    			store = "souvenirsDeReve";
    		}
    		if(niv == 3) {
    			if(pay == 1) {
    				store = "CristalWood";
    			}
    			if(pay == 2) {
    				store = "FromTheWorld";
    			}
    		}
    	}
    	System.out.println(store);
    	return store;
    }
    
    public String confirmer(int niv, int bud, int qual, int pay) {
    	this.niv = niv;
		this.bud = bud;
		this.qual = qual;
		this.pay = pay;
       	return Integer.toString(getNiv())+","+Integer.toString(getBud())+","+Integer.toString(getQual())+","+Integer.toString(getPay());
    }
    
    public String connec(boolean e) {
    	if(e == true)
    		return "Desole notre service n'est pas disponible pour le moment";
    	else 
    		return "Bonjour";
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
}
