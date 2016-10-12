/**
 * Copyright 2007-2015, Kaazing Corporation. All rights reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kaazing.specification.turn;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.rules.RuleChain.outerRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.kaazing.k3po.junit.annotation.Specification;
import org.kaazing.k3po.junit.rules.K3poRule;

/**
 * Test to validate behavior as specified in <a href="https://tools.ietf.org/html/rfc6062">Traversal Using Relays around NAT (TURN) Extensions for TCP Allocations</a>.
 */
public class AllocationsTcpIT {

    private final K3poRule k3po = new K3poRule().setScriptRoot("org/kaazing/specification/turn/tcp.allocations");

    private final TestRule timeout = new DisableOnDebug(new Timeout(5, SECONDS));

    @Rule
    public final TestRule chain = outerRule(k3po).around(timeout);

    /**
     * See <a href="https://tools.ietf.org/html/rfc6062#section-4.1">RFC 6062 Section 4.1. Creating an Allocation</a>.
     */
    @Test
    @Specification({
        "allocate/request",
        "allocate/response"}
    )
    public void shouldCreateAllocation() throws Exception {
        k3po.finish();
    }

    /**
     * See <a href="https://tools.ietf.org/html/rfc6062#section-4.1">RFC 6062 Section 4.3. Initiating a Connection</a>.
     */
    @Test
    @Specification({
        "connect/request",
        "connect/response"
    })
    public void shouldSendAndReceiveConnect() throws Exception {
        k3po.finish();
    }


    /**
     * See <a href="https://tools.ietf.org/html/rfc6062#section-4.1">RFC 6062 Section 4.4. Receiving a Connection</a>.
     */
    @Test
    @Specification({
            "connection_attempt/request",
            "connection_attempt/response"
    })
    public void shouldReceiveConnectionAttempt() throws Exception {
        k3po.finish();
    }

    /**
     * See <a href="https://tools.ietf.org/html/rfc6062#section-4.1">RFC 6062 Section 4.4. Receiving a Connection</a>.
     */
    @Test
    @Specification({
            "connection_bind/request",
            "connection_bind/response"
    })
    public void shouldSendAndReceiveConnectionBind() throws Exception {
        k3po.finish();
    }
}