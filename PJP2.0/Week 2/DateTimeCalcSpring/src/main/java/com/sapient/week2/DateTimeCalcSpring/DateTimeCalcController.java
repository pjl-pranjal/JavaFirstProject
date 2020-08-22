package com.sapient.week2.DateTimeCalcSpring;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateTimeCalcController {
	
	@Autowired
	private Adder adder;
	
	@Autowired
	private Subtractor subtractor;
	
	@Autowired
	private NaturalLangEngine nlEngine;
	
//	NL PHRASES
//	{
//	    "phrase" : "3 days earlier"
//	}
	
	@PostMapping(
		value = "/nl", consumes = "application/json", produces = "application/json")
	public String computeNLPhrase(@RequestBody Map<String, String> data) {
		String result = "";
		try {
			this.nlEngine.computeFromNLPhrase(data.get("phrase"));
			result = this.nlEngine.result.toString();
			
		} catch (Exception e) {
			return this.handleError(e);
		}
		
		System.out.println(result);
		return this.asJson(result);
	}
	
//	ADD & SUBTRACT (union of all fields needed by both)
//	{
//    "type" : "duration",
//    "day" : "3",
//    "month" : "1",
//    "year" : "2020",
//    "day1" : "5",
//    "month1" : "1",
//    "year1" : "2020",
//    "unitType" : "1",
//    "valueToAdd" : "2",
//	  "valueToSubtract" : "2"
//  }
	
	@PostMapping(
		value = "/add", consumes = "application/json", produces = "application/json")
	public String add(@RequestBody Map<String, String> data) {
		String result = "";
		
		try {
			CustomDate date = new CustomDate(
					Integer.parseInt(data.get("day")),
					Integer.parseInt(data.get("month")),
					Integer.parseInt(data.get("year"))
				);

			result = this.adder.addByUnit(
					date,
					Integer.parseInt(data.get("valueToAdd")),
					Integer.parseInt(data.get("unitType"))
				).toString();
		} catch (Exception e) {
			return this.handleError(e);
		}
		
		System.out.println(result);
		return this.asJson(result);
	}
	
	@PostMapping(
		value = "/subtract", consumes = "application/json", produces = "application/json")
	public String subtract(@RequestBody Map<String, String> data) {
		String result = "";
		
		try {
			CustomDate date = new CustomDate(
					Integer.parseInt(data.get("day")),
					Integer.parseInt(data.get("month")),
					Integer.parseInt(data.get("year"))
				);

			if (data.get("type").equals("duration")) {
				CustomDate date1 = new CustomDate(
						Integer.parseInt(data.get("day1")),
						Integer.parseInt(data.get("month1")),
						Integer.parseInt(data.get("year1"))
					);
				result = this.subtractor.subtractDate(date, date1).toString();
			}
			else {
				result = this.subtractor.subtractByUnit(
						date,
						Integer.parseInt(data.get("valueToSubtract")),
						Integer.parseInt(data.get("unitType"))
					).toString();
			}
		} catch (Exception e) {
			return this.handleError(e);
		} 
		
		System.out.println(result);
		return this.asJson(result);
	}
	
	private String handleError(Exception e) {
		String error = "Exception! " + e;
		System.out.println(error);
		return error;
	}
	
	// Ensuring a standard json string is returned by all methods
	private String asJson(String result) {
		return "{ result: " + result + " }";
	}
}
