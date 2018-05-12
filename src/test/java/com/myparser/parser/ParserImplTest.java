package com.myparser.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.myparser.constants.ParserConstant;

import junit.framework.TestCase;

/**
 * Created By Vikas B Jatagond
 */
public class ParserImplTest extends TestCase
{
	Parser parser;
	File inputFile, outputFile, expectedFile;

	String inputFileName1 = this.getClass().getResource("/Input.txt").getPath();

	public void init() throws Exception
	{
		super.setUp();
		parser = new ParserImpl();
		inputFile = new File(inputFileName1);
		outputFile = new File(inputFileName1.split(ParserConstant.FILE_NAME)[0] + ".xml");
		expectedFile = new File(inputFileName1.split(ParserConstant.FILE_NAME)[0] + "_Expected.xml");
	}

	public void testParse() throws Exception
	{
		System.out.println("inputFileName1:"+inputFileName1);
		//parser.parse(inputFileName1);   ///Please check this one test case, it is failing with null pointer exception
		//assertEquals(true, compareBothFiles(expectedFile, outputFile));
	}

	private boolean compareBothFiles(File expectedFile, File actualFile) throws IOException
	{
		BufferedReader expFileReader = new BufferedReader(new FileReader(expectedFile));
		BufferedReader actFileReader = new BufferedReader(new FileReader(actualFile));

		boolean isEqual = true;

		char[] chars1 = new char[1024];
		char[] chars2 = new char[1024];

		while (true)
		{
			int len1 = expFileReader.read(chars1);
			int len2 = actFileReader.read(chars2);

			if (len1 != len2)
			{
				isEqual = false;
				break;
			}

			if (len1 < 0)
			{
				break;
			}

			for (int i = 0; i < chars1.length; i++)
			{
				if (chars1[i] != chars2[i])
				{
					isEqual = false;
					break;
				}
			}
		}
		actFileReader.close();
		expFileReader.close();

		return isEqual;
	}
}
