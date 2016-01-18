package com.quiz.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectToJSON {
	public static String convertObjToJSON(Object obj) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return  mapper.writeValueAsString(obj);
	}	
}
