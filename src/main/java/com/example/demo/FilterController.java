package com.example.demo;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterController {

	/*
	 * Dynamic filter
	 * @JsonFilter should be there over model class
	 */
	@GetMapping(path="/filterEx")
	public MappingJacksonValue getfilteredValue()
	{
		FilterModel fm = new FilterModel(1, "asas", "sfvsdv");
		MappingJacksonValue m = new MappingJacksonValue(fm);
		
		SimpleBeanPropertyFilter spBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("password");
		FilterProvider fp = new SimpleFilterProvider().addFilter("FilterModel", spBeanPropertyFilter);
		m.setFilters(fp);
		return m;
	}
	
	@GetMapping(path="/filterstatic")
	public FilterModel getstaticfilteredValue()
	{
		FilterModel fm = new FilterModel(1, "asas", "sfvsdv");
		return fm;
	}
}
