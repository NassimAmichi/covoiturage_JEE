package proj.dz.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import proj.dz.dao.AbstractDao;
import proj.dz.dao.AnnonceurDaoLocal;
import proj.dz.model.Annonceur;

@Stateless
public class AnnonceurDao extends AbstractDao<Annonceur, Integer> implements AnnonceurDaoLocal
{
	public AnnonceurDao() 
	{
		super(Annonceur.class);
	}

	@Override
	public int connexion(String nom, String passe) 
	{
		TypedQuery<Integer>q=(TypedQuery<Integer>) em.createNamedQuery("Annonceur.findUser");
		q.setParameter("param1",nom);
		q.setParameter("param2",passe);
		
		if(q.getResultList().isEmpty())
		{
			return (-1);
		}
		else
		{		
			return (q.getSingleResult());
		}
	}
	
	@Override
	public boolean exist_tel(String tel) 
	{
		TypedQuery<Integer>q=(TypedQuery<Integer>) em.createNamedQuery("Annonceur.verif_tel");
		q.setParameter("tel",tel);
	
		
		if(q.getResultList().isEmpty())
		{
			return false;
		}
		else
		{		
			return true;
		}
	}
}
