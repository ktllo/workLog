package org.leolo.workHelper;

import java.util.Collection;

public class LeafNode extends TreeNode {

	public LeafNode(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addChild(TreeNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<TreeNode> getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChild() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected String getNameSeparator() {
		// TODO Auto-generated method stub
		return null;
	}

}
