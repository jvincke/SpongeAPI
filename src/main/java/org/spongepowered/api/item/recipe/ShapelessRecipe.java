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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Collection;

/**
 * A ShapelessRecipe is a Recipe that does not have shape and just has a
 * list of ingredients.
 */
public interface ShapelessRecipe extends Recipe {

    /**
     * Creates a new {@link Builder} to build a {@link ShapelessRecipe}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }


    /**
     * Gets the ingredients for this ShapelessRecipe.
     *
     * @return The ingredients
     */
    Collection<ItemStack> getIngredients();

    interface Builder extends ResettableBuilder<Builder> {
        /**
         * Adds an ingredient to the requirements of this ShapelessRecipe.
         *
         * @param ingredient The ingredient
         * @return fluent interface
         */
        Builder addIngredient(ItemStack ingredient);

        /**
         * Adds a resultant ItemStack for when this ShapelessRecipe is
         * correctly crafted.
         *
         * @param result The result
         * @return fluent interface
         */
        Builder addResult(ItemStack result);

        /**
         * Builds a new ShapelessRecipe from this builder.
         *
         * @return A new ShapelessRecipe
         */
        ShapelessRecipe build();        
    }
}
