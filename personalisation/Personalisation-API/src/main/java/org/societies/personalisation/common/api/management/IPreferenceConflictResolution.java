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

package org.societies.personalisation.common.api.management;

import org.societies.api.internal.personalisation.model.IOutcome;
import org.societies.api.mock.EntityIdentifier;
import org.societies.personalisation.CAUI.api.model.IUserIntentAction;
import org.societies.personalisation.CRIST.api.model.ICRISTUserAction;
import org.societies.personalisation.DIANNE.api.model.IDIANNEOutcome;
import org.societies.personalisation.preference.api.model.IPreferenceOutcome;



/**
 * @author Eliza
 * @version 1.0
 * @created 11-Nov-2011 14:43:38
 */
public interface IPreferenceConflictResolution {

	/**
	 * 
	 * @param user_id
	 * @param dianneAction
	 * @param preferenceAction
	 */
	public IOutcome resolveConflict(EntityIdentifier user_id, IDIANNEOutcome dianneAction, IPreferenceOutcome preferenceAction);

	/**
	 * 
	 * @param user_id
	 * @param intentActionICCS
	 * @param intentActionITSUD
	 */
	public IOutcome resolveConflict(EntityIdentifier user_id, IUserIntentAction intentActionICCS, ICRISTUserAction intentActionITSUD);

}