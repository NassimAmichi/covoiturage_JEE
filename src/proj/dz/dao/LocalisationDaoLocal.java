package proj.dz.dao;

import java.util.List;
import javax.ejb.Local;
import proj.dz.model.Localisation;

@Local
public interface LocalisationDaoLocal extends Dao<Localisation,Integer>
{
	public List<String> findWilayas();

}
