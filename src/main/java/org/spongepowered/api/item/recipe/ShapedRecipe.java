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
package org.spongepowered.api.item.recipe;

import com.flowpowered.math.vector.Vector2i;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Optional;

import javax.annotation.Nullable;

/**
 * A ShapedRecipe is a Recipe that has shape and fits into a grid.
 */
public interface ShapedRecipe extends Recipe {

    /**
     * Gets the width of the grid this ShapedRecipe fits into.
     *
     * @return The width of the grid
     */
    int getWidth();

    /**
     * Gets the height of the grid this ShapedRecipe fits into.
     *
     * @return The height of the grid
     */
    int getHeight();

    /**
     * Gets the ingredient required in the given coordinates.
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @return The ingredient
     */
    Optional<ItemStack> getIngredient(int x, int y);

    /**
     * Gets the ingredient required in the given position.
     *
     * @param pos The position
     * @return The ingredient
     */
    Optional<ItemStack> getIngredient(Vector2i pos);

    interface Builder extends ResettableBuilder<Builder> {
        /**
         * Sets the width of the grid for the ShapedRecipe.
         *
         * @param width The width of the grid
         * @return fluent interface
         */
        Builder width(int width);

        /**
         * Sets the height of the grid for the ShapedRecipe.
         *
         * @param height The height of the grid
         * @return fluent interface
         */
        Builder height(int height);

        /**
         * Sets the dimensions of the grid for the ShapedRecipe in one method call.
         *
         * @param dimensions The dimensions of the grid
         * @return fluent interface
         */
        Builder dimensions(Vector2i dimensions);

        /**
         * Sets the ingredient required by the recipe in the given coordinates.
         *
         * @param x The x coordinate
         * @param y The y coordinate
         * @param ingredient The ingredient to set, or remove if null
         * @return fluent interface
         */
        Builder ingredient(int x, int y, @Nullable ItemStack ingredient);

        /**
         * Sets the ingredient required by the recipe in the given position.
         *
         * @param pos The position
         * @param ingredient The ingredient to set, or remove if null
         * @return fluent interface
         */
        Builder ingredient(Vector2i pos, @Nullable ItemStack ingredient);

        /**
         * Sets the ingredients required by the recipe in the given row.
         *
         * @param row The number of the row
         * @param ingredients A list of ItemStacks to set as ingredients. If one
         *                    of them is null the ingredient in that position is
         *                    not added.
         * @return fluent interface
         */
        Builder row(int row, ItemStack... ingredients);

        /**
         * Adds a resultant ItemStack for when this ShapedRecipe is correctly
         * crafted.
         *
         * @param result The result
         * @return fluent interface
         */
        Builder addResult(ItemStack result);

        /**
         * Builds a ShapedRecipe from this builder.
         *
         * @return A new ShapedRecipe
         */
        ShapedRecipe build();        
    }
}
