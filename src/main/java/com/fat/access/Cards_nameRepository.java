package com.fat.access;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fat.repository.cards_name_surname_nrhacosoft;

@Repository
public interface Cards_nameRepository extends JpaRepository<cards_name_surname_nrhacosoft, Long>{

}
