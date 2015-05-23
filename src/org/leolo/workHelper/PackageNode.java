package org.leolo.workHelper;

import java.util.Collection;

public class PackageNode extends NonLeafNode {

	public PackageNode(String name) {
		super(name);
	}

	@Override
	public void addChild(TreeNode node) {

	}

	@Override
	public Collection<TreeNode> getChildren() {
		return null;
	}

	@Override
	public boolean hasChild() {
		return false;
	}

	@Override
	protected String getNameSeparator() {
		return ".";
	}

}
