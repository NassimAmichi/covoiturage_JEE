package proj.dz.dao;
import java.util.List;

import javax.ejb.Local;
import proj.dz.model.Ville;

@Local
public interface VilleDaoLocal extends Dao<Ville,Integer> 
{

	List<Ville> findByNomWilaya(String wilaya);
	int findIdVille(String param);

}
