package com.four;
import com.four.weapon.*;

import java.io.IOException;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Four1Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		int w1=0,w2=0;
		double d=0;
		int result = -1, order=0;
		int clazz1 = 0, clazz2 = 0;
		boolean pusto = false;
		String weaponName1 = null, weaponName2 = null;
		Knife knife1 = new Knife();
		Knife knife2 = new Knife();
		Pistol pistol1 = new Pistol();
		Pistol pistol2 = new Pistol();
		SubmachineGun submachineGun1 = new SubmachineGun();
		SubmachineGun submachineGun2 = new SubmachineGun();
		
		try {
			w1 = Integer.parseInt(req.getParameter("W1"));
			w2 = Integer.parseInt(req.getParameter("W2"));
			d = Double.parseDouble(req.getParameter("D"));
		} catch (NumberFormatException e) {
			pusto = true;
		}
		

		
		if (pusto) {
			resp.getWriter().print("Задайте корректные параметры!");
		} else {
			switch(w1){
			case 1:
				Knife fairbairnSykes = new Knife();
				fairbairnSykes.range = 1;
				fairbairnSykes.setName("Fairbairn-Sykes");
				knife1=fairbairnSykes;
				weaponName1=knife1.getName();
				clazz1=knife1.getClazz();
				break;
			case 2:
				Knife mNine = new Knife();
				mNine.range = 0.9;
				mNine.setName("M9");
				knife1=mNine;
				weaponName1=knife1.getName();
				clazz1=knife1.getClazz();
				break;
			case 3:
				Pistol desertEagle = new Pistol();
				desertEagle.setName("Desert Eagle");
				desertEagle.range = 70;
				desertEagle.rate = 25;
				pistol1=desertEagle;
				weaponName1=pistol1.getName();
				clazz1=pistol1.getClazz();
				break;
			case 4:
				Pistol glock = new Pistol();
				glock.setName("Glock-17");
				glock.range = 50;
				glock.rate = 17;
				pistol1=glock;
				weaponName1=pistol1.getName();
				clazz1=pistol1.getClazz();
				break;
			case 5:
				SubmachineGun mp = new SubmachineGun();
				mp.setName("MP40");
				mp.range = 76;
				mp.rate = 500;
				submachineGun1=mp;
				weaponName1=submachineGun1.getName();
				clazz1=submachineGun1.getClazz();
				break;
			case 6:
				SubmachineGun tommyGun = new SubmachineGun();
				tommyGun.setName("M1 Thompson");
				tommyGun.range = 200;
				tommyGun.rate = 700;
				submachineGun1=tommyGun;
				weaponName1=submachineGun1.getName();
				clazz1=submachineGun1.getClazz();
				break;				
			}
			switch(w2){
			case 1:
				Knife fairbairnSykes = new Knife();
				fairbairnSykes.range = 1;
				fairbairnSykes.setName("Fairbairn-Sykes");
				knife2=fairbairnSykes;
				weaponName2=knife2.getName();
				clazz2=knife2.getClazz();
				break;
			case 2:
				Knife mNine = new Knife();
				mNine.range = 0.9;
				mNine.setName("M9");
				knife2=mNine;
				weaponName2=knife2.getName();
				clazz2=knife2.getClazz();
				break;
			case 3:
				Pistol desertEagle = new Pistol();
				desertEagle.setName("Desert Eagle");
				desertEagle.range = 70;
				desertEagle.rate = 25;
				pistol2=desertEagle;
				weaponName2=pistol2.getName();
				clazz2=pistol2.getClazz();
				break;
			case 4:
				Pistol glock = new Pistol();
				glock.setName("Glock-17");
				glock.range = 50;
				glock.rate = 17;
				pistol2=glock;
				weaponName2=pistol2.getName();
				clazz2=pistol2.getClazz();
				break;
			case 5:
				SubmachineGun mp = new SubmachineGun();
				mp.setName("MP40");
				mp.range = 76;
				mp.rate = 500;
				submachineGun2=mp;
				weaponName2=submachineGun2.getName();
				clazz2=submachineGun2.getClazz();
				break;
			case 6:
				SubmachineGun tommyGun = new SubmachineGun();
				tommyGun.setName("M1 Thompson");
				tommyGun.range = 200;
				tommyGun.rate = 700;
				submachineGun2=tommyGun;
				weaponName2=submachineGun2.getName();
				clazz2=submachineGun2.getClazz();
				break;				
			}
			if (clazz1==1 && clazz2==1){
				result = fightKK(knife1,knife2,d);
				order = 0;}
			if (clazz1==2 && clazz2==2){
				result = fightPP(pistol1,pistol2,d);
				order = 0;}
			if (clazz1==3 && clazz2==3){
				result = fightSS(submachineGun1,submachineGun2,d);
				order = 0;}
			if (clazz1==1 && clazz2==2){
				result = fightKP(knife1,pistol2,d);
				order = 0;}
			if (clazz1==1 && clazz2==3){
				result = fightKS(knife1,submachineGun2,d);
				order = 0;}
			if (clazz1==2 && clazz2==3){
				result = fightPS(pistol1,submachineGun2,d);
				order = 0;}
			
			if (clazz1==3 && clazz2==2){
				result = fightPS(pistol2,submachineGun1,d);
				order = 1;}
			if (clazz1==3 && clazz2==1){
				result = fightKS(knife2,submachineGun1,d);
				order = 1;}
			if (clazz1==2 && clazz2==1){
				result = fightKP(knife2,pistol1,d);
				order = 1;}
			
			if(result==0){
				resp.getWriter().print("Both alive. Too far away from each other");
			}
			else if(result==1 && order==0){
				resp.getWriter().print("Person with " + weaponName1 + " killed person with " + weaponName2);
			}
			else if(result==2 && order==0){
				resp.getWriter().print("Person with " + weaponName2 + " killed person with " + weaponName1);					
			}
			else if(result==1 && order==1){
				resp.getWriter().print("Person with " + weaponName2 + " killed person with " + weaponName1);
			}
			else if(result==2 && order==1){
				resp.getWriter().print("Person with " + weaponName1 + " killed person with " + weaponName2);					
			}
			else if(result==3){
				resp.getWriter().print("They decided not to fight. They are equal.");
			}
			else {
				resp.getWriter().print("Nothing. Just nothing");
			}

		}	
	}

	
	
public static int fightKK(Knife k1, Knife k2, double r) {
	if ((r > k1.getRange()) && r > k2.getRange()) {
		return 0;
	} 
	else if (k1.getRange() > k2.getRange()) {
		return 1;
	}
	else if (k1.getRange() < k2.getRange()) {
		return 2;
	}
	else {
		return 3;
	}
	
}

public static int fightPP(Pistol p1, Pistol p2, double r) {
	if ((r > p1.getRange()) && r > p2.getRange()) {
		return 0;
	} else if (r > p2.getRange()) {
		return 1;
	} else if (r > p1.getRange()) {
		return 2;
	} else {
		if (p1.getRate() > p2.getRate()) {
			return 1;
		} else if (p1.getRate() < p2.getRate()) {
			return 2;
		} else {
			return 3;
		}
	}
}

public static int fightSS(SubmachineGun s1, SubmachineGun s2, double r) {
	if ((r > s1.getRange()) && r > s2.getRange()) {
		return 0;
	} else if (r > s2.getRange()) {
		return 1;
	} else if (r > s1.getRange()) {
		return 2;
	} else {
		if (s1.getRate() > s2.getRate()) {
			return 1;
		} else if (s1.getRate() < s2.getRate()) {
			return 2;
		} else {
			return 3;
		}
	}
}

public static int fightKP(Knife k, Pistol p, double r) {
	if ((r > p.getRange()) && r > k.getRange()) {
		return 0;
	} else {
		return 2;
	}
}

public static int fightKS(Knife k, SubmachineGun s, double r) {
	if ((r > s.getRange()) && r > k.getRange()) {
		return 0;
	} else {
		return 2;
	}
}

public static int fightPS(Pistol p, SubmachineGun s, double r) {
	if ((r > s.getRange()) && r > p.getRange()) {
		return 0;
	} else if (r <= p.getRange()) {
		return 1;
	} else {
		return 2;
	}

}
}
