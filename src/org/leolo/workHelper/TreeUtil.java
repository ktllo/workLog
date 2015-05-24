package org.leolo.workHelper;

import java.io.PrintStream;
import java.util.Collection;

public final class TreeUtil {

	private TreeUtil() {
		//You should not do this
	}
	
	public static String traversalIndentation = "  ";

	private static void traversal(TreeNode root, PrintStream out,int level){
		Collection<TreeNode> nodes = root.getChildren();
		for(int i=0;i<level;i++)
			out.print(traversalIndentation);
		out.println(root.name);
		level++;
		for(TreeNode node:nodes)
			traversal(node,out,level);
	}
	
	public static void traversal(TreeNode root, PrintStream out){
		traversal(root,out,0);
	}
	
	public static String format(int num){
		String s = Integer.toHexString(num);
		while(s.length() < 8)
			s = "0"+s;
		return s;
	}
}
