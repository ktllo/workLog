package org.leolo.workHelper;

import java.util.Collection;
import java.util.Random;
import java.util.TreeMap;

public abstract class TreeNode {
	protected TreeNode parent;
	protected String name;
	protected static Random random;
	private String note = "";
	public final int nodeID;
	static{
		random = new Random();
	}
	
	protected TreeNode(String name){
		this.name = name;
		nodeID = random.nextInt();
	}
	
	public abstract void addChild(TreeNode node);

	public abstract Collection<TreeNode> getChildren();

	public abstract boolean hasChild();
	
	public void setNote(String note){
		this.note = note;
	}
	
	public void appendNote(String note){
		this.note = this.note + "\n" + note;
	}
	
	public String getNote(){
		return this.note;
	}
	
	protected abstract String getNameSeparator();
	
	public String getFullName(){
		if(isRoot())
			return name;
		return parent.getFullName()+getNameSeparator()+name;
	}
	
	public final boolean isRoot(){
		return parent == null;
	}
	
	@Override
	public int hashCode(){
		int hash = name.hashCode() ^ note.hashCode();
		for(TreeNode node:getChildren()){
			hash += node.hashCode();
		}
		return hash;
	}
}
