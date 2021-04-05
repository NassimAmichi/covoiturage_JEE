package proj.dz.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity

@NamedQueries({
@NamedQuery(name="Localisation.findAll", query="SELECT l FROM Localisation l"),
@NamedQuery(name="Localisation.findWilayas", query="SELECT L.designation FROM Localisation L ORDER BY L.code")})


public class Localisation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="num_lo")
	private int numLo;

	private byte code;

	private String designation;

	@Column(name="num_lm")
	private int numLm;

	private byte rang;

	private byte type;

	public Localisation() {
	}

	public int getNumLo() {
		return this.numLo;
	}

	public void setNumLo(int numLo) {
		this.numLo = numLo;
	}

	public byte getCode() {
		return this.code;
	}

	public void setCode(byte code) {
		this.code = code;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getNumLm() {
		return this.numLm;
	}

	public void setNumLm(int numLm) {
		this.numLm = numLm;
	}

	public byte getRang() {
		return this.rang;
	}

	public void setRang(byte rang) {
		this.rang = rang;
	}

	public byte getType() {
		return this.type;
	}

	public void setType(byte type) {
		this.type = type;
	}

}