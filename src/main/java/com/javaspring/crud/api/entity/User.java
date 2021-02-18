package com.javaspring.crud.api.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private long id;
	
	@Column(name = "AdSoyad")
	private String adSoyad;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "Fakulte")
	private String fakulte;
	
	@Column(name = "Bolum")
	private String bolum;
	
	@Column(name = "Sifre")
	private String sifre;
	
	private String token;
	
	
	
	public String  getToken() {
		return token;
	}

	
	public void setToken( String token) {
		this.token = token;
	}


	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	public User() {
		
	}
	
	public User(String adSoyad, String lastName, String email,String fakulte, String bolum,String sifre, String token, LocalDateTime tokeDateTime) {
		super();
		this.adSoyad = adSoyad;
		this.email = email;
		this.fakulte = fakulte;
		this.bolum = bolum;
		this.bolum = sifre;
		this.token = token;
		
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

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", adSoyad=" + adSoyad + ", email=" + email + ", fakulte=" + fakulte + ", bolum="
				+ bolum + ", sifre=" + sifre + ", token=" + token + ", tokenCreationDate=" + "]";
	}
	
}
