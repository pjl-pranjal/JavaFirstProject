package com.sapient.week7;

import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class EmpMap {
	 
    private Map<Integer, Employee> map;

	public Map<Integer, Employee> getMap() {
		return map;
	}
	
	public void setMap(Map<Integer, Employee> map) {
		this.map = map;
	}    
}
