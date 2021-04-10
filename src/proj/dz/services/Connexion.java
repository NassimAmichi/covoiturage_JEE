package proj.dz.services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import proj.dz.dao.AnnonceurDaoLocal;

@ApplicationPath("/services")
@Path("/connexion")
public class Connexion  extends Application 
{
	int num_user3;
	@EJB
	private AnnonceurDaoLocal annonceurDao;
	@Context
    private HttpServletResponse response;
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	@Path("/connexion_get") 
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public int connexion_get(@QueryParam("nom") String nom, @QueryParam("passe") String passe)
	{		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "OPTIONS, GET, POST, PUT, DELETE");
		response.setHeader("'text/plain; charset=utf-8'", "Content-Type");
		response.setCharacterEncoding("ISO8859-1");	
		num_user3= annonceurDao.connexion(nom,get_SHA_512_SecurePassword(passe,"tt")); 
		return num_user3;
	}
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	@Path("/connexion_post") 
	@POST
	@Produces(MediaType.TEXT_PLAIN) // ca marche même avec APPLICATION_JSON
	@Consumes(MediaType.TEXT_PLAIN) // ca marche pas avec APPLICATION_JSON
	public int connexion_post(String  account)
	{			
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		final String separator = " ";
        String passwords_user[] = account.split(separator);
 
        num_user3= annonceurDao.connexion(passwords_user[0],get_SHA_512_SecurePassword(passwords_user[1],"tt")); 
        
        System.out.println("connnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn_poste nouvelle");
        
		return 	num_user3;
	}
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public String get_SHA_512_SecurePassword(String passwordToHash, String salt){
	    String generatedPassword = null;
	    try {
	        MessageDigest md = MessageDigest.getInstance("SHA-512");
	        md.update(salt.getBytes(StandardCharsets.UTF_8));
	        byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
	        StringBuilder sb = new StringBuilder();
	        for(int i=0; i< bytes.length ;i++){
	            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        generatedPassword = sb.toString();
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    }
	    return generatedPassword;
	}
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
}
