package proj.dz.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import proj.dz.dao.AnnonceDaoLocal;
import proj.dz.model.Annonce;

@ApplicationPath("/services") // pour donner le motif d’URI géré par JAX-RS :
@Path("/ajout_annonce") // le chemin d'acces au service
public class Ajout_annonce extends Application 
{
	SimpleDateFormat form_jav = new SimpleDateFormat("dd/MM/yyyy");
	@EJB
	private AnnonceDaoLocal annoncDao;
	
	@Context
    private HttpServletResponse response;
	
	@Path("/ajout_annonce") //indique le chemin d’URI qui identifie la ressource
	@Produces(MediaType.APPLICATION_JSON) //format de retour de données
	@Consumes(MediaType.APPLICATION_JSON)
	
	@GET// c la méthode qui doit être appelée pour traiter la méthode de la requête HTTP entrante 
	public String ajout_annonce(@QueryParam("w_d") int w_d, @QueryParam("w_a") int w_a, @QueryParam("date") String date, @QueryParam("heure") String heure, @QueryParam("fumeur") String fumeur, @QueryParam("musique") String musique, @QueryParam("com") String com, @QueryParam("bag") String bag, @QueryParam("voiture") String voiture, @QueryParam("tarif") int tarif , @QueryParam("place") byte place, @QueryParam("user") int user)
	{						
		Date dat =null;	
		try 
		{
			 dat = form_jav.parse(date);
			 dat.setHours(1);
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}		
	
		Annonce annonce=new Annonce();

		annonce.setNumLoD(w_d);
		annonce.setNumLoA(w_a);
		annonce.setDateD(dat);
		annonce.setHeureD(heure);
		annonce.setFumeur(fumeur);
		annonce.setMusic(musique);
		annonce.setCommentaire(com);
		annonce.setTypeBag(bag);
		annonce.setModelVoiture(voiture);
		annonce.setTarif(tarif);
		annonce.setNbrPPro(place);
		annonce.setNumAc(user);
		
		annonce.setDeuxPlacesAr("o");
		annonce.setDateAn(new Date());
		annonce.setEtat((byte) 0);
		annonce.setMinuteD("00");
		annonce.setNbrPRes(place);
		
		annoncDao.save(annonce);		
				
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "OPTIONS, GET, POST, PUT, DELETE");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		response.setCharacterEncoding("ISO8859-1");		
		
		return"eeeeeeeeeeeeee";
	}
}
