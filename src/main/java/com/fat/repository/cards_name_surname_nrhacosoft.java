package com.fat.repository;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@Entity
@Table(name="cards_name_surname_nrhacosoft")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class cards_name_surname_nrhacosoft implements Serializable{

	@Id
	private long id_karty;
	
	@Column(nullable = true)
	private String nazwisko_imie;

	@Column(name="HacoSoftnumber",nullable = true)
	private double HacoSoftnumber;
	
	@Column(nullable = true)
	private String stanowisko;
	
	@Column(nullable = true)
	private String firma;

	
	
	public long getId_karty() {
		return id_karty;
	}

	public void setId_karty(long id_karty) {
		this.id_karty = id_karty;
	}

	public String getNazwisko_imie() {
		return nazwisko_imie;
	}

	public void setNazwisko_imie(String nazwisko_imie) {
		this.nazwisko_imie = nazwisko_imie;
	}

	public double getHacoSoftnumber() {
		return HacoSoftnumber;
	}

	public void setHacoSoftnumber(int hacoSoftnumber) {
		HacoSoftnumber = hacoSoftnumber;
	}

	public String getStanowisko() {
		return stanowisko;
	}

	public void setStanowisko(String stanowisko) {
		this.stanowisko = stanowisko;
	}

	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}
	
	
	
	
}
