package org.societies.personalisation.preference.api.model;

/**
 * @author Elizabeth
 * @version 1.0
 * @created 08-Nov-2011 14:02:56
 */
import java.io.Serializable;

import org.societies.personalisation.common.api.model.ICtxAttributeIdentifier;



public class ContextPreferenceCondition implements IPreferenceCondition, Serializable{

	private ICtxAttributeIdentifier CtxIdentifier;
	//private String strCtxId;
	private String type;
	private String name;
	private String value;
	private OperatorConstants operator;


	public ContextPreferenceCondition(ICtxAttributeIdentifier ctxId, OperatorConstants op, String val, String name){
		this.CtxIdentifier = ctxId;
		this.operator = op;
		this.value = val;
		this.type = "context";
		this.name = name;

	}
	
	public String getType(){
		return this.type;
	}


	public ICtxAttributeIdentifier getCtxIdentifier(){
		return CtxIdentifier;
	}


	public void setCtxIdentifier(ICtxAttributeIdentifier newVal){
		CtxIdentifier = newVal;
	}

	public String getname(){
		return name;
	}


	public void setname(String newVal){
		name = newVal;
	}

	public String getvalue(){
		return value;
	}


	public void setvalue(String newVal){
		value = newVal;
	}

	public OperatorConstants getoperator(){
		return operator;
	}

	public void setoperator(OperatorConstants op){
		operator = op;
	}
	
	public String toString(){
		
		return this.CtxIdentifier.getType()+this.operator+this.value;
	}
	
	public boolean equals(IPreferenceCondition pc){

		if (!(pc.getname().equals(this.name))){
			return false;
		}
		if (!(pc.getoperator().equals(this.operator))){
			return false;
		}
		if (!(pc.getCtxIdentifier().equals(this.CtxIdentifier))){
			return false;
		}
		if (!(pc.getType().equals(this.type))){
			return false;
		}
		if (!(pc.getvalue().equals(this.value))){
			return false;
		}
		
		return true;
	}
	public boolean equalsIgnoreValue(IPreferenceCondition pc){
		if (!(pc.getCtxIdentifier().equals(this.CtxIdentifier))){
			return false;
		}
		if (!(pc.getname().equals(this.name))){
			return false;
		}
		if (!(pc.getoperator().equals(this.operator))){
			return false;
		}
		if (!(pc.getCtxIdentifier().equals(this.CtxIdentifier))){
			return false;
		}
		if (!(pc.getType().equals(this.type))){
			return false;
		}
		
		return true;
	}
}