package com.myparser.model;

import java.util.ArrayList;
import java.util.List;

import com.myparser.constants.ParserConstant;

/**
 * Created by Vikas B Jatagond
 * Model which holds all information related to xml file
 */
public class XMLNode
{
	private int taglevel;
	private String id;
	private String tagName;
	private String value;

	private XMLNode parentNode;
	private List<XMLNode> childNodes = new ArrayList<XMLNode>();

	public XMLNode()
	{
	}

	public XMLNode(int level, String id, String tag, String value)
	{
		this.taglevel = level;
		this.id = id;
		this.tagName = tag;
		this.value = value;
	}

	public XMLNode getParentNode() {
		return parentNode;
	}

	public void setParentNode(XMLNode parentNode) {
		this.parentNode = parentNode;
	}

	public List<XMLNode> getChildNodes() {
		return childNodes;
	}

	public void setChildNodes(List<XMLNode> childNodes) {
		this.childNodes = childNodes;
	}

	public int getTaglevel() {
		return taglevel;
	}

	public void setTaglevel(int taglevel) {
		this.taglevel = taglevel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isRootNode()
	{
		return this.taglevel == ParserConstant.ROOT_NODE;
	}

	public void addChildNode(XMLNode nodes) {
		this.childNodes.add(nodes);
	}
}
