package com.au.util;

public class ConvertUtil {
	
	public static  int intConvert(String str){
		int conv = 0;		
	    if(str==null){
	    	str = "0";
	    }else 
	    if((str.trim()).equals("null")){
	    		str = "0";
	    }else 
	    	if(str.equals("")){
	        str="0";
	    }	    
	    try{
	        conv = Integer.parseInt(str);
	    }catch(NumberFormatException e){ }	     
	    return conv;
	}
}
