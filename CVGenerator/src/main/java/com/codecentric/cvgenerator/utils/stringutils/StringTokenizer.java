package com.codecentric.cvgenerator.utils.stringutils;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StringTokenizer {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private String CommaTocken = "";
    
    public HashMap<Integer, String> getCommaValues(String str,String tocken) {
    	    
    	    CommaTocken = tocken;
    	   
    	 return getCommaValues(str);
    }
   
   public String getRightdate(String str,String tocken){
    	CommaTocken = tocken;
    	String buf = "";
    	HashMap<Integer, String> right_date_map = getCommaValues(str);
    	  for(int j = right_date_map.size() ; j > 0 ; j--){
    		 buf += right_date_map.get(j) + "." ;
    	  }
    	buf = buf.substring(0,buf.length()-1);
    
     return buf;
    }
    
   
    
  
    private HashMap<Integer, String> getCommaValues(String str) {
	
	HashMap<Integer, String> map = new HashMap<Integer, String>();
	if (str.indexOf(CommaTocken) > 0){
		String result = "";
		int count = 0;
		do{
		   count++;
		   result = str.substring(0, str.indexOf(CommaTocken));
		   str = str.substring(str.indexOf(CommaTocken)+1)+CommaTocken;
		      if ( result.substring(0,1).equals(",")){
			     result =  result.substring(1); 
			    }
		   map.put(count, result);
		}while (str.indexOf(CommaTocken)> 0);
		   for (Map.Entry<Integer, String> entry : map.entrySet()) {
		      logger.info("Value of my map in method" + entry.getKey()+" : "+entry.getValue());
		    }
	 } else map.put(1, str);
   	   
	  return  map;
    }
  }	
