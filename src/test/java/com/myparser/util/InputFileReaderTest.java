package com.myparser.util;

import java.util.List;

import com.myparser.util.InputFileReader;

import junit.framework.TestCase;
/**
 * Created By Vikas B Jatagond
 */
public class InputFileReaderTest extends TestCase
{
	InputFileReader inputFileReader;

	@Override
	public void setUp() throws Exception
	{
		super.setUp();
		inputFileReader = new InputFileReader();
	}

	public void testReadFileData() throws Exception
	{
		List<String> rawDataList = inputFileReader.readFile(this.getClass().getResource("/Input.txt").getPath());
		assertEquals("0 @I1@ INDIA", rawDataList.get(0));
		assertEquals("2 SURNAME Jatagond", rawDataList.get(2));
		assertNotSame("2 SURNAME Jatagond", rawDataList.get(3));

		try
		{
			rawDataList = inputFileReader.readFile(this.getClass().getResource("/noFile.txt").getPath());
		}
		catch (NullPointerException e)
		{
			assertTrue(true);
		}
	}
}
