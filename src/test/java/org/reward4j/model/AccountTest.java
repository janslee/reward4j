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

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The {@code AccountTest} tests the {@link Account} model.
 * 
 * @author Peter Kehren <mailto:kehren@eyeslide.de>
 */
public class AccountTest {
    
    @Test
    public void testGetBalance() {
        RateableAction action = new RateableAction("action");
        Position position1 = new Position(action, new Coin(4));
        Position position2 = new Position(action, new Coin(6));
        
        Account account = new Account("testaccount");
        account.addPosition(position1);
        account.addPosition(position2);
        
        assertEquals(new Coin(10), account.getBalance());
        
        Account account2 = new Account("testaccount2");
        assertEquals(new Coin(0), account2.getBalance());
    }
    
    public void testEquals() {
        Account account1a = new Account("testaccount1");
        Account account1b = new Account("testaccount1");
        Account account2 = new Account("testaccount1");
        
        assertEquals(account1a, account1b);
        assertFalse(account1a.equals(account2));
    }

}