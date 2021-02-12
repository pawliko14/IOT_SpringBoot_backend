
package com.fat.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fat.access.AccessRepository;
import com.fat.access.accessRepositoryimpl;

import sqlEnquiry.SqlEnquiry;
import sqlObjects.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins = "http://192.168.90.66:3000")  // <- for production purpose, on tests not necessary
@RestController
public class AccessControler {
	@Autowired
	AccessRepository accessRepository;
	@Autowired
	accessRepositoryimpl impl;
	
	private SqlEnquiry obj = new SqlEnquiry();
	
	public AccessControler (AccessRepository repo,accessRepositoryimpl i)
	{
		accessRepository = repo;
		impl = i;
	}
	
	
	@GetMapping("/access")
	public long getALlAccess()
	{
		return accessRepository.count();
	}
	

	@GetMapping("/test")
	public String returnTest()
	{
		return "Alive";
	}

	@GetMapping("/plc_variables")
	public List<object_variables> StateOfPLC_variables() throws SQLException {
		return obj.get_PLC_variables();
	}

	//testing
	@GetMapping("/gethistorical")
	public List<object_historical> getHistoricalMB5() throws SQLException {
		return obj.getHistorical_MB5();
	}

	@GetMapping("/getToolsData")
	public List<object_variables> getToolsData() throws SQLException {
		return obj.get_toolsData();
	}

	@GetMapping("/getprogramdata")
	public List<object_variables> get_programData() throws SQLException {
		return obj.get_programData();
	}

	@GetMapping("/getprogramdata/{id}")
	public object_variables get_programData_ID(@PathVariable("id") String id) throws SQLException {
		return obj.get_programData_id(id);
	}

}
