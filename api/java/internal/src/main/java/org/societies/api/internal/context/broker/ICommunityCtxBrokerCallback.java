/**
 * Copyright (c) 2011, SOCIETIES Consortium (WATERFORD INSTITUTE OF TECHNOLOGY (TSSG), HERIOT-WATT UNIVERSITY (HWU), SOLUTA.NET 
 * (SN), GERMAN AEROSPACE CENTRE (Deutsches Zentrum fuer Luft- und Raumfahrt e.V.) (DLR), Zavod za varnostne tehnologije
 * informacijske dru�be in elektronsko poslovanje (SETCCE), INSTITUTE OF COMMUNICATION AND COMPUTER SYSTEMS (ICCS), LAKE
 * COMMUNICATIONS (LAKE), INTEL PERFORMANCE LEARNING SOLUTIONS LTD (INTEL), PORTUGAL TELECOM INOVAΗΓO, SA (PTIN), IBM Corp., 
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
package org.societies.api.internal.context.broker;

import java.util.List;

import org.societies.api.context.model.CtxAttribute;
import org.societies.api.context.model.CtxEntity;
import org.societies.api.context.model.CtxEntityIdentifier;


/**
 * 
 *  ICommunityCtxBrokerCallback interface. 
 * 
 * @author nikosk
 * @created 12-Nov-2011 7:15:14 PM
 */
public interface ICommunityCtxBrokerCallback {
	
	/**
	 * The callback of ICommunityCtxBroker method
	 * retrieveAdministratingCSS(CtxEntityIdentifier community, ICommunityCtxBrokerCallback callback) 
	 * 
	 * @param admCssRetr
	 * @since 0.0.1
	 */
	public void adminCSSRetrieved(CtxEntity admCssRetr);

	/**
	 * The callback of ICommunityCtxBroker method
	 * retrieveBonds(CtxEntityIdentifier community, ICommunityCtxBrokerCallback callback)
	 * 
	 * @param ctxAttribute
	 * @since 0.0.1
	 */
	public void bondsRetrieved(CtxAttribute ctxAttribute);

	/**
	 * The callback of ICommunityCtxBroker method
	 * retrieveChildCommunities(CtxEntityIdentifier community, ICommunityCtxBrokerCallback callback)
	 * 
	 * @param childComms
	 * @since 0.0.1
	 */
	public void childCommsRetrieved(List<CtxEntityIdentifier> childComms);

	/**
	 * The callback of ICommunityCtxBroker method
	 * retrieveCommunityMembers(CtxEntityIdentifier community, ICommunityCtxBrokerCallback callback)
	 * 
	 * @param commMembs
	 * @since 0.0.1
	 */
	public void commMembersRetrieved(List <CtxEntityIdentifier> commMembs);

	/**
	 * The callback of ICommunityCtxBroker method
	 * retrieveParentCommunities(CtxEntityIdentifier community, ICommunityCtxBrokerCallback callback)
	 * 
	 * @param parentComms
	 * @since 0.0.1
	 */
	public void parentCommsRetrieved(List<CtxEntityIdentifier> parentComms);

}
