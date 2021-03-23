package com.javaspring.crud.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ogretimElemani")
public class OgretimElemani {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private long id;
	
	@Column(name = "AdSoyad")
	private String adSoyad;
	
	@Column(name = "email")
	private String email;
	
	
	


	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	@Column(name = "Fakulte")
	private String fakulte;
	
	@Column(name = "Bolum")
	private String bolum;
	
	@Column(name = "Sifre")
	private String sifre;
	
	private String token;
	
	private  String anabilimdali;
	
	private  String unvan;
	
	private  boolean isEnabled;


	public boolean getIsEnabled() {
		return isEnabled;
	}

	
	public OgretimElemani(long id, String adSoyad, String email, String fakulte, String bolum, String sifre,
			String token, String anabilimdali, String unvan, Boolean isEnabled) {
		super();
		this.id = id;
		this.adSoyad = adSoyad;
		this.email = email;
		this.fakulte = fakulte;
		this.bolum = bolum;
		this.sifre = sifre;
		this.token = token;
		this.anabilimdali = anabilimdali;
		this.unvan = unvan;
		this.isEnabled = isEnabled;
	}


	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getUnvan() {
		return unvan;
	}

	public void setUnvan(String unvan) {
		this.unvan = unvan;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getAdSoyad() {
		return adSoyad;
	}
	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFakulte() {
		return fakulte;
	}
	public void setFakulte(String fakulte) {
		this.fakulte = fakulte;
	}

	
	public String getBolum() {
		return bolum;
	}

	
	public void setBolum(String bolum) {
		this.bolum = bolum;
	}

	
	public String getSifre() {
		return sifre;
	}

	
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	
	public String getToken() {
		return token;
	}

	
	public void setToken(String token) {
		this.token = token;
	}

	public String getAnabilimdali() {
		return anabilimdali;
	}

	
	public void setAnabilimdali(String anabilimdali) {
		this.anabilimdali = anabilimdali;
	}


	public OgretimElemani() {
		super();
	}

	@Override
	public String toString() {
		return "OgretimElemani [id=" + id + ", adSoyad=" + adSoyad + ", email=" + email + ", fakulte=" + fakulte
				+ ", bolum=" + bolum + ", sifre=" + sifre + ", token=" + token + ", anabilimdali=" + anabilimdali
				+ ", unvan=" + unvan + ", isEnabled=" + isEnabled + "]";
	}
	
	
	
		
}
