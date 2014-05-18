package com.au.util;

import java.util.regex.Pattern;

public class ValidateUtil {
	
	private static Pattern p = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
	
	public static boolean isValidString(String s) {
		boolean x = true;		
	    if(s == null) {
	    	x = false;
	    }else{
		    if(p.matcher(s).matches()) x = false;
		    if(s.isEmpty()) x = false;	
	    }	    	    	    
	    return x;
	}
}
