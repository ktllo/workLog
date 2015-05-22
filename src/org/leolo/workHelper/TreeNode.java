package org.leolo.workHelper;

import java.util.Random;
import java.util.TreeMap;

public abstract class TreeNode {
	protected TreeNode parent;
	protected TreeMap<String,TreeNode> childs;
	protected String name;
	protected static Random random;
	private final int nodeID;
	static{
		random = new Random();
	}
	
	protected TreeNode(String name){
		this.name = name;
		childs = new TreeMap<>();
		nodeID = random.nextInt();
	}
	
	public void addChild(TreeNode node){
		childs.put(node.name, node);
	}

	public int getNodeID() {
		return nodeID;
	}


}
