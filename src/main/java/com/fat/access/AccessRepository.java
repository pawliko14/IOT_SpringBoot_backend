package com.fat.access;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fat.repository.access;


@Repository
public interface AccessRepository extends JpaRepository<access, Long>{
	

	
}
