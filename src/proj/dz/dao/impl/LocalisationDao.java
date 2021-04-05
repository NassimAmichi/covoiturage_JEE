package proj.dz.dao.impl;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import proj.dz.dao.AbstractDao;
import proj.dz.dao.LocalisationDaoLocal;
import proj.dz.model.Localisation;

@Stateless
public class LocalisationDao extends AbstractDao<Localisation, Integer> implements LocalisationDaoLocal
{
	public LocalisationDao() 
	{
		super(Localisation.class);
	}

	@Override
	public List<String> findWilayas() 
	{
		TypedQuery<String>q=(TypedQuery<String>) em.createNamedQuery("Localisation.findWilayas");  

		
		return (q.getResultList());
	}
}
