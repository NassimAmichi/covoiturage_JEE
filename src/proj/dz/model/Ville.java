package proj.dz.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity

@NamedQueries
({
	@NamedQuery(name="Ville.findAll", query="SELECT v FROM Ville v"),
	@NamedQuery(name="Ville.findByNomWilaya", query="SELECT V FROM Ville V, Localisation L WHERE V.numWi=L.numLo and L.designation=:wilaya"),
	@NamedQuery(name="Ville.findIdVille", query="SELECT V.numVi FROM Ville V WHERE V.designation=:param"),
})

public class Ville implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="num_vi")
	private int numVi;

	private String designation;

	@Column(name="num_wi")
	private int numWi;

	public Ville() {
	}

	public int getNumVi() {
		return this.numVi;
	}

	public void setNumVi(int numVi) {
		this.numVi = numVi;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getNumWi() {
		return this.numWi;
	}

	public void setNumWi(int numWi) {
		this.numWi = numWi;
	}

}