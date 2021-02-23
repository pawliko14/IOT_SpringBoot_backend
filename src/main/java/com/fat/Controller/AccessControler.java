
package com.fat.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fat.access.AccessRepository;
import com.fat.access.accessRepositoryimpl;
import sqlEnquiry.SqlEnquiry;
import sqlObjects.*;
import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
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


	@GetMapping("/{xxx_data}/{id}")
	public object_variables get_plc_variables_ID(@PathVariable("xxx_data") String table,@PathVariable("id") String id) throws SQLException {
		return obj.get_SingleVariable_from_Specific_table(id,table);
	}

	@GetMapping("/{xxx_data}")
	public List<object_variables> StateOfPLC_variables(@PathVariable("xxx_data") String tableName) throws SQLException {
		return obj.get_PLC_variables(tableName);
	}


	@GetMapping("/{xxx_historical}/{records}/{variable}")
	public List<object_historical> get_historical_last_10(@PathVariable("xxx_historical") String table,@PathVariable("records") int records, @PathVariable("variable") String variable) throws SQLException {
		return obj.getHostoricalVar_last_10(records,table,  variable);
	}

	@GetMapping("/{xxx_historical}/timeperoid/{timeperoid}/{variable}")
	public List<object_historical> get_historial_data_word_based_days(@PathVariable("xxx_historical") String table, @PathVariable("timeperoid") String timeperoid, @PathVariable("variable") String variable) throws SQLException {
		return obj.getHostoricalVar_last_7_days(timeperoid,table,  variable);
	}


	@GetMapping("/{xxx_historical}/modulo_record/{timeporoid}/{modulo_record}/{variable}")
	public List<object_historical> get_historicaldata_based_on_ID_modulo(@PathVariable("xxx_historical") String table, @PathVariable("modulo_record") int modulo_record, @PathVariable("variable") String variable, @PathVariable("timeporoid") String timeporoid) throws SQLException {
		return obj.getHistoricalValues_based_on_ID_Module(modulo_record ,table,  variable,timeporoid);
	}


}
