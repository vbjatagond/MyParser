package com.myparser;

import com.myparser.parser.ParserImplTest;
import com.myparser.util.InputFileReaderTest;
import com.myparser.util.NodeMarshallerTest;
import com.myparser.util.OutputFileWriterTest;
import com.myparser.util.XMLBuilderTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created By Vikas B Jatagond
 */

@RunWith(Suite.class)
@Suite.SuiteClasses(
		{
				InputFileReaderTest.class,
				NodeMarshallerTest.class,
				OutputFileWriterTest.class,
				XMLBuilderTest.class,

				ParserImplTest.class
		}
)

public class AppTest
{
}
