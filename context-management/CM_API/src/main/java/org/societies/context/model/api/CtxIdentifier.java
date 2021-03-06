/**
 * Copyright (c) 2011, SOCIETIES Consortium (WATERFORD INSTITUTE OF TECHNOLOGY (TSSG), HERIOT-WATT UNIVERSITY (HWU), SOLUTA.NET 
 * (SN), GERMAN AEROSPACE CENTRE (Deutsches Zentrum fuer Luft- und Raumfahrt e.V.) (DLR), Zavod za varnostne tehnologije
 * informacijske družbe in elektronsko poslovanje (SETCCE), INSTITUTE OF COMMUNICATION AND COMPUTER SYSTEMS (ICCS), LAKE
 * COMMUNICATIONS (LAKE), INTEL PERFORMANCE LEARNING SOLUTIONS LTD (INTEL), PORTUGAL TELECOM INOVAÇÃO, SA (PTIN), IBM Corp., 
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
package org.societies.context.model.api;

import java.io.Serializable;

import org.societies.context.mock.spm.identity.EntityIdentifier;

/**
 * This abstract class is used to identify context model objects. It provides methods
 * that return information about the identified model object including:
 * <ul>
 * <li><tt>OperatorId</tt>: A unique identifier of the CSS or CIS where the 
 * identified context model object is stored.
 * </li>
 * <li><tt>ModelType</tt>: Describes the type of the identified context model
 * object, i.e. is one of the following: {@link CtxModelType#ENTITY ENTITY},
 * {@link CtxModelType#ATTRIBUTE ATTRIBUTE}, or {@link CtxModelType#ASSOCIATION
 * ASSOCIATION}.</li>
 * <li><tt>Type</tt>: A semantic tag that characterises the identified context
 * model object. e.g. "person".</li>
 * <li><tt>ObjectNumber</tt>: A unique number within the device where the
 * respective context information was initially sensed/collected and stored.</li>
 * </ul>
 * 
 * @see CtxModelType
 * @author <a href="mailto:nicolas.liampotis@cn.ntua.gr">Nicolas Liampotis</a> (ICCS)
 * @since 0.0.1
 */
public abstract class CtxIdentifier implements Serializable {

	private static final long serialVersionUID = 3552976823045895472L;
	
	private EntityIdentifier operatorId;
	private String type;
	private Long objectNumber;

	CtxIdentifier() {}

	/**
	 * Returns a unique identifier of the CSS or CIS where the identified
	 * context model object is stored
     * 
	 * @return a unique identifier of the CSS or CIS where the identified 
	 * context model object is stored
	 */
	public EntityIdentifier getOperatorId() {
		return this.operatorId;
	}
	
	/**
	 * Returns the type of the identified context model object
	 * 
	 * @return the type of the identified context model object
	 * @see CtxModelType
	 */
	public abstract CtxModelType getModelType();

	/**
	 * Returns the semantic tag (e.g. "person") that characterises the
	 * identified context model object
     * 
     * @return the semantic tag of the identified context model object 
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Returns the numeric part of this context model object identifier
     * 
     * @return the numeric part of this context model object identifier
	 */
	public Long getObjectNumber() {
		return this.objectNumber;
	}
	
	/*
	 * TODO 
	 * Returns a String representation of this context model object identifier
	 * 
	 * @return a String representation of this context model object identifier
	 *
	@Override
	public String toString() {
	}*/
}