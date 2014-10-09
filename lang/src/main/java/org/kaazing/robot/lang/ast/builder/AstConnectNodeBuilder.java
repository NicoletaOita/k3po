/*
 * Copyright (c) 2014 "Kaazing Corporation," (www.kaazing.com)
 *
 * This file is part of Robot.
 *
 * Robot is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.kaazing.robot.lang.ast.builder;

import java.net.URI;

import org.kaazing.robot.lang.ast.AstConnectNode;
import org.kaazing.robot.lang.ast.AstScriptNode;
import org.kaazing.robot.lang.http.ast.builder.AstReadHttpHeaderNodeBuilder;
import org.kaazing.robot.lang.http.ast.builder.AstReadHttpMethodNodeBuilder;
import org.kaazing.robot.lang.http.ast.builder.AstReadHttpParameterNodeBuilder;
import org.kaazing.robot.lang.http.ast.builder.AstReadHttpStatusNodeBuilder;
import org.kaazing.robot.lang.http.ast.builder.AstReadHttpVersionNodeBuilder;
import org.kaazing.robot.lang.http.ast.builder.AstWriteHttpContentLengthNodeBuilder;
import org.kaazing.robot.lang.http.ast.builder.AstWriteHttpHeaderNodeBuilder;
import org.kaazing.robot.lang.http.ast.builder.AstWriteHttpMethodNodeBuilder;
import org.kaazing.robot.lang.http.ast.builder.AstWriteHttpParameterNodeBuilder;
import org.kaazing.robot.lang.http.ast.builder.AstWriteHttpStatusNodeBuilder;
import org.kaazing.robot.lang.http.ast.builder.AstWriteHttpVersionNodeBuilder;

public final class AstConnectNodeBuilder extends AbstractAstConnectNodeBuilder<AstConnectNode> {

    private int line;

    public AstConnectNodeBuilder() {
        this(new AstConnectNode());
    }

    @Override
    public AstConnectNodeBuilder setLocationInfo(int line, int column) {
        node.setLocationInfo(line, column);
        internalSetLineInfo(line);
        return this;
    }

    @Override
    public AstConnectNodeBuilder setNextLineInfo(int linesToSkip, int column) {
        internalSetNextLineInfo(linesToSkip, column);
        return this;
    }

    public AstConnectNodeBuilder setLocation(URI location) {
        node.setLocation(location);
        return this;
    }

    @Override
    public AstOpenedNodeBuilder.StreamNested<AstConnectNodeBuilder> addOpenedEvent() {
        return new AstOpenedNodeBuilder.StreamNested<AstConnectNodeBuilder>(this);
    }

    @Override
    public AstBoundNodeBuilder.StreamNested<AstConnectNodeBuilder> addBoundEvent() {
        return new AstBoundNodeBuilder.StreamNested<AstConnectNodeBuilder>(this);
    }

    @Override
    public AstConnectedNodeBuilder.StreamNested<AstConnectNodeBuilder> addConnectedEvent() {
        return new AstConnectedNodeBuilder.StreamNested<AstConnectNodeBuilder>(this);
    }

    @Override
    public AstReadNodeBuilder.StreamNested<AstConnectNodeBuilder> addReadEvent() {
        return new AstReadNodeBuilder.StreamNested<AstConnectNodeBuilder>(this);
    }

    @Override
    public AstDisconnectedNodeBuilder.StreamNested<AstConnectNodeBuilder> addDisconnectedEvent() {
        return new AstDisconnectedNodeBuilder.StreamNested<AstConnectNodeBuilder>(this);
    }

    @Override
    public AstUnboundNodeBuilder.StreamNested<AstConnectNodeBuilder> addUnboundEvent() {
        return new AstUnboundNodeBuilder.StreamNested<AstConnectNodeBuilder>(this);
    }

    @Override
    public AstClosedNodeBuilder.StreamNested<AstConnectNodeBuilder> addClosedEvent() {
        return new AstClosedNodeBuilder.StreamNested<AstConnectNodeBuilder>(this);
    }

    @Override
    public AstWriteNodeBuilder.StreamNested<AstConnectNodeBuilder> addWriteCommand() {
        return new AstWriteNodeBuilder.StreamNested<AstConnectNodeBuilder>(this);
    }

    @Override
    public AstDisconnectNodeBuilder.StreamNested<AstConnectNodeBuilder> addDisconnectCommand() {
        return new AstDisconnectNodeBuilder.StreamNested<AstConnectNodeBuilder>(this);
    }

    @Override
    public AstUnbindNodeBuilder.StreamNested<AstConnectNodeBuilder> addUnbindCommand() {
        return new AstUnbindNodeBuilder.StreamNested<AstConnectNodeBuilder>(this);
    }

    @Override
    public AstCloseNodeBuilder.StreamNested<AstConnectNodeBuilder> addCloseCommand() {
        return new AstCloseNodeBuilder.StreamNested<AstConnectNodeBuilder>(this);
    }

    @Override
    public AstReadAwaitNodeBuilder.StreamNested<AstConnectNodeBuilder> addReadAwaitBarrier() {
        return new AstReadAwaitNodeBuilder.StreamNested<AstConnectNodeBuilder>(this);
    }

    @Override
    public AstReadNotifyNodeBuilder.StreamNested<AstConnectNodeBuilder> addReadNotifyBarrier() {
        return new AstReadNotifyNodeBuilder.StreamNested<AstConnectNodeBuilder>(this);
    }

    @Override
    public AstWriteAwaitNodeBuilder.StreamNested<AstConnectNodeBuilder> addWriteAwaitBarrier() {
        return new AstWriteAwaitNodeBuilder.StreamNested<AstConnectNodeBuilder>(this);
    }

    @Override
    public AstWriteNotifyNodeBuilder.StreamNested<AstConnectNodeBuilder> addWriteNotifyBarrier() {
        return new AstWriteNotifyNodeBuilder.StreamNested<AstConnectNodeBuilder>(this);
    }

    @Override
    public AstReadOptionNodeBuilder.StreamNested<AstConnectNodeBuilder> addReadOption() {
        return new AstReadOptionNodeBuilder.StreamNested<AstConnectNodeBuilder>(this);
    }

    @Override
    public AstWriteOptionNodeBuilder.StreamNested<AstConnectNodeBuilder> addWriteOption() {
        return new AstWriteOptionNodeBuilder.StreamNested<AstConnectNodeBuilder>(this);
    }

    // Http
    @Override
    public AstReadHttpHeaderNodeBuilder.StreamNested<AstConnectNodeBuilder> addReadHttpHeaderEvent() {
        return new AstReadHttpHeaderNodeBuilder.StreamNested<AstConnectNodeBuilder>(this);
    }

    @Override
    public AstWriteHttpHeaderNodeBuilder.StreamNested<AstConnectNodeBuilder> addWriteHttpHeaderCommand() {
        return new AstWriteHttpHeaderNodeBuilder.StreamNested<AstConnectNodeBuilder>(this);
    }

    @Override
    public AstWriteHttpContentLengthNodeBuilder.StreamNested<AstConnectNodeBuilder> addWriteHttpContentLengthCommand() {
        return new AstWriteHttpContentLengthNodeBuilder.StreamNested<AstConnectNodeBuilder>(this);
    }

    @Override
    public AstReadHttpMethodNodeBuilder.StreamNested<AstConnectNodeBuilder> addReadHttpMethodEvent() {
        return new AstReadHttpMethodNodeBuilder.StreamNested<AstConnectNodeBuilder>(this);
    }

    @Override
    public AstWriteHttpMethodNodeBuilder.StreamNested<AstConnectNodeBuilder> addWriteHttpMethodCommand() {
        return new AstWriteHttpMethodNodeBuilder.StreamNested<AstConnectNodeBuilder>(this);
    }

    @Override
    public AstReadHttpParameterNodeBuilder.StreamNested<AstConnectNodeBuilder> addReadHttpParameterEvent() {
        return new AstReadHttpParameterNodeBuilder.StreamNested<AstConnectNodeBuilder>(this);
    }

    @Override
    public AstWriteHttpParameterNodeBuilder.StreamNested<AstConnectNodeBuilder> addWriteHttpParameterCommand() {
        return new AstWriteHttpParameterNodeBuilder.StreamNested<AstConnectNodeBuilder>(this);
    }

    @Override
    public AstReadHttpVersionNodeBuilder.StreamNested<AstConnectNodeBuilder> addReadHttpVersionEvent() {
        return new AstReadHttpVersionNodeBuilder.StreamNested<AstConnectNodeBuilder>(this);
    }

    @Override
    public AstWriteHttpVersionNodeBuilder.StreamNested<AstConnectNodeBuilder> addWriteHttpVersionCommand() {
        return new AstWriteHttpVersionNodeBuilder.StreamNested<AstConnectNodeBuilder>(this);
    }

    @Override
    public AstReadHttpStatusNodeBuilder.StreamNested<AstConnectNodeBuilder> addReadHttpStatusEvent() {
        return new AstReadHttpStatusNodeBuilder.StreamNested<AstConnectNodeBuilder>(this);
    }

    @Override
    public AstWriteHttpStatusNodeBuilder.StreamNested<AstConnectNodeBuilder> addWriteHttpStatusCommand() {
        return new AstWriteHttpStatusNodeBuilder.StreamNested<AstConnectNodeBuilder>(this);
    }

    @Override
    public AstReadClosedNodeBuilder.StreamNested<AstConnectNodeBuilder> addReadCloseCommand() {
        return new AstReadClosedNodeBuilder.StreamNested<AstConnectNodeBuilder>(this);
    }

    @Override
    public AstWriteCloseNodeBuilder.StreamNested<AstConnectNodeBuilder> addWriteCloseCommand() {
        return new AstWriteCloseNodeBuilder.StreamNested<AstConnectNodeBuilder>(this);
    }

    @Override
    public AstConnectNode done() {
        return result;
    }

    @Override
    protected int line() {
        return line;
    }

    @Override
    protected int line(int line) {
        this.line = line;
        return line;
    }

    private AstConnectNodeBuilder(AstConnectNode node) {
        super(node, node);
    }

    public static final class ScriptNested<R extends AbstractAstNodeBuilder<? extends AstScriptNode, ?>> extends
            AbstractAstConnectNodeBuilder<R> {

        public ScriptNested(R builder) {
            super(new AstConnectNode(), builder);
        }

        @Override
        public ScriptNested<R> setLocationInfo(int line, int column) {
            node.setLocationInfo(line, column);
            internalSetLineInfo(line);
            return this;
        }

        @Override
        public ScriptNested<R> setNextLineInfo(int linesToSkip, int column) {
            internalSetNextLineInfo(linesToSkip, column);
            return this;
        }

        public ScriptNested<R> setLocation(URI location) {
            node.setLocation(location);
            return this;
        }

        @Override
        public AstOpenedNodeBuilder.StreamNested<ScriptNested<R>> addOpenedEvent() {
            return new AstOpenedNodeBuilder.StreamNested<ScriptNested<R>>(this);
        }

        @Override
        public AstBoundNodeBuilder.StreamNested<ScriptNested<R>> addBoundEvent() {
            return new AstBoundNodeBuilder.StreamNested<ScriptNested<R>>(this);
        }

        @Override
        public AstConnectedNodeBuilder.StreamNested<ScriptNested<R>> addConnectedEvent() {
            return new AstConnectedNodeBuilder.StreamNested<ScriptNested<R>>(this);
        }

        @Override
        public AstReadNodeBuilder.StreamNested<ScriptNested<R>> addReadEvent() {
            return new AstReadNodeBuilder.StreamNested<ScriptNested<R>>(this);
        }

        @Override
        public AstDisconnectedNodeBuilder.StreamNested<ScriptNested<R>> addDisconnectedEvent() {
            return new AstDisconnectedNodeBuilder.StreamNested<ScriptNested<R>>(this);
        }

        @Override
        public AstUnboundNodeBuilder.StreamNested<ScriptNested<R>> addUnboundEvent() {
            return new AstUnboundNodeBuilder.StreamNested<ScriptNested<R>>(this);
        }

        @Override
        public AstClosedNodeBuilder.StreamNested<ScriptNested<R>> addClosedEvent() {
            return new AstClosedNodeBuilder.StreamNested<ScriptNested<R>>(this);
        }

        @Override
        public AstWriteNodeBuilder.StreamNested<ScriptNested<R>> addWriteCommand() {
            return new AstWriteNodeBuilder.StreamNested<ScriptNested<R>>(this);
        }

        @Override
        public AstDisconnectNodeBuilder.StreamNested<ScriptNested<R>> addDisconnectCommand() {
            return new AstDisconnectNodeBuilder.StreamNested<ScriptNested<R>>(this);
        }

        @Override
        public AstUnbindNodeBuilder.StreamNested<ScriptNested<R>> addUnbindCommand() {
            return new AstUnbindNodeBuilder.StreamNested<ScriptNested<R>>(this);
        }

        @Override
        public AstCloseNodeBuilder.StreamNested<ScriptNested<R>> addCloseCommand() {
            return new AstCloseNodeBuilder.StreamNested<ScriptNested<R>>(this);
        }

        @Override
        public AstReadAwaitNodeBuilder.StreamNested<ScriptNested<R>> addReadAwaitBarrier() {
            return new AstReadAwaitNodeBuilder.StreamNested<ScriptNested<R>>(this);
        }

        @Override
        public AstReadNotifyNodeBuilder.StreamNested<ScriptNested<R>> addReadNotifyBarrier() {
            return new AstReadNotifyNodeBuilder.StreamNested<ScriptNested<R>>(this);
        }

        @Override
        public AstWriteAwaitNodeBuilder.StreamNested<ScriptNested<R>> addWriteAwaitBarrier() {
            return new AstWriteAwaitNodeBuilder.StreamNested<ScriptNested<R>>(this);
        }

        @Override
        public AstWriteNotifyNodeBuilder.StreamNested<ScriptNested<R>> addWriteNotifyBarrier() {
            return new AstWriteNotifyNodeBuilder.StreamNested<ScriptNested<R>>(this);
        }

        @Override
        public AstReadHttpHeaderNodeBuilder.StreamNested<ScriptNested<R>> addReadHttpHeaderEvent() {
            return new AstReadHttpHeaderNodeBuilder.StreamNested<ScriptNested<R>>(this);
        }

        @Override
        public AstWriteHttpHeaderNodeBuilder.StreamNested<ScriptNested<R>> addWriteHttpHeaderCommand() {
            return new AstWriteHttpHeaderNodeBuilder.StreamNested<ScriptNested<R>>(this);
        }

        @Override
        public AstWriteHttpContentLengthNodeBuilder.StreamNested<ScriptNested<R>> addWriteHttpContentLengthCommand() {
            return new AstWriteHttpContentLengthNodeBuilder.StreamNested<ScriptNested<R>>(this);
        }

        @Override
        public AstReadHttpMethodNodeBuilder.StreamNested<ScriptNested<R>> addReadHttpMethodEvent() {
            return new AstReadHttpMethodNodeBuilder.StreamNested<ScriptNested<R>>(this);
        }

        @Override
        public AstWriteHttpMethodNodeBuilder.StreamNested<ScriptNested<R>> addWriteHttpMethodCommand() {
            return new AstWriteHttpMethodNodeBuilder.StreamNested<ScriptNested<R>>(this);
        }

        @Override
        public AstReadHttpParameterNodeBuilder.StreamNested<ScriptNested<R>> addReadHttpParameterEvent() {
            return new AstReadHttpParameterNodeBuilder.StreamNested<ScriptNested<R>>(this);
        }

        @Override
        public AstWriteHttpParameterNodeBuilder.StreamNested<ScriptNested<R>> addWriteHttpParameterCommand() {
            return new AstWriteHttpParameterNodeBuilder.StreamNested<ScriptNested<R>>(this);
        }

        @Override
        public AstReadHttpVersionNodeBuilder.StreamNested<ScriptNested<R>> addReadHttpVersionEvent() {
            return new AstReadHttpVersionNodeBuilder.StreamNested<ScriptNested<R>>(this);
        }

        @Override
        public AstWriteHttpVersionNodeBuilder.StreamNested<ScriptNested<R>> addWriteHttpVersionCommand() {
            return new AstWriteHttpVersionNodeBuilder.StreamNested<ScriptNested<R>>(this);
        }

        @Override
        public AstReadHttpStatusNodeBuilder.StreamNested<ScriptNested<R>> addReadHttpStatusEvent() {
            return new AstReadHttpStatusNodeBuilder.StreamNested<ScriptNested<R>>(this);
        }

        @Override
        public AstWriteHttpStatusNodeBuilder.StreamNested<ScriptNested<R>> addWriteHttpStatusCommand() {
            return new AstWriteHttpStatusNodeBuilder.StreamNested<ScriptNested<R>>(this);
        }

        @Override
        public AstReadClosedNodeBuilder.StreamNested<ScriptNested<R>> addReadCloseCommand() {
            return new AstReadClosedNodeBuilder.StreamNested<ScriptNested<R>>(this);
        }

        @Override
        public AstWriteCloseNodeBuilder.StreamNested<ScriptNested<R>> addWriteCloseCommand() {
            return new AstWriteCloseNodeBuilder.StreamNested<ScriptNested<R>>(this);
        }

        @Override
        public AstReadOptionNodeBuilder.StreamNested<ScriptNested<R>> addReadOption() {
            return new AstReadOptionNodeBuilder.StreamNested<ScriptNested<R>>(this);
        }

        @Override
        public AstWriteOptionNodeBuilder.StreamNested<ScriptNested<R>> addWriteOption() {
            return new AstWriteOptionNodeBuilder.StreamNested<ScriptNested<R>>(this);
        }

        @Override
        public R done() {
            AstScriptNode scriptNode = result.node;
            scriptNode.getStreams().add(node);
            return result;
        }

        @Override
        protected int line() {
            return result.line();
        }

        @Override
        protected int line(int line) {
            return result.line(line);
        }

    }

}
