package proj.dz.dao;

import javax.ejb.Local;
import proj.dz.model.Annonce;

@Local
public interface AnnonceDaoLocal extends Dao<Annonce, Integer> 
{

}
