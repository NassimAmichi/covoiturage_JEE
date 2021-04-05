package proj.dz.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQueries({
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m"),
@NamedQuery(name="Message.findByText", query="SELECT m FROM Message m WHERE m.numMe=:param")})

public class Message implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="num_me")
	private int numMe;

	private String contenu;

	public Message() {
	}

	public int getNumMe() {
		return this.numMe;
	}

	public void setNumMe(int numMe) {
		this.numMe = numMe;
	}

	public String getContenu() {
		return this.contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

}