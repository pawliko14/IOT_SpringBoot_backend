
package com.fat.Controller;

import com.fat.SentronEntities.Modbus_data;
import com.fat.SentronEntities.Modbus_historical;
import com.fat.SentronServices.Modbus_HistoricalService;
import com.fat.SentronServices.Modbus_dataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fat.sqlEnquiry.SqlEnquiry;
import com.fat.sqlObjects.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api/v1", method = RequestMethod.GET)
public class AccessControler {

//	private SqlEnquiry obj = new SqlEnquiry();

	@Autowired
	private Modbus_dataService modbus_dataService;

	@Autowired
	private Modbus_HistoricalService modbus_historicalService;

		// temporary commented
//	@GetMapping("/{xxx_data}/{id}")
//	public object_variables get_plc_variables_ID(@PathVariable("xxx_data") String table,@PathVariable("id") String id) throws SQLException {
//		return obj.get_SingleVariable_from_Specific_table(id,table);
//	}
//
//	@GetMapping("/{xxx_data}")
//	public List<object_variables> StateOfPLC_variables(@PathVariable("xxx_data") String tableName) throws SQLException {
//		return obj.get_PLC_variables(tableName);
//	}
//
//
//	@GetMapping("/{xxx_historical}/{records}/{variable}")
//	public List<object_historical> get_historical_last_10(@PathVariable("xxx_historical") String table,@PathVariable("records") int records, @PathVariable("variable") String variable) throws SQLException {
//		return obj.getHistoricalValue_basedOnRowLimit(records,table,  variable);
//	}
//
//	@GetMapping("/{xxx_historical}/timeperoid/{timeperoid}/{variable}")
//	public List<object_historical> get_historial_data_word_based_days(@PathVariable("xxx_historical") String table, @PathVariable("timeperoid") String timeperoid, @PathVariable("variable") String variable) throws SQLException {
//		return obj.getHistoricalVal_basedOnWord(timeperoid,table,  variable);
//	}
//
//
//	@GetMapping("/{xxx_historical}/modulo_record/{timeporoid}/{modulo_record}/{variable}")
//	public List<object_historical> get_historicaldata_based_on_ID_modulo(@PathVariable("xxx_historical") String table, @PathVariable("modulo_record") int modulo_record, @PathVariable("variable") String variable, @PathVariable("timeporoid") String timeporoid) throws SQLException {
//		return obj.getHistoricalValues_based_on_ID_Module(modulo_record ,table,  variable,timeporoid);
//	}

	/////////////////////////////////////////// SENTRON ////////////////////////////////////////////////

	@GetMapping("/modbus_data")
	public @ResponseBody List<Modbus_data> getAllData() {
		return  modbus_dataService.getAll();
	}


	@GetMapping("/modbus_data/{id}")
	public @ResponseBody
	Optional<Modbus_data> get_modbus_dataByIndex_2(@PathVariable("id") long index) {
		return  modbus_dataService.getElementAtIndex(index);
	}

	////////////////////////// SENTRON HISTORICAL/////////////////////////////////


	// working properely
	@GetMapping("/modbus_data_historical_2/timeperoid/{timeperoid}/{variable}")
	public List<Modbus_historical> get_historialModbus_data_word_based_days_2(@PathVariable("timeperoid") String timeperoid, @PathVariable("variable") String variable) throws SQLException {
		return modbus_historicalService.getHistoricalValues_basedOnTimePeroid(timeperoid, variable);
	}


		// working properely
	@GetMapping("/modbus_data_historical/{records}/{variableName}")
	public List<Modbus_historical> get_historialModbus_data_word_based_onLimit_2(@PathVariable("records") int records, @PathVariable("variableName") String variableName) throws SQLException {
		return modbus_historicalService.getHistoricalValue_basedOnRowLimit(records,variableName);
	}


}


