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

/**
 * This class represents a CIS membership rule, which applies for what
 * members can join a CIS
 * 
 * @author Fraser Blackmun
 * @version 0
 * 
 */

package org.societies.orchestration.CisRule.impl;

import java.util.HashMap;

public class CisMembershipRule {
	
	//The rule embodied by the CisMembershipRule object that this interface represents.
	//The 'keys' in the HashMap may be the following (still in progress):
	//  "CIS membership criteria" - value = the membership criteria for a CIS
	//  
	private HashMap ruleDetails;

    /*
     * Constructor for CisMembershipRule.
     * 
	 * Description: The constructor creates a new CisMembershipRule with the details
	 *              passed to it.
	 * Parameters: 
	 * 				1) ruleToCreate - The details on the rule that are needed
	 *                                in order to create it. 
	 */
	
	public ICisRule(HashMap ruleToCreate);
	
	/*
	 * Description: The modifyRule method alters the rule that the CisMembershipRule 
	 *              object represents, using the details in the input HashMap.
	 * Parameters: 
	 * 				1) changesToRule - The changes that are to be made to the CIS membership rule.
	 * Returns:
	 * 				* True if the method was able to modify the CIS membership rule.
	 *				* False if the method was unable to modify the CIS membership rule.
	 */
	
    public boolean modifyRule(HashMap changesToRule);
	
    /*
	 * Description: The modifyRule method alters the rule that the CisMembershipRule 
	 *              object represents, using the information of the input
	 *              CisRule.
	 * Parameters: 
	 * 				1) CisRule - The new rule that is replacing the existing one
	 * Returns:
	 * 				* True if the method was able to modify the CIS membership rule.
	 *				* False if the method was unable to modify the CIS membership rule.
	 */
    
	public boolean modifyRule(CisRule replacingRule);
	
	/*
	 * Description: The deleteRule method causes the CIMembershipRule object
	 *              that the method is invokved on to delete itself.
	 * Parameters: 
	 * 				none
	 * Returns:
	 * 				* True if the method was able to delete the CIS membership rule.
	 *				* False if the method was unable to delete the CIS membership rule.
	 */
	
	public boolean deleteRule();

}
