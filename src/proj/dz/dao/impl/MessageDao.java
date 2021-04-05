package proj.dz.dao.impl;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import proj.dz.dao.AbstractDao;
import proj.dz.dao.MessageDaoLocal;
import proj.dz.model.Message;


@Stateless
public class MessageDao extends AbstractDao<Message, Integer> implements MessageDaoLocal
{

	public MessageDao() 
	{
		super(Message.class);
	}

	public List<Message> findByText(int t) 
	{
		TypedQuery<Message>q=em.createNamedQuery("Message.findByText", getClazz());
		q.setParameter("param",t);
		q.setFirstResult(0);
		q.setMaxResults(50);
		return new ArrayList<Message>(q.getResultList()); // possible aussi getSingleResult()
	}
}