package com.fat.repository;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.NonNull;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "access")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class access implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = true)
	private int id_karty;
	
	@Column(nullable = true)
	private String akcja;
	
	
	@Column(nullable = true)
	private Date data;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getId_karty() {
		return id_karty;
	}


	public void setId_karty(int id_karty) {
		this.id_karty = id_karty;
	}


	public String getAkcja() {
		return akcja;
	}


	public void setAkcja(String akcja) {
		this.akcja = akcja;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}
	
	
	

}
