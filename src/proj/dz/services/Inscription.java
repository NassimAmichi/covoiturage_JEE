package proj.dz.services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
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
import proj.dz.dao.AnnonceurDaoLocal;
import proj.dz.dao.VilleDaoLocal;
import proj.dz.model.Annonceur;

@ApplicationPath("/services") // pour donner le motif d’URI géré par JAX-RS :
@Path("/inscription") // le chemin d'acces au service
public class Inscription extends Application 
{	
	int num_v;
	
	@EJB
	private VilleDaoLocal villDao;
	
	@EJB
	private AnnonceurDaoLocal annoncDao;
	
	@Context
    private HttpServletResponse response;
	
	@Path("/inscription") //indique le chemin d’URI qui identifie la ressource
	@Produces(MediaType.APPLICATION_JSON) //format de retour de données
	@GET// c la méthode qui doit être appelée pour traiter la méthode de la requête HTTP entrante 
	
	public String inscription(@QueryParam("nom") String nom, @QueryParam("tel") String tel, @QueryParam("passe") String passe, @QueryParam("sex") String sex, @QueryParam("ville") String ville )
	{
		String tél="not_exist";
		if(annoncDao.exist_tel(tel))
		{
			tél="exist";
			System.out.println("exiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiist");
		}
		else
		{
			num_v= villDao.findIdVille(ville); 
			
			if(sex.equals("Femme")){sex="F";}else{sex="H";}
			
			Annonceur annonceur=new Annonceur();
			annonceur.setNom(nom);
			annonceur.setTel(tel);
			annonceur.setPasse(get_SHA_512_SecurePassword(passe,"tt"));
			annonceur.setSex(sex);
			annonceur.setNumLo(num_v);
			annonceur.setDateIn((new Date()));		
			annoncDao.save(annonceur);	
		}				
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "OPTIONS, GET, POST, PUT, DELETE");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		response.setCharacterEncoding("ISO8859-1");
		return tél;					
	}
	//
	public String get_SHA_512_SecurePassword(String passwordToHash, String salt)
	{
	    String generatedPassword = null;
	    try 
	    {
	        MessageDigest md = MessageDigest.getInstance("SHA-512");
	        md.update(salt.getBytes(StandardCharsets.UTF_8));
	        byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
	        StringBuilder sb = new StringBuilder();
	        for(int i=0; i< bytes.length ;i++)
	        {
	            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        generatedPassword = sb.toString();
	    } 
	    catch (NoSuchAlgorithmException e) 
	    {
	        e.printStackTrace();
	    }
	    return generatedPassword;
	}
	//
}
