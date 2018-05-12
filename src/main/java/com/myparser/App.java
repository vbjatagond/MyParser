package com.myparser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.myparser.parser.Parser;
import com.myparser.parser.ParserImpl;
/**
 * Parser problem Launch point
 * Created by : Vikas B Jatagond
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		System.out.println("Enter the absolute path of the input file : ");
		String inputFilePath, outputFilePath;
		try
		{
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			inputFilePath = bufferRead.readLine();
			
			// Create an object of Parser and invoke its parse() method which parses the given file
			Parser parser = new ParserImpl();
			outputFilePath = parser.parse(inputFilePath);
			
			System.out.print("Parsed Output file can be found in this location : " + outputFilePath);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
    }
}
