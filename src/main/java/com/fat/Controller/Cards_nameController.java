package com.fat.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fat.access.Cards_nameRepository;
import com.fat.access.cards_nameRepositoryImpl;
import com.fat.repository.cards_name_surname_nrhacosoft;

import java.util.List;


@RestController
public class Cards_nameController {

	@Autowired
	Cards_nameRepository cards_nameRepository;
	@Autowired
	cards_nameRepositoryImpl impl;
	
	public Cards_nameController (Cards_nameRepository repo,cards_nameRepositoryImpl i)
	{
		cards_nameRepository = repo;
		impl = i;
	}
	
	@GetMapping("tescik2")
	public List<cards_name_surname_nrhacosoft> tescik()
	{
		return impl.findFirst10Workers();
	}
	
	@GetMapping("tescik22")
	public List<String> tescik2()
	{
		return impl.tesingPurposeNotUsedInApplication();
	}
	
	
	
}
