package proj.dz.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="v_annonces")

@NamedQueries(
{
	@NamedQuery(name="VAnnonce.findAll", query="SELECT A FROM VAnnonce A"),
	@NamedQuery(name="VAnnonce.findAllByWilayas", query="SELECT A FROM VAnnonce A WHERE A.numLocDe=:w_d AND A.numLocAr=:w_a"),
	
	@NamedQuery(name="VAnnonce.findByWilayasDate", query="SELECT A FROM VAnnonce A WHERE A.numLocDe=:w_d AND A.numLocAr=:w_a AND A.dateD between :date_d and :date_f")

	//@NamedQuery(name="VAnnonce.findByWilayasDate", query="SELECT A FROM VAnnonce A WHERE A.numLocDe=:w_d AND A.numLocAr=:w_a AND A.dateD=:date")
})

public class VAnnonce implements Serializable 
{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="num_ann")
	private int numAnn;
	
	private int age;

	private String annonceur;

	private String bag;

	private String comm;

	@Temporal(TemporalType.DATE)
	@Column(name="date_an")
	private Date dateAn;

	@Temporal(TemporalType.DATE)
	@Column(name="date_d")
	private Date dateD;

	private String fummeur;

	@Column(name="heure_d")
	private String heureD;

	@Column(name="loc_ar")
	private String locAr;

	@Column(name="loc_de")
	private String locDe;

	private String music;

	@Column(name="plac_lib")
	private int placLib;

	@Column(name="plac_tot")
	private byte placTot;

	
	private int tarif;
	
	private String sex;

	private String tel;

	private String vehicule;
	
	@Column(name="num_loc_ar")
	private int numLocAr;

	@Column(name="num_loc_de")
	private int numLocDe;
	
	public VAnnonce() 
	{
	}	

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAnnonceur() {
		return this.annonceur;
	}

	public void setAnnonceur(String annonceur) {
		this.annonceur = annonceur;
	}

	public String getBag() {
		return this.bag;
	}

	public void setBag(String bag) {
		this.bag = bag;
	}

	public String getComm() {
		return this.comm;
	}

	public void setComm(String comm) {
		this.comm = comm;
	}

	public Date getDateAn() {
		return this.dateAn;
	}

	public void setDateAn(Date dateAn) {
		this.dateAn = dateAn;
	}

	public Date getDateD() {
		return this.dateD;
	}

	public void setDateD(Date dateD) {
		this.dateD = dateD;
	}
	
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getFummeur() {
		return this.fummeur;
	}

	public void setFummeur(String fummeur) {
		this.fummeur = fummeur;
	}

	public String getHeureD() {
		return this.heureD;
	}

	public void setHeureD(String heureD) {
		this.heureD = heureD;
	}

	public String getLocAr() {
		return this.locAr;
	}

	public void setLocAr(String locAr) {
		this.locAr = locAr;
	}

	public String getLocDe() {
		return this.locDe;
	}

	public void setLocDe(String locDe) {
		this.locDe = locDe;
	}

	public String getMusic() {
		return this.music;
	}

	public void setMusic(String music) {
		this.music = music;
	}

	public int getNumAn() {
		return this.numAnn;
	}

	public void setNumAn(int numAn) {
		this.numAnn = numAn;
	}

	public int getPlacLib() {
		return this.placLib;
	}

	public void setPlacLib(int placLib) {
		this.placLib = placLib;
	}

	public byte getPlacTot() {
		return this.placTot;
	}

	public void setPlacTot(byte placTot) {
		this.placTot = placTot;
	}

	public int getTarif() {
		return this.tarif;
	}

	public void setTarif(int tarif) {
		this.tarif = tarif;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getVehicule() {
		return this.vehicule;
	}

	public void setVehicule(String vehicule) {
		this.vehicule = vehicule;
	}
	
	public int getNumLocAr() {
		return this.numLocAr;
	}

	public void setNumLocAr(int numLocAr) {
		this.numLocAr = numLocAr;
	}

	public int getNumLocDe() {
		return this.numLocDe;
	}

	public void setNumLocDe(int numLocDe) {
		this.numLocDe = numLocDe;
	}
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	@Transient 
	private String dateDep;
	
	@Transient
	private String dateAnn;
	
	public String getDateDep() {
		return this.dateDep;
	}

	public void setDateDep(String dateDep) {
		this.dateDep = dateDep;
	}
	
	public String getDateAnn() {
		return this.dateAnn;
	}

	public void setDateAnn(String dateAnn) {
		this.dateAnn = dateAnn;
	}
	
}