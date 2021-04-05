package proj.dz.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries
({
	@NamedQuery(name="Annonceur.findAll", query="SELECT A FROM Annonceur A"),
	@NamedQuery(name="Annonceur.findUser",query="SELECT A.numAn FROM Annonceur A WHERE A.nom=:param1 and A.passe=:param2"),
	@NamedQuery(name="Annonceur.verif_tel",query="SELECT A.tel FROM Annonceur A WHERE A.tel=:tel")
})


public class Annonceur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="num_an")
	private int numAn;

	@Column(name="adr_mail")
	private String adrMail;

	@Column(name="annee_ne")
	private int anneeNe;

	@Column(name="code_ge")
	private String codeGe;

	@Temporal(TemporalType.DATE)
	@Column(name="date_in")
	private Date dateIn;

	private byte etat;

	private String nom;

	@Column(name="num_lo")
	private int numLo;

	private String passe;

	private String sex;

	private int signale ;

	private String tel;

	public Annonceur() {
	}

	public int getNumAn() {
		return this.numAn;
	}

	public void setNumAn(int numAn) {
		this.numAn = numAn;
	}

	public String getAdrMail() {
		return this.adrMail;
	}

	public void setAdrMail(String adrMail) {
		this.adrMail = adrMail;
	}

	public int getAnneeNe() {
		return this.anneeNe;
	}

	public void setAnneeNe(int anneeNe) {
		this.anneeNe = anneeNe;
	}

	public String getCodeGe() {
		return this.codeGe;
	}

	public void setCodeGe(String codeGe) {
		this.codeGe = codeGe;
	}

	public Date getDateIn() {
		return this.dateIn;
	}

	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}
	public byte getEtat() {
		return this.etat;
	}

	public void setEtat(byte etat) {
		this.etat = etat;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNumLo() {
		return this.numLo;
	}

	public void setNumLo(int numLo) {
		this.numLo = numLo;
	}

	public String getPasse() {
		return this.passe;
	}

	public void setPasse(String passe) {
		this.passe = passe;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getSignale() {
		return this.signale;
	}

	public void setSignale(int signale) {
		this.signale = signale;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}