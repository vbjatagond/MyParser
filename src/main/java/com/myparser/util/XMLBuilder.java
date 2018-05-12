package com.myparser.util;

import java.util.List;
import java.util.Stack;

import com.myparser.model.XMLNode;
/**
 * Created by Vikas B Jatagond
 * Helper class to build a hierarchy tree based on levels of each node
 */
public class XMLBuilder
{
	/**
	 * @param nodes in order and links to them each other based on level of each node
	 * @return root node
	 */
	public static XMLNode buildTree(List<XMLNode> nodes) 
	{
		if (nodes.isEmpty())
		{
			System.out.println("No nodes found to build tree");
		}

		if (!nodes.get(0).isRootNode())
		{
			System.out.println("First node should be root node with level -1");
		}

		XMLNode rootNode = nodes.get(0);
		Stack<XMLNode> rootStack = new Stack<XMLNode>();

		XMLNode previousNode = rootNode;
		int previousLevel = rootNode.getTaglevel();

		for (int i = 1; i < nodes.size(); i++)
		{
			XMLNode currentNode = nodes.get(i);
			int currentLevel = currentNode.getTaglevel();

			if (currentLevel > previousLevel)
			{
				// if level increases push the previous node to root stack
				rootStack.push(previousNode);
			}
			else if (currentLevel < previousLevel)
			{
				// if level decreases, pop the current node
				while (currentLevel <= rootStack.peek().getTaglevel())
				{
					rootStack.pop();
				}
			}

			XMLNode tempRoot = rootStack.peek();
			currentNode.setParentNode(tempRoot);
			tempRoot.addChildNode(currentNode);

			previousNode = currentNode;
			previousLevel = currentLevel;
		}
		return rootNode;
	}
}
