package org.leolo.workHelper;

import java.util.Collection;
import java.util.TreeMap;

public abstract class NonLeafNode extends TreeNode {
	
	private TreeMap<String,TreeNode> children;
	
	protected NonLeafNode(String name) {
		super(name);
		children = new TreeMap<>();
	}

	@Override
	public void addChild(TreeNode node){
		node.parent = this;
		children.put(node.name,node);
	}
	
	@Override
	public Collection<TreeNode> getChildren(){
		return this.children.values();
	}
	
	@Override
	public boolean hasChild(){
		return this.children.size() != 0;
	}

}
