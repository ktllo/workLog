package org.leolo.workHelper;

import java.util.Collection;

public class PackageNode extends NonLeafNode {

	public PackageNode(String name) {
		super(name);
	}

	

	@Override
	protected String getNameSeparator() {
		return ".";
	}



}
