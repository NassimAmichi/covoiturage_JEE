package proj.dz.services;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import proj.dz.dao.VilleDaoLocal;
import proj.dz.model.Ville;

@ApplicationPath("/services") // pour donner le motif d’URI géré par JAX-RS :
@Path("/villes/") // le chemin d'acces au service

public class VilleService extends Application 
{	
	@EJB
	private VilleDaoLocal villDao;
	
	@Context
    private HttpServletResponse response;
	
	@Path("/villes") 
	@Produces(MediaType.APPLICATION_JSON) 
	@GET
	
	public List<Ville>   getVilles(@QueryParam("wilaya") String wilaya)
	{		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "OPTIONS, GET, POST, PUT, DELETE");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		response.setCharacterEncoding("ISO8859-1");	
		
		List<Ville> liste_villes=new ArrayList<Ville>();
		
		liste_villes= villDao.findByNomWilaya(wilaya); 
		
		return  liste_villes;
	}	
}
