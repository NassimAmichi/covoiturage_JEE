package proj.dz.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQuery(name="Annonce.findAll", query="SELECT a FROM Annonce a")
public class Annonce implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="num_an")
	private int numAn;

	private String commentaire;

	@Temporal(TemporalType.DATE)
	@Column(name="date_an")
	private Date dateAn;

	@Temporal(TemporalType.DATE)
	@Column(name="date_d")
	private Date dateD;

	@Column(name="deux_places_ar")
	private String deuxPlacesAr;

	private byte etat;

	private String fumeur;

	@Column(name="heure_d")
	private String heureD;

	@Column(name="minute_d")
	private String minuteD;

	@Column(name="model_voiture")
	private String modelVoiture;

	private String music;

	@Column(name="nbr_p_pro")
	private byte nbrPPro;

	@Column(name="nbr_p_res")
	private byte nbrPRes;

	@Column(name="num_ac")
	private int numAc;

	@Column(name="num_lo_a")
	private int numLoA;

	@Column(name="num_lo_d")
	private int numLoD;

	private int tarif;

	@Column(name="type_bag")
	private String typeBag;

	public Annonce() {
	}

	public int getNumAn() {
		return this.numAn;
	}

	public void setNumAn(int numAn) {
		this.numAn = numAn;
	}

	public String getCommentaire() {
		return this.commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
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

	public String getDeuxPlacesAr() {
		return this.deuxPlacesAr;
	}

	public void setDeuxPlacesAr(String deuxPlacesAr) {
		this.deuxPlacesAr = deuxPlacesAr;
	}

	public byte getEtat() {
		return this.etat;
	}

	public void setEtat(byte etat) {
		this.etat = etat;
	}

	public String getFumeur() {
		return this.fumeur;
	}

	public void setFumeur(String fumeur) {
		this.fumeur = fumeur;
	}

	public String getHeureD() {
		return this.heureD;
	}

	public void setHeureD(String heureD) {
		this.heureD = heureD;
	}

	public String getMinuteD() {
		return this.minuteD;
	}

	public void setMinuteD(String minuteD) {
		this.minuteD = minuteD;
	}

	public String getModelVoiture() {
		return this.modelVoiture;
	}

	public void setModelVoiture(String modelVoiture) {
		this.modelVoiture = modelVoiture;
	}

	public String getMusic() {
		return this.music;
	}

	public void setMusic(String music) {
		this.music = music;
	}

	public byte getNbrPPro() {
		return this.nbrPPro;
	}

	public void setNbrPPro(byte nbrPPro) {
		this.nbrPPro = nbrPPro;
	}

	public byte getNbrPRes() {
		return this.nbrPRes;
	}

	public void setNbrPRes(byte nbrPRes) {
		this.nbrPRes = nbrPRes;
	}

	public int getNumAc() {
		return this.numAc;
	}

	public void setNumAc(int numAc) {
		this.numAc = numAc;
	}

	public int getNumLoA() {
		return this.numLoA;
	}

	public void setNumLoA(int numLoA) {
		this.numLoA = numLoA;
	}

	public int getNumLoD() {
		return this.numLoD;
	}

	public void setNumLoD(int numLoD) {
		this.numLoD = numLoD;
	}

	public int getTarif() {
		return this.tarif;
	}

	public void setTarif(int tarif) {
		this.tarif = tarif;
	}

	public String getTypeBag() {
		return this.typeBag;
	}

	public void setTypeBag(String typeBag) {
		this.typeBag = typeBag;
	}

}