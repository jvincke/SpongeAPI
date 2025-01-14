/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.util.command;

import org.spongepowered.api.service.permission.Subject;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.sink.MessageSink;

/**
 * Something that can execute commands.
 *
 * <p>Examples of potential implementations include players, the server console,
 * Rcon clients, web-based clients, command blocks, and so on.</p>
 */
public interface CommandSource extends Subject {

    /**
     * Gets the name identifying this command source.
     *
     * @return The name of this command source
     */
    String getName();

    /**
     * Sends the formatted text message to source when possible. If text formatting
     * is not supported in the implementation it will be displayed as plain text.
     *
     * @param message The message
     */
    void sendMessage(Text message);

    /**
     * Sends the formatted text message(s) to source when possible. If text formatting
     * is not supported in the implementation it will be displayed as plain text.
     *
     * @param messages The message(s)
     */
    void sendMessages(Text... messages);

    /**
     * Sends the formatted text message(s) to source when possible. If text formatting
     * is not supported in the implementation it will be displayed as plain text.
     *
     * @param messages The messages
     */
    void sendMessages(Iterable<Text> messages);

    /**
     * Return the message sink that messages from this source should be broadcast to.
     *
     * @return This source's active message sink
     */
    MessageSink getMessageSink();

    /**
     * Set the message sink that messages sent by this source should be broadcast to.
     *
     * @param sink The message sink to broadcast messages to
     */
    void setMessageSink(MessageSink sink);
}
