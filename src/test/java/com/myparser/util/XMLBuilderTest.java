package com.myparser.util;

import java.util.ArrayList;
import java.util.List;

import com.myparser.constants.ParserConstant;
import com.myparser.model.XMLNode;
import com.myparser.util.XMLBuilder;

import junit.framework.TestCase;

/**
 * Created By Vikas B Jatagond
 */
public class XMLBuilderTest extends TestCase
{
	List<XMLNode> nodes = new ArrayList<XMLNode>();

	@Override
	public void setUp() throws Exception
	{
		super.setUp();

		XMLNode root = new XMLNode(ParserConstant.ROOT_NODE, "", "GEDCOM", "");
		XMLNode node0 = new XMLNode(0, "@I1@", "", "INDIA");
		XMLNode node1a = new XMLNode(1, "", "NAME", "Vikas B Jatagond");
		XMLNode node2a = new XMLNode(2, "", "SURNAME", "Jatagond");
		XMLNode node2b = new XMLNode(2, "", "GIVENAME", "Vikas");
		XMLNode node1b = new XMLNode(1, "", "SEX", "M");

		nodes.add(root);
		nodes.add(node0);
		nodes.add(node1a);
		nodes.add(node2a);
		nodes.add(node2b);
		nodes.add(node1b);
	}

	public void testCreate() throws Exception
	{
		XMLNode root = XMLBuilder.buildTree(nodes);

		assertEquals(true, root.isRootNode());
		assertEquals(1, root.getChildNodes().size());
		assertNotSame(1, root.getChildNodes().get(0).getChildNodes());
		assertNotSame("SURNAME", root.getChildNodes().get(0).getChildNodes().get(0));

	}
}
