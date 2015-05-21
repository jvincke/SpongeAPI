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
package org.spongepowered.api.world.gen.populator;

import org.spongepowered.api.util.weighted.VariableAmount;
import org.spongepowered.api.world.gen.Populator;

/**
 * Represents a populator which spawns clusters of glowstone.
 */
public interface Glowstone extends Populator {

    /**
     * Gets the number of clusters to attempt to spawn per chunk, must be
     * greater than zero.
     * 
     * @return The number to spawn
     */
    VariableAmount getClustersPerChunk();

    /**
     * Sets the number of clusters to attempt to spawn per chunk, must be
     * greater than zero.
     * 
     * @param count The new amount to spawn
     */
    void setClustersPerChunk(VariableAmount count);

    /**
     * Sets the number of clusters to attempt to spawn per chunk, must be
     * greater than zero.
     * 
     * @param count The new amount to spawn
     */
    default void setClustersPerChunk(int count) {
        setClustersPerChunk(VariableAmount.fixed(count));
    }

    /**
     * Gets the amount of glowstone to attempt to spawn per cluster, must be
     * greater than zero.
     * 
     * @return The number to spawn
     */
    VariableAmount getAttemptsPerCluster();

    /**
     * Sets the amount of glowstone to attempt to spawn per cluster, must be
     * greater than zero.
     * 
     * @param attempts The new amount to spawn
     */
    void setAttemptsPerCluster(VariableAmount attempts);

    /**
     * Sets the amount of glowstone to attempt to spawn per cluster, must be
     * greater than zero.
     * 
     * @param attempts The new amount to spawn
     */
    default void setAttemptsPerCluster(int attempts) {
        setAttemptsPerCluster(VariableAmount.fixed(attempts));
    }

    /**
     * Gets the height of the glowstone cluster.
     * 
     * @return The height
     */
    VariableAmount getHeight();

    /**
     * Sets the height of the glowstone cluster.
     * 
     * @param height The new height
     */
    void setHeight(VariableAmount height);

    /**
     * Sets the height of the glowstone cluster.
     * 
     * @param height The new height
     */
    default void setHeight(int height) {
        setHeight(VariableAmount.fixed(height));
    }

    /**
     * A builder for constructing {@link Glowstone} populators.
     */
    interface Builder {

        /**
         * Sets the number of clusters to attempt to spawn per chunk, must be
         * greater than zero.
         * 
         * @param count The new amount to spawn
         * @return This builder, for chaining
         */
        Builder perChunk(VariableAmount count);

        /**
         * Sets the number of clusters to attempt to spawn per chunk, must be
         * greater than zero.
         * 
         * @param count The new amount to spawn
         * @return This builder, for chaining
         */
        default Builder perChunk(int count) {
            return perChunk(VariableAmount.fixed(count));
        }

        /**
         * Sets the amount of glowstone to attempt to spawn per cluster, must be
         * greater than zero.
         * 
         * @param attempts The new amount to spawn
         * @return This builder, for chaining
         */
        Builder blocksPerCluster(VariableAmount attempts);

        /**
         * Sets the amount of glowstone to attempt to spawn per cluster, must be
         * greater than zero.
         * 
         * @param attempts The new amount to spawn
         * @return This builder, for chaining
         */
        default Builder blocksPerCluster(int attempts) {
            return blocksPerCluster(VariableAmount.fixed(attempts));
        }

        /**
         * Sets the height of the glowstone cluster.
         * 
         * @param height The new height
         * @return This builder, for chaining
         */
        Builder height(VariableAmount height);

        /**
         * Sets the height of the glowstone cluster.
         * 
         * @param height The new height
         * @return This builder, for chaining
         */
        default Builder height(int height) {
            return height(VariableAmount.fixed(height));
        }

        /**
         * Resets this builder to the default values.
         * 
         * @return This builder, for chaining
         */
        Builder reset();

        /**
         * Builds a new instance of a {@link Glowstone} populator with the
         * settings set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *         which do not have default values
         */
        Glowstone build() throws IllegalStateException;

    }

}
