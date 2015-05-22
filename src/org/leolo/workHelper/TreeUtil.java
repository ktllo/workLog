package org.leolo.workHelper;

import java.io.PrintStream;
import java.util.Collection;

public class TreeUtil {

	private TreeUtil() {
		//You should not do this
	}
	
	public static void traversal(TreeNode root, PrintStream out){
		Collection<TreeNode> set = root.getChild();
		for(TreeNode node:set){
			traversal(node,out);//Has issue. Fix later.
		}
	}
	
}
