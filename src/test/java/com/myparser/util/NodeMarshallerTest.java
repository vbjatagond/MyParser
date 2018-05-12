package com.myparser.util;

import com.myparser.constants.ParserConstant;
import com.myparser.model.XMLNode;
import com.myparser.util.NodeMarshaller;

import junit.framework.TestCase;

/**
 * Created By Vikas B Jatagond
 */
public class NodeMarshallerTest extends TestCase
{
	public void testCreateOpenTag() throws Exception
	{
		XMLNode node = new XMLNode();
		node.setTaglevel(ParserConstant.ROOT_NODE);
		node.setTagName("gedcom");
		assertEquals("<gedcom>\n", NodeMarshaller.createOpenTag(node));

		node = new XMLNode();
		node.setTaglevel(0);
		node.setId("@I1@");
		node.setTagName("indi");
		assertNotSame("<indi id=\"@I1@\">", NodeMarshaller.createOpenTag(node));
	}

	public void testCreateCloseTag() throws Exception
	{
		XMLNode node = new XMLNode();
		node.setTaglevel(ParserConstant.ROOT_NODE);
		node.setTagName("gedcom");
		assertEquals("</gedcom>\n", NodeMarshaller.createCloseTag(node));

		node = new XMLNode();
		node.setTaglevel(0);
		node.setId("@I1@");
		node.setTagName("indi");
		assertNotSame("</indi>", NodeMarshaller.createCloseTag(node));
	}

	public void testCreateChildTag() throws Exception
	{
		XMLNode node = new XMLNode();
		node.setTaglevel(2);
		node.setTagName("surn");
		node.setValue("Buck");
		assertEquals("\t\t\t<surn>Buck</surn>\n", NodeMarshaller.createChildTag(node));
		assertNotSame("<surn>Buck</surn>", NodeMarshaller.createChildTag(node));
	}
}
