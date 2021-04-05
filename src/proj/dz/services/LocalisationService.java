package proj.dz.services;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import proj.dz.dao.LocalisationDaoLocal;

@ApplicationPath("/services") // pour donner le motif d’URI géré par JAX-RS :
@Path("/localisation") // le chemin d'acces au service

public class LocalisationService extends Application 
{
	@EJB
	private LocalisationDaoLocal locDao;
	
	@Context
    private HttpServletResponse response;
	
	@Context
	private HttpServletRequest requete;
	
	@Path("/wilayas") 
	@Produces(MediaType.APPLICATION_JSON) //format de retour de données
	@GET// c la méthode qui doit être appelée pour traiter la méthode de la requête HTTP entrante 
	
	public List<String>   getWilayas()
	{
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "OPTIONS, GET, POST, PUT, DELETE");
		//response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		//response.setCharacterEncoding("ISO8859-1");	
		List<String> liste_wilayas=new ArrayList<String>();
		liste_wilayas= locDao.findWilayas(); 	
		return  liste_wilayas;
	}	
}
