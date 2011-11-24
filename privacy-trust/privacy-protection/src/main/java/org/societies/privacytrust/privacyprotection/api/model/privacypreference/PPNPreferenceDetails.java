/**
 * Copyright (c) 2011, SOCIETIES Consortium
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following
 * conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following
 *    disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING,
 * BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT 
 * SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.societies.privacytrust.privacyprotection.api.model.privacypreference;

import java.io.Serializable;

import org.societies.personalisation.common.api.model.EntityIdentifier;
import org.societies.personalisation.common.api.model.ICtxAttributeIdentifier;
import org.societies.personalisation.common.api.model.ServiceResourceIdentifier;

public class PPNPreferenceDetails implements Serializable{

	private String contextType;
	private ICtxAttributeIdentifier affectedCtxID;
	private EntityIdentifier requestorDPI;
	private ServiceResourceIdentifier serviceID;
	public PPNPreferenceDetails(String contextType){
		this.setContextType(contextType);
	}

	public void setAffectedCtxID(ICtxAttributeIdentifier affectedCtxID) {
		this.affectedCtxID = affectedCtxID;
	}

	public ICtxAttributeIdentifier getAffectedCtxID() {
		return affectedCtxID;
	}

	public void setRequestorDPI(EntityIdentifier requestorDPI) {
		this.requestorDPI = requestorDPI;
	}

	public EntityIdentifier getRequestorDPI() {
		return requestorDPI;
	}

	public void setContextType(String contextType) {
		this.contextType = contextType;
	}

	public String getContextType() {
		return contextType;
	}
	
	private boolean compareRequestorDPIs(EntityIdentifier dpi){
		if (dpi==null){
			if (this.requestorDPI==null){
				return true;
			}else{
				return false;
			}
		}else{
			if (this.requestorDPI==null){
				return false;
			}else{
				if (dpi.toUriString().equals(requestorDPI.toUriString())){
					return true;
				}else{
					return false;
				}
			}
		}
	}
	
	private boolean compareServiceID(ServiceResourceIdentifier serviceID2){
		if (serviceID2==null){
			if (this.serviceID == null){
				return true;
			}else{
				return false;
			}
		}else{
			if (serviceID2==null){
				return false;
			}else{
				if (serviceID2.toUriString().equalsIgnoreCase(this.serviceID.toUriString())){
					return true;
				}else{
					return false;
				}
			}
		}
	}
	private boolean compareCtxIDs(ICtxAttributeIdentifier ctxID){
		if (ctxID==null){
			if (this.affectedCtxID==null){
				return true;
			}else{
				return false;
			}
		}else{
			if (this.affectedCtxID==null){
				return false;
			}else{
				if (ctxID.toUriString().equals(this.affectedCtxID.toUriString())){
					return true;
				}else{
					return false;
				}
			}
		}
	}
	@Override
	public boolean equals(Object obj){
		if (obj instanceof PPNPreferenceDetails){
			PPNPreferenceDetails det = (PPNPreferenceDetails) obj;
			if (det.getContextType().equalsIgnoreCase(contextType)){
				if (compareCtxIDs(det.getAffectedCtxID())){
					if (compareRequestorDPIs(det.getRequestorDPI())){
						return this.compareServiceID(det.getServiceID());
					}else{
						return false;
					}
				}else{
					return false;
				}
			}else{
				return false;
			}
		}
		return false;
	}
	
	@Override
	public String toString(){
		String str = "\n";
		str = str.concat("Context Type: "+this.contextType);
		if (this.affectedCtxID!=null){
			str = str.concat("\nAffected CtxID: "+this.affectedCtxID.toUriString());
		}
		
		if (this.requestorDPI!=null){
			str = str.concat("\nRequestor DPI: "+this.requestorDPI.toUriString());
		}
		str = str.concat("\n");
		return str;
	}

	public void setServiceID(ServiceResourceIdentifier serviceID) {
		this.serviceID = serviceID;
	}

	public ServiceResourceIdentifier getServiceID() {
		return serviceID;
	}
	
}