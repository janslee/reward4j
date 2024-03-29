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
package org.reward4j.model;

/**
 * A very simple implementation of the {@link Amount} interface.
 * 
 * @author hillger.t
 */
public class SimpleAmount implements Amount {
  private double amount = 0d;

  @Override
  public double getAmount() {
    return amount;
  }

  @Override
  public void setAmount(double amount) {
    this.amount = amount;
  }
}
