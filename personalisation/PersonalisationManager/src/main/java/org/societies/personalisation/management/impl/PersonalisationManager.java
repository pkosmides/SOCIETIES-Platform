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
package org.societies.personalisation.management.impl;

import org.societies.api.context.model.CtxAttribute;
import org.societies.api.context.model.CtxAttributeIdentifier;
import org.societies.api.context.model.CtxModelObject;
//import org.societies.api.internal.context.broker.IUserCtxBroker;
import org.societies.api.internal.personalisation.model.IFeedbackEvent;
import org.societies.api.mock.EntityIdentifier;
import org.societies.api.mock.ServiceResourceIdentifier;
import org.societies.api.personalisation.mgmt.IPersonalisationManager;
import org.societies.api.personalisation.model.IAction;
import org.societies.personalisation.CAUI.api.model.IUserIntentAction;
import org.societies.personalisation.CRIST.api.model.ICRISTUserAction;
import org.societies.personalisation.DIANNE.api.model.IDIANNEOutcome;
import org.societies.personalisation.common.api.management.IInternalPersonalisationManager;
import org.societies.personalisation.preference.api.model.IPreferenceOutcome;



public class PersonalisationManager implements IPersonalisationManager, IInternalPersonalisationManager{

	//IUserCtxBroker broker;

	public PersonalisationManager(/*IUserCtxBroker broker*/){
		System.out.println("HELLO! I'm a brand new service and my interface is: "+this.getClass().getName());
		//this.broker = broker;
		
	}
	@Override
	public IAction getIntentAction(EntityIdentifier arg0,
			EntityIdentifier arg1, ServiceResourceIdentifier arg2, String arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IAction getPreference(EntityIdentifier arg0, EntityIdentifier arg1,
			String arg2, ServiceResourceIdentifier arg3, String arg4) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IAction getIntentTask(EntityIdentifier arg0,
			ServiceResourceIdentifier arg1, String arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IAction getIntentTask(EntityIdentifier arg0, EntityIdentifier arg1,
			ServiceResourceIdentifier arg2, String arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IAction getPreference(EntityIdentifier arg0, String arg1,
			ServiceResourceIdentifier arg2, String arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerForContextUpdate(EntityIdentifier identifier, String className,
			CtxAttributeIdentifier attrId) {
		
		//this.broker.registerForUpdates(attrId.getScope(), attrId.getType(), new ContextEventCallback(this));
	}

	@Override
	public void returnFeedback(IFeedbackEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendCAUIOutcome(EntityIdentifier arg0,
			ServiceResourceIdentifier arg1, IUserIntentAction arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendDianneOutcome(EntityIdentifier arg0,
			ServiceResourceIdentifier arg1, IDIANNEOutcome arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendITSUDUserIntentOutcome(EntityIdentifier arg0,
			ServiceResourceIdentifier arg1, ICRISTUserAction arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendPreferenceOutcome(EntityIdentifier arg0, String arg1,
			ServiceResourceIdentifier arg2, IPreferenceOutcome arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateReceived(CtxModelObject obj) {
		//check who to send it to
		CtxAttribute attribute = (CtxAttribute) obj;
		System.out.println("Received context event\n");
		System.out.println("Attribute type: "+attribute.getType());
		System.out.println("Attribute value: "+attribute.getStringValue());
		
	}


}
