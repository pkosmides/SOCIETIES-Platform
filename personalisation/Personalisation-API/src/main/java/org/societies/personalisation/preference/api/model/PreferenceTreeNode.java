package org.societies.personalisation.preference.api.model;

import java.io.Serializable;
import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;

import org.societies.personalisation.common.api.model.IOutcome;



/**
 * @author Elizabeth
 * @version 1.0
 * @created 08-Nov-2011 14:02:57
 */
public class PreferenceTreeNode extends DefaultMutableTreeNode implements IPreference, Serializable {




	
	public PreferenceTreeNode(){
		super();
	}
	
	public PreferenceTreeNode(IPreferenceCondition pc){
		super(pc);	
	}
	
	public PreferenceTreeNode(IOutcome po){
		super(po,false);
		
	}

	public IPreferenceOutcome getOutcome() {
		Object obj = this.getUserObject();
		if (obj instanceof IOutcome){
			return (IPreferenceOutcome) obj;
		}
		return null;
	}


	public IPreferenceCondition getCondition() {
		Object obj = this.getUserObject();
		if (obj instanceof IPreferenceCondition){
			return (IPreferenceCondition) obj;
		}
		return null;
	}

	public boolean isBranch() {
		Object obj = this.getUserObject();
		if (obj==null){
			return true;
		}
		if (obj instanceof IPreferenceCondition){
			return true;
		}	
		return false;
	}
	
	public boolean isLeaf(){
		Object obj = this.getUserObject();
		if (obj instanceof IPreferenceCondition){
			return false;
		}	
		if (obj==null){
			return false;
		}
		return true;	
	}
	
	
	public Object[] getUserObjectPath(){
		return super.getUserObjectPath();
	}



	public void add(IPreference p) {
	
		super.add(p);
		
	}

	public void remove(IPreference p) {
		super.remove(p);
		
	}	
	
	public Enumeration<IPreference> depthFirstEnumeration(){
		return super.depthFirstEnumeration();
	}
	
	public Enumeration<IPreference> breadthFirstEnumeration(){
		return super.breadthFirstEnumeration();
	}
	
	public IPreference getRoot(){
		return (IPreference) super.getRoot();
	}
	
	public int getLevel(){
		return super.getLevel();
	}
	
	public int getDepth(){
		return super.getDepth();
	}
	
	/**
	 * @see DefaultMutableTreeNode#preorderEnumeration()
	 * @return	an enumeration of IPreference node objects traversed in pre-order
	 */
	public Enumeration<IPreference> preorderEnumeration(){
		return super.preorderEnumeration();
	}
	
	/**
	 * @see DefaultMutableTreeNode#postorderEnumeration()
	 * @return	an enumeration of IPreference node objects traversed in post-order
	 */
	public Enumeration<IPreference> postorderEnumeration(){
		return super.postorderEnumeration();
	}
	
	/*
	public String toString(){
		String str = "";
		if (this.isLeaf()){
			String tab = "\n";
			for (int i = 0; i<this.getLevel(); i++){
				tab = tab.concat("\t");
			}
			return tab.concat(this.getOutcome().toString());
		}else{
			String tab  = "\n";
			if (null!=this.userObject){
				for (int i=0; i<this.getLevel(); i++){
					str = str.concat("\t");
				}
				str = str + this.userObject.toString()+"\n";
			}
			Enumeration<IPreference> e = this.children();
			while (e.hasMoreElements()){
				str = str+e.nextElement().toString()+"\n";
			}
			return str;
		}
	}*/
	
	public String toString(){
		if (this.userObject==null){
			return "root";
		}
		return this.getUserObject().toString();
	}
	
	

	public String toTreeString(){
		String str = "";
		Enumeration<IPreference> e = this.preorderEnumeration();
		
		while (e.hasMoreElements()){
			IPreference p = e.nextElement();
			for (int i = 0; i<p.getLevel(); i++){
				str = str.concat("\t");
			}
			
			str = str.concat(p.toString()+"\n");
			
		}
		return str;
	}
}