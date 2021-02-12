package com.fat.access;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.fat.repository.access;

@Repository
public class accessRepositoryimpl {

	   @PersistenceContext
	    private EntityManager entityManager;
	   
	   
	   public List<access> findAllWorkersSInce30days()
	   {
		   return entityManager.createQuery("select fat.cards_name_surname_nrhacosoft.nazwisko_imie\r\n" + 
		   		"									from fat.access\r\n" + 
		   		"									left join fat.cards_name_surname_nrhacosoft \r\n" + 
		   		"									on fat.access.id_karty = fat.cards_name_surname_nrhacosoft.id_karty\r\n" + 
		   		"									where fat.cards_name_surname_nrhacosoft.nazwisko_imie like '%%'\r\n" + 
		   		"									and fat.access.data between  DATE_ADD(now(), INTERVAL -30 day) and now()\r\n" + 
		   		"									and fat.cards_name_surname_nrhacosoft.nazwisko_imie not like '%GOSC%'\r\n" + 
		   		"									group by fat.access.id_karty\r\n" + 
		   		"									order by fat.cards_name_surname_nrhacosoft.nazwisko_imie asc",access.class).getResultList();
	   }
	   
	   
	   public List<access> tescik()
	   {
		   return entityManager.createQuery("select c from access c", access.class).setMaxResults(10).getResultList();
	   }
}
