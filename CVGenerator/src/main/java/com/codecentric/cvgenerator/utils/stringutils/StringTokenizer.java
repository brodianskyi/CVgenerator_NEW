package com.codecentric.cvgenerator.utils.stringutils;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StringTokenizer {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final char CommaToken = ',';
    
  
    public HashMap<Integer, String> getCommaValues(String str) {
	
	HashMap<Integer, String> map = new HashMap<Integer, String>();
	if (str.indexOf(CommaToken) > 0){
		String result = "";
		int count = 0;
		do{
		   count++;
		   result = str.substring(0, str.indexOf(CommaToken));
		   str = str.substring(str.indexOf(CommaToken)+1)+CommaToken;
		   map.put(count, result);
		}while (str.indexOf(CommaToken)> 0);
		   for (Map.Entry<Integer, String> entry : map.entrySet()) {
		      logger.info("Vlue of my map in method" + entry.getKey()+" : "+entry.getValue());
		    }
	 } else map.put(1, str);
   	   
	  return  map;
    }
  }	
