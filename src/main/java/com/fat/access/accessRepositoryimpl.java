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

}
