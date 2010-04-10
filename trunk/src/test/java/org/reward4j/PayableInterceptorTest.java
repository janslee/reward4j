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

package org.reward4j;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;
import org.reward4j.model.Coin;
import org.reward4j.model.User;
import org.reward4j.service.RewardService;
import org.reward4j.service.UserNotFoundException;
import org.reward4j.service.UserResolver;

import static org.easymock.classextension.EasyMock.*;

public class PayableInterceptorTest {
    private PayableInterceptor interceptor;
    
    @Before
    public void setUp() {
        this.interceptor = new PayableInterceptor();
    }
    
    @Test
    public void testAfterReturning() throws UserNotFoundException, Throwable {
        
        User user = new User(1, "john doe");
        
        RewardService rewardService = createMock(RewardService.class);
        rewardService.payForAction(new Coin(10), "testAction", user);
        expectLastCall().times(1); // payForAction must be called at least once
        replay(rewardService);
        
        UserResolver userResolver = createMock(UserResolver.class);
        expect(userResolver.getUser()).andReturn(user).times(1);
        replay(userResolver);
        
        Method method = null;
        PayableTestSupport payableTestSupport = new PayableTestSupport();
        for(Method m:payableTestSupport.getClass().getMethods()) {
            if(m.getName().equalsIgnoreCase("testMe")) {
                method = m;
            }
        }
        
        this.interceptor.setRewardService(rewardService);
        this.interceptor.setUserResolver(userResolver);
        this.interceptor.afterReturning(null, method, null, null);
        
        verify(rewardService);
        verify(userResolver);
    }
    
    
    
    class PayableTestSupport {
        @Payable(action="testAction", coins="10")
        public void testMe() {}
    }

}
