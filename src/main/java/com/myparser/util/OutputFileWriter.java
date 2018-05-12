package com.myparser.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created By Vikas B Jatagond
 * Contains helper methods to write xml content into file
 */
public class OutputFileWriter
{
	/**
	 * Method for writing xml content into file
	 */
	public void writeFile(String filePath, String fileContent)
	{
		File outputFile = new File(filePath);
		BufferedWriter bw = null;
		try
		{
			if (!outputFile.exists())
			{
				outputFile.createNewFile();
			}
			bw = new BufferedWriter(new FileWriter(outputFile.getAbsoluteFile()));
			bw.write(fileContent);
		}
		catch (IOException e)
		{
			System.err.println("Unable to write file " + outputFile.getAbsoluteFile());
			e.printStackTrace();
		}
		catch (NullPointerException e)
		{
			System.err.println("File not found. Check file path " + outputFile.getAbsolutePath());
			e.printStackTrace();
		}
		finally
		{
			if (bw != null)
			{
				try
				{
					bw.close();
				}
				catch (IOException e)
				{
					System.err.println("Unable to close file " + outputFile.getAbsoluteFile());
					e.printStackTrace();
				}
			}
		}
	}
}
