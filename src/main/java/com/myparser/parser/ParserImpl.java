package com.myparser.parser;

import java.util.ArrayList;
import java.util.List;

import com.myparser.constants.ParserConstant;
import com.myparser.model.XMLNode;
import com.myparser.util.InputFileReader;
import com.myparser.util.NodeMarshaller;
import com.myparser.util.OutputFileWriter;
import com.myparser.util.XMLBuilder;

/**
 * Created by Vikas B Jatagond
 * 
 * Similar to this, any other type of Parser can also implement Parser interface.
 */
public class ParserImpl implements Parser
{
	XMLNode root;
	InputFileReader fileReader = new InputFileReader();
	OutputFileWriter fileWriter = new OutputFileWriter();
    
	//Constructor to create and depict the Root Node
	public ParserImpl()
	{
		root = new XMLNode();
		root.setTaglevel(ParserConstant.ROOT_NODE);
		root.setTagName("xml");
	}
	
	// Method which does the actual Parsing
	public String parse(String inputFilePath)
	{   
		// 1. fileReader utility which reads the given file
		List<String> rawDataList = fileReader.readFile(inputFilePath);
		
		// 2. buildNodesFromData : Subroutine which Build <XMLNode> for the read data
		List<XMLNode> nodeList = buildNodesFromData(rawDataList);
		
		// 3. Constructing the Output file path and format
		String outputFilePath = inputFilePath.split(ParserConstant.FILE_NAME)[0] + ".xml";
		
		// 4. xmlMarshaller : Subroutine which structures and builds the XML for the list of <XMLNode> 
		String xmlContent = xmlMarshaller(nodeList);
		
		// 5. fileWriter utility which writes built XML content to outputFilePath file
		fileWriter.writeFile(outputFilePath, xmlContent);
		
		return outputFilePath;
	}
    
	
	private List<XMLNode> buildNodesFromData(List<String> lines)
	{
		List<XMLNode> nodes = new ArrayList<XMLNode>();
		nodes.add(root);
		
		//Iterate each line, split on white space delimiter and get the 3 tokens.
		for (String line : lines)
		{
			if (line != null && line.trim().compareTo("") != 0)
			{
				String[] tokens = line.split(ParserConstant.WHITE_SPACE_DELIMETER, 3);
				XMLNode node = new XMLNode();
				
				//First token is the level attribute
				node.setTaglevel(Integer.parseInt(tokens[0]));
				
				//Second token forms the attribute section
				if (tokens[1].startsWith("@") && tokens[1].endsWith("@"))
				{
					node.setId(tokens[1]);
					node.setTagName(tokens[2].toLowerCase());
				}
				
				//Third token forms the value
				else if (tokens.length == 3)
				{
					node.setTagName(tokens[1].toLowerCase());
					node.setValue(tokens[2]);
				}
				else
				{
					node.setTagName(tokens[1].toLowerCase());
				}
				nodes.add(node);
			}
		}
		return nodes;
	}

	private String xmlMarshaller(List<XMLNode> nodes)
	{
		//Builds the XML tree
		XMLNode root = XMLBuilder.buildTree(nodes);
		
		//Marshalls the complete xml node to string
		String xmlContent = doMarshall(root);
		
		return xmlContent.trim();
	}

	private String doMarshall(XMLNode node)
	{
		StringBuilder xml = new StringBuilder();
		List<XMLNode> childNodes = node.getChildNodes();

		if (childNodes.isEmpty())
		{
			xml.append(NodeMarshaller.createChildTag(node));
		}
		else
		{
			xml.append(NodeMarshaller.createOpenTag(node));

			for (XMLNode childNode : childNodes)
			{
				String childXml = doMarshall(childNode);
				xml.append(childXml);
			}
			xml.append(NodeMarshaller.createCloseTag(node));
		}
		return xml.toString();
	}
}
