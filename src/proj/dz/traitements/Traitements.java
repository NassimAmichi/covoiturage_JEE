package proj.dz.traitements;

import java.text.SimpleDateFormat;

public class Traitements 
{
	public SimpleDateFormat form_jv=new SimpleDateFormat("dd-MM-yyyy");
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	public String NomJour(int j) 
	{
		String jour = "Samedi";
		switch (j) {
		case 0:
			jour = "Dimanche";
			break;
		case 1:
			jour = "Lundi";
			break;
		case 2:
			jour = "Mardi";
			break;

		case 3:
			jour = "Mercredi";
			break;
		case 4:
			jour = "Jeudi";
			break;
		case 5:
			jour = "Vendredi";
			break;
		case 6:
			jour = "Samedi";
			break;
		}
		return jour;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////
	

}
