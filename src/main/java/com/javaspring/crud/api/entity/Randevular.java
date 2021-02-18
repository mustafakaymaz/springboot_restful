package com.javaspring.crud.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "randevular")
public class Randevular {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO )
		private long id;
		
		@Column(name = "AdSoyad")
		private String adSoyad;
		
		@Column(name = "email")
		private String email;
		
		
		public String getEmail() {
			return email;
		}
		
		public Randevular(String adSoyad, String email, String tarih, String saat) {
			super();
			this.adSoyad = adSoyad;
			this.email = email;
			this.tarih = tarih;
			this.saat = saat;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		@Column(name = "tarih")
		private String tarih;
		
		@Column(name = "saat")
		private String saat;
		
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
		public String getTarih() {
			return tarih;
		}
		public void setTarih(String tarih) {
			this.tarih = tarih;
		}
		public String getSaat() {
			return saat;
		}

		public void setSaat(String saat) {
			this.saat = saat;
		}
		
		@Override
		public String toString() {
			return "Randevular [id=" + id + ", adSoyad=" + adSoyad + ", email=" + email + ", tarih=" + tarih + ", saat="
					+ saat + "]";
		}

		public Randevular() {
			
		}
		
		
}
