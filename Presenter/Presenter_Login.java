package Presenter;

import View.UtilizatoriInterfata;
import View.View_Administrator;
import View.View_Angajati;
import View.View_Manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


import Model.Utilizatori;
import Model.UtilizatoriRepository;

public class Presenter_Login {
public UtilizatoriInterfata my_view;
private UtilizatoriRepository utilizatoriRepository;

public Presenter_Login(UtilizatoriInterfata my_view)
{
	this.my_view=my_view;
	this.utilizatoriRepository= new UtilizatoriRepository();
}
public void actionLisenerLogin() {
				List<Utilizatori>  users= new ArrayList<Utilizatori>();
				users=utilizatoriRepository.findAll();
				int cnt = 0;
				for (Utilizatori user : users) {
		            if (user.getUsername().equals(my_view.getTitlu()) && user.getPassword().equals(my_view.getTitlu2()))
		            {
		            	cnt++;
		                System.out.println("S-a conectat");
		                if(user.getRole().equals("Angajat"))
		                {	
		                new View_Angajati(my_view.getTitlu());
		                break;
		                }
		                if(user.getRole().equals("Manager"))
		                {	
		                new View_Manager();
		                break;
		                }
		                if(user.getRole().equals("Administrator"))
		                {	
		                new View_Administrator();
		                break;
		                }
		            }
		        }
				if(cnt== 0)
				{
					System.out.println("Credentiale gresite");
				}
		}
}
