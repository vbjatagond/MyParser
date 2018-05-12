package com.myparser.util;

import com.myparser.model.XMLNode;
/**
 * Created By Vikas B Jatagond
 * Helper class to Marshal processed node to XML Tags
 */
public class NodeMarshaller
{
	// TODO: Marshall empty body Tag as <Tag/> instead of <Tag></Tag>
	public static String createOpenTag(XMLNode node)
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(getIntention(node));
		stringBuilder.append("<" + node.getTagName());

		if (node.getId() != null)
		{
			stringBuilder.append(" id=\"" + node.getId() + "\"");
		}
		if (node.getValue() != null)
		{
			stringBuilder.append(" value=\"" + node.getValue() + "\"");
		}

		stringBuilder.append(">\n");
		return stringBuilder.toString();
	}

	public static String createCloseTag(XMLNode node)
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(getIntention(node));
		stringBuilder.append("</" + node.getTagName() + ">\n");
		return stringBuilder.toString();
	}

	public static String createChildTag(XMLNode node)
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(getIntention(node));
		stringBuilder.append("<" + node.getTagName() + ">");
		if (node.getValue() != null)
		{
			stringBuilder.append(node.getValue());
		}
		stringBuilder.append("</" + node.getTagName() + ">\n");
		return stringBuilder.toString();
	}

	private static String getIntention(XMLNode node)
	{
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < node.getTaglevel() + 1; i++)
		{
			stringBuilder.append("\t");
		}
		return stringBuilder.toString();
	}
}
