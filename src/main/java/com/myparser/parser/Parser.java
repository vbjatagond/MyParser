package com.myparser.parser;

/**
 * Created by Vikas B Jatagond
 * Interface to parse data file to xml file
 */

// TODO : Many other Parsers can implement this interface according to their need

public interface Parser
{
	public String parse(String inputFilePath); 
	
}