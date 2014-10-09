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

package org.kaazing.robot.driver.behavior.handler.event.http;

import static org.jboss.netty.buffer.ChannelBuffers.copiedBuffer;
import static org.jboss.netty.util.CharsetUtil.UTF_8;

import java.util.Iterator;
import java.util.List;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.http.HttpHeaders;
import org.kaazing.robot.driver.behavior.handler.codec.MessageDecoder;
import org.kaazing.robot.driver.behavior.handler.codec.MessageMismatchException;
import org.kaazing.robot.driver.behavior.handler.command.AbstractCommandHandler;
import org.kaazing.robot.driver.netty.bootstrap.http.HttpChannelConfig;

public class ReadHttpHeaderHandler extends AbstractCommandHandler {

    private String name;
    private MessageDecoder valueDecoder;

    public ReadHttpHeaderHandler(String name, MessageDecoder valueDecoder) {
        this.name = name;
        this.valueDecoder = valueDecoder;
    }

    @Override
    protected void invokeCommand(ChannelHandlerContext ctx) throws Exception {
        HttpChannelConfig httpConfig = (HttpChannelConfig) ctx.getChannel().getConfig();
        HttpHeaders headers = httpConfig.getReadHeaders();
        List<String> headerValues = headers.getAll(name);
        int headerValueCount = headerValues.size();
        if (headerValueCount == 0) {
            throw new MessageMismatchException("Missing HTTP header", name, null);
        }
        else if (headerValueCount == 1) {
            // efficiently handle single-valued HTTP header
            try {
                String headerValue = headerValues.get(0);
                valueDecoder.decode(copiedBuffer(headerValue, UTF_8));
                getHandlerFuture().setSuccess();
            }
            catch (Exception e) {
                getHandlerFuture().setFailure(e);
            }
        }
        else {
            // attempt to match each HTTP header value with decoder
            // throw last decode failure exception if none match
            Exception decodeFailure = null;
            for (Iterator<String> $i = headerValues.iterator(); $i.hasNext();) {
                String headerValue = $i.next();
                try {
                    valueDecoder.decode(copiedBuffer(headerValue, UTF_8));
                    $i.remove();
                    break;
                }
                catch (Exception e) {
                    decodeFailure = e;
                }
            }

            if (headerValues.size() != headerValueCount) {
                headers.set(name, headerValues);
            }
            else {
                assert decodeFailure != null;
                throw decodeFailure;
            }
        }
    }

}
