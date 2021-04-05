package proj.dz.dao.impl;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import proj.dz.dao.AbstractDao;
import proj.dz.dao.VilleDaoLocal;
import proj.dz.model.Ville;

@Stateless
public class VilleDao extends AbstractDao<Ville, Integer> implements VilleDaoLocal
{
	public VilleDao() 
	{
		super(Ville.class);
	}
	
	@Override
	public List<Ville> findByNomWilaya(String wilaya) 
	{
		TypedQuery<Ville>q=em.createNamedQuery("Ville.findByNomWilaya", getClazz());
		q.setParameter("wilaya",wilaya);
		q.setFirstResult(0);
		q.setMaxResults(50);


		if(q.getResultList().isEmpty())
		{
			System.err.println("viiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiid");
		}
			
			
		return new ArrayList<>(q.getResultList()); 
	}
	
	@Override
	public int findIdVille(String nom_v) 
	{
		TypedQuery<Integer>q= (TypedQuery<Integer>) em.createNamedQuery("Ville.findIdVille");		
		q.setParameter("param",nom_v);
		return (q.getSingleResult()); 
	}
}
