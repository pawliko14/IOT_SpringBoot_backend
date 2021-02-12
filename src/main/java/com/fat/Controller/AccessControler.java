
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
//@CrossOrigin(origins = "http://192.168.90.199:3000")  // <- for production purpose, on tests not necessary
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

	//////////////////////////////////////////////////////////////////
	/*
	*** Plc Variables
	 */


	@GetMapping("/plc_variables/{id}")
	public object_variables get_plc_variables_ID(@PathVariable("id") String id) throws SQLException {
		return obj.get_SingleVariable_from_Specific_table(id,"plcvariables_data");
	}

	@GetMapping("/plc_variables")
	public List<object_variables> StateOfPLC_variables() throws SQLException {
		return obj.get_PLC_variables();
	}

	// not implemented YET!
	@GetMapping("/plc_variables_historical/{records}")
	public List<object_historical> get_historical_last_10(@PathVariable("records") String records) throws SQLException {
		return obj.getHostoricalVar_last_10(records,"plcvariables_historical");
	}
	//////////////////////////////////////////////////////////////////

	//testing
	@GetMapping("/gethistorical")
	public List<object_historical> getHistoricalMB5() throws SQLException {
		return obj.getHistorical_MB5();
	}

	@GetMapping("/getToolsData")
	public List<object_variables> getToolsData() throws SQLException {
		return obj.get_toolsData();
	}

	@GetMapping("/tools_data/{id}")
	public object_variables get_tools_data_ID(@PathVariable("id") String id) throws SQLException {
		return obj.get_SingleVariable_from_Specific_table(id,"tools_data");
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
