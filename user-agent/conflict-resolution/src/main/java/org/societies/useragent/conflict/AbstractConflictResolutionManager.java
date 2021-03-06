/**
 * Copyright (c) 2011, SOCIETIES Consortium (WATERFORD INSTITUTE OF TECHNOLOGY (TSSG), HERIOT-WATT UNIVERSITY (HWU), SOLUTA.NET 
 * (SN), GERMAN AEROSPACE CENTRE (Deutsches Zentrum fuer Luft- und Raumfahrt e.V.) (DLR), Zavod za varnostne tehnologije
 * informacijske druzbe in elektronsko poslovanje (SETCCE), INSTITUTE OF COMMUNICATION AND COMPUTER SYSTEMS (ICCS), LAKE
 * COMMUNICATIONS (LAKE), INTEL PERFORMANCE LEARNING SOLUTIONS LTD (INTEL), PORTUGAL TELECOM INOVACAO, SA (PTIN), IBM Corp., 
 * INSTITUT TELECOM (ITSUD), AMITEC DIACHYTI EFYIA PLIROFORIKI KAI EPIKINONIES ETERIA PERIORISMENIS EFTHINIS (AMITEC), TELECOM 
 * ITALIA S.p.a.(TI),  TRIALOG (TRIALOG), Stiftelsen SINTEF (SINTEF), NEC EUROPE LTD (NEC))
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

package org.societies.useragent.conflict;

import java.util.List;

import org.societies.api.internal.personalisation.model.IOutcome;
import org.societies.api.internal.useragent.conflict.IConflictResolutionManager;
import org.societies.api.internal.useragent.model.ConflictResolutionRule;
import org.societies.api.internal.useragent.model.EnsembleConflictResolutionRule;

public class AbstractConflictResolutionManager implements IConflictResolutionManager{
	private List<ConflictResolutionRule> rules;
	private ConflictResolutionRule united;
	public List<ConflictResolutionRule> getRules() {
		return rules;
	}
	public void setRules(List<ConflictResolutionRule> rules) {
		this.rules = rules;
		this.united=EnsembleConflictResolutionRule.fold(this.rules);
	}

	public void addRule(ConflictResolutionRule rule) {
		rules.add(rule);
		this.united=EnsembleConflictResolutionRule.fold(this.rules);
	}

	public void deleteRule(ConflictResolutionRule rule) {
		rules.remove(rule);
		this.united=EnsembleConflictResolutionRule.fold(this.rules);
	}
	@Override
	public IOutcome resolveConflict(final IOutcome intentaction, 
				final IOutcome preferaction) {
		// TODO Auto-generated method stub
		if(united.match(intentaction, preferaction)){
			IOutcome result=united.tradeoff(intentaction, preferaction);
			return result;
		}
		/*nothing matches*/
		return null;
	}
}
