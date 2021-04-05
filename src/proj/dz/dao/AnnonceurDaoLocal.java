package proj.dz.dao;
import javax.ejb.Local;
import proj.dz.model.Annonceur;

@Local
public interface AnnonceurDaoLocal extends Dao<Annonceur,Integer> 
{
	public int connexion(String user, String Passe);
	public boolean exist_tel(String tel);
}
