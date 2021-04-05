package proj.dz.services;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import proj.dz.dao.MessageDaoLocal;
import proj.dz.model.Message;

@ApplicationPath("/nasnas") // pour donner le motif d’URI géré par JAX-RS :
@Path("/message") // le chemin d'acces au service
public class MessageService extends Application 
{	
	
	@EJB
	private MessageDaoLocal messDao;
	
	@Context
    private HttpServletResponse response;
	
	@Path("/list") //indique le chemin d’URI qui identifie la ressource
	@Produces(MediaType.APPLICATION_JSON) //format de retour de données

	@GET// c la méthode qui doit être appelée pour traiter la méthode de la requête HTTP entrante 
	
	public String getMessage()
	{
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "OPTIONS, GET, POST, PUT, DELETE");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		response.setCharacterEncoding("ISO8859-1");	

		List<Message> liste_messages=new ArrayList<Message>();
		liste_messages=messDao.findByText(1); 

		System.out.println(liste_messages.get(0).getContenu());
		return liste_messages.get(0).getContenu();
	}
}
