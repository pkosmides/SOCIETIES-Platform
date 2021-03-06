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
package org.societies.personalisation.preference.api.UserPreferenceLearning;
 

import java.util.List;

import org.societies.api.mock.EntityIdentifier;
import org.societies.api.mock.ServiceResourceIdentifier;
import org.societies.personalisation.preference.api.model.IPreferenceTreeModel;



/**
 * @author Eliza
 * @version 1.0
 * @created 11-Nov-2011 15:06:05
 */
public interface IC45Output {

	/**
	 * This method adds a new DefaultTreeModel to the object learned under the object
	 * IDigitalPersonalIdentifier and IServiceIdentifier
	 * 
	 * @param tree    - the tree to be added
	 */
	public void addTree(IPreferenceTreeModel tree);

	/**
	 * This method returns the IDigitalPersonalIdentifier related to this object
	 * @return IDigitalPersonalIdentifier - the dpi under which the info in this
	 * IC45Output object corresponds
	 */
	public EntityIdentifier getDPI();

	/**
	 * This method returns the IServiceIdentifier related to this object
	 * @return IServiceIdentifier - the service ID
	 */
	public ServiceResourceIdentifier getServiceId();

	/**
	 * This method returns the type of the service e.g. "multi-media"
	 * @return String - the service type
	 */
	public String getServiceType();

	/**
	 * This method returns a list of DefaultTreeModel objects that have been learned
	 * under this objects associated IDigitalPersonalIdentifier and IServiceIdentifier
	 * 
	 * @return a list of IDecisionTree objects
	 */
	public List<IPreferenceTreeModel> getTreeList();

}