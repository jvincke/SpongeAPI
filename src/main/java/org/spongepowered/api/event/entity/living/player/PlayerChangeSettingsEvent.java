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
package org.spongepowered.api.event.entity.living.player;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.chat.ChatTypes;

import java.util.Locale;

/**
 * Fired when A {@link Player} changes one or more of the following settings:
 *
 * <ul>
 *  <li>Locale</li>
 *  <li>View distance</li>
 *  <li>Chat visibility</li>
 *  <li>Chat colors</li>
 *  <li>Displayed skin parts</li>
 * </ul>
 */
public interface PlayerChangeSettingsEvent extends TargetPlayerEvent {

    /**
     * Gets the new locale of the player.
     *
     * @return The locale
     */
    Locale getLocale();

    /**
     * Gets the new view distance of the player.
     *
     * @return The view distance
     */
    int getViewDistance();

    /**
     * Gets the new chat visibility setting of the player.
     *
     * <p>
     *  1 = Full - All chat shown<br>
     *  2 = System - Only {@link ChatTypes#SYSTEM} is shown<br>
     *  3 = Hidden - Nothing
     * </p>
     *
     * @return The chat visibility setting
     */
    int getChatVisibility();

    /**
     * Gets whether the player has colors enabled in chat.
     *
     * @return True if colors are enabled in chat
     */
    boolean isColorsEnabled();

    /**
     * Gets the new skin part display settings.
     *
     * <p>Use bitwise operations to determine what parts are shown.<br>
     * <ul>
     *  <li>Bit 0: Cape enabled</li>
     *  <li>Bit 1: Jacket enabled</li>
     *  <li>Bit 2: Left Sleeve enabled</li>
     *  <li>Bit 3: Right Sleeve enabled</li>
     *  <li>Bit 4: Left Pants Leg enabled</li>
     *  <li>Bit 5: Right Pants Leg enabled</li>
     *  <li>Bit 6: Hat enabled</li>
     * </ul>
     * </p>
     *
     * @return The displayed skin parts
     */
    int getDisplayedSkinParts();

}
