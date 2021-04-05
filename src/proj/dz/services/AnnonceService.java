package proj.dz.services;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import proj.dz.dao.VAnnonceDaoLocal;
import proj.dz.model.VAnnonce;
import proj.dz.traitements.Traitements;

@ApplicationPath("/services")// le chemin d'accès aux services Web RESTful.
@Path("/annonces")//indiquant que l'URL doit être utilisée par les clients pour invoquer la méthode:
@Produces("text/plain")
public class AnnonceService extends Application 
{
	Traitements tr=new Traitements();
	SimpleDateFormat form_jav = new SimpleDateFormat("dd/MM/yyyy");
	
	private SimpleDateFormat form_ang=new SimpleDateFormat("dd-MM-yyyy");
	
	@EJB
	private VAnnonceDaoLocal annDao;
	
	@Context
    private HttpServletResponse response;
	
	@Context
	private HttpServletRequest requete;
	
	@Path("/annonces")// l'URL à laquelle la ressource répond.
	@Produces(MediaType.APPLICATION_JSON) //format de retour de données
	@GET// la méthode annotée répond aux requêtes HTTP GET
	
	public List<VAnnonce>   getAnnonces(@QueryParam("w_d") int w_d, @QueryParam("w_a") int w_a,  @QueryParam("date_d") String date_d, @QueryParam("date_f") String date_f)
	{
		response.setHeader("Access-Control-Allow-Origin", "*"); // ou bien	
		//response.addHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "OPTIONS, GET, POST, PUT, DELETE");
		response.setCharacterEncoding("ISO8859-1");	
		
		List<VAnnonce> liste_annonces=new ArrayList<VAnnonce>();
		
		Date dat_d =null;	
		Date dat_f =null;
		java.sql.Date date_sql_d=null;
		java.sql.Date date_sql_f=null;
			
		if(w_d==-1) // tous afficher
		{
			liste_annonces= annDao.findAll();
		}
		else
		{
			if((date_d.equals(""))||(date_f.equals("")))
			{
				liste_annonces= annDao.findAllByWilayas(w_d,w_a); 
			}
			else
			{
				try 
				{
					 dat_d = form_jav.parse(date_d);
					 dat_d.setHours(1);
					 
					 dat_f = form_jav.parse(date_f);
					 dat_f.setHours(1);
				} 
				catch (ParseException e) 
				{
					e.printStackTrace();
				}
				date_sql_d = new java.sql.Date(dat_d.getTime());
				date_sql_f = new java.sql.Date(dat_f.getTime());
				liste_annonces= annDao.findByWilayasDate(w_d,w_a, date_sql_d,date_sql_f); 
			}
		}		
		
		for(int i = 0 ; i < liste_annonces.size(); i++)
		{
			liste_annonces.get(i).setDateDep("Le "+tr.NomJour(liste_annonces.get(i).getDateAn().getDay())+" "+form_ang.format(liste_annonces.get(i).getDateD()));
			liste_annonces.get(i).setDateAnn(form_ang.format(liste_annonces.get(i).getDateAn()));
		}
		
		return  liste_annonces;
	}	
}
