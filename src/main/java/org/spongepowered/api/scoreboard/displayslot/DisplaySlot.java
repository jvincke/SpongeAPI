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
package org.spongepowered.api.scoreboard.displayslot;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.scoreboard.Team;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.Optional;

/**
 * Represents an area to display an objective.
 */
@CatalogedBy(DisplaySlots.class)
public interface DisplaySlot extends CatalogType {

    /**
     * Gets the {@link Team} color that this objective will display for, if set.
     *
     * @return The {@link Team} color that this objective will display for, if set
     */
    Optional<TextColor> getTeamColor();

    interface Builder extends ResettableBuilder<Builder> {

        /**
         * Sets the {@link TextColor} of the display slot.
         *
         * @param color The color to set
         * @return This builder
         */
        Builder sidebarTeamColor(TextColor color);

        /**
         * Builds an instance of a {@link DisplaySlot}.
         *
         * @return A new instance of an {@link DisplaySlot}
         * @throws IllegalStateException if the {@link DisplaySlot} is not completed
         */
        DisplaySlot build() throws IllegalStateException;

    }
}
