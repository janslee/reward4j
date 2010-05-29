/**
 * Copyright 2009-2010 reward4j.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.reward4j.pay;

/**
 * Interface describing how some amounts can can be retrieved. Implementations can be configured with the {@link Payable} annotaion 
 * to handle individual purpose needs for retrieving
 * 
 * @author hillger.t
 */
public interface Amount {

	/**
	 * Returns an amount which should be payed when a rateable action was successfully executed.
	 */
	public double getAmount();
	
	/**
	 * Sets the given amount value that should be payed for a rateable action.
	 */
	public void setAmount(double amount);
}
