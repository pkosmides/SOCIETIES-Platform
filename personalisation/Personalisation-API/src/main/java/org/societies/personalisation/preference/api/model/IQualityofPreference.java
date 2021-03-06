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
package org.societies.personalisation.preference.api.model;

import java.util.Date;

/**
 * @author Elizabeth
 * @version 1.0
 * @created 08-Nov-2011 14:02:56
 */
public interface IQualityofPreference {

	/**
	 * Retrieves how many times the outcome has been aborted
	 * @return
	 */
	public int getAbortedCounter();

	/**
	 * Retrieves the Date the outcome was last aborted
	 * @return		the last aborted Date
	 */
	public Date getLastAborted();

	/**
	 * get the Date an outcome was last learnt
	 * @return	the Date
	 */
	public Date getLastModified();

	/**
	 * Retrieves the Date the outcome was last successfully implemented
	 * @return
	 */
	public Date getLastSuccess();

	/**
	 * Retrieves how many times the outcome has been successfully implemented
	 * @return		the successCounter
	 */
	public int getSuccessCounter();

	/**
	 * increases the abortedCounter by level
	 * 
	 * @param level    by how much to increase the abortedCounter
	 */
	public void increaseAbortedCounter(int level);

	/**
	 * increases the counter for successful implementations by level
	 * 
	 * @param level    by how much to increase the successCounter
	 */
	public void increaseSuccessCounter(int level);

	/**
	 * Changes the Date the outcome was last aborted
	 * 
	 * @param lastAborted    the Date last aborted
	 */
	public void setLastAborted(Date lastAborted);

	/**
	 * set the Date an outcome was last learnt
	 * 
	 * @param lastModified    lastModified
	 */
	public void setLastModified(Date lastModified);

	/**
	 * Changes the date the outcome was last successfully implemented
	 * 
	 * @param lastSuccess    lastSuccess
	 */
	public void setLastSuccess(Date lastSuccess);

}