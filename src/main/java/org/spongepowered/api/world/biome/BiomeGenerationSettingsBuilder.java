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
package org.spongepowered.api.world.biome;

import org.spongepowered.api.world.gen.GenerationPopulator;
import org.spongepowered.api.world.gen.Populator;

import java.util.Collection;

/**
 * A builder for creating {@link BiomeGenerationSettings}.
 */
public interface BiomeGenerationSettingsBuilder {

    /**
     * Sets the minimum terrain height of this biome.
     * 
     * @param height The new min height
     * @return This builder, for chaining
     */
    BiomeGenerationSettingsBuilder minHeight(float height);

    /**
     * Sets the maximum terrain height of this biome.
     * 
     * @param height The new max height
     * @return This builder, for chaining
     */
    BiomeGenerationSettingsBuilder maxHeight(float height);

    /**
     * Sets the {@link GroundCoverLayer}s for the biome.
     * 
     * @param layers The ground cover layers
     * @return This builder, for chaining
     */
    BiomeGenerationSettingsBuilder groundCoverLayers(GroundCoverLayer... layers);

    /**
     * Sets the {@link GroundCoverLayer}s for the biome.
     * 
     * @param layers The ground cover layers
     * @return This builder, for chaining
     */
    BiomeGenerationSettingsBuilder groundCoverLayers(Collection<GroundCoverLayer> layers);

    /**
     * Sets the {@link GenerationPopulator}s for the biome.
     * 
     * @param genpops The generator populators
     * @return This builder, for chaining
     */
    BiomeGenerationSettingsBuilder generationPopulators(GenerationPopulator... genpops);

    /**
     * Sets the {@link GenerationPopulator}s for the biome.
     * 
     * @param genpops The generator populators
     * @return This builder, for chaining
     */
    BiomeGenerationSettingsBuilder generationPopulators(Collection<GenerationPopulator> genpops);

    /**
     * Sets the {@link Populator}s for the biome.
     * 
     * @param pops The populators
     * @return This builder, for chaining
     */
    BiomeGenerationSettingsBuilder populators(Populator... pops);

    /**
     * Sets the {@link Populator}s for the biome.
     * 
     * @param pops The populators
     * @return This builder, for chaining
     */
    BiomeGenerationSettingsBuilder populators(Collection<Populator> pops);

    /**
     * Resets this builder to the default settings.
     * 
     * @return This builder, for chaining
     */
    BiomeGenerationSettingsBuilder reset();

    /**
     * Resets this builder to the settings of the given {@link BiomeGenerationSettings}.
     * 
     * @param type The settings to match
     * @return This builder, for chaining
     */
    BiomeGenerationSettingsBuilder reset(BiomeGenerationSettings type);

    /**
     * Builds the {@link BiomeGenerationSettings} specified by this builder.
     * 
     * @return The biome generation settings
     * @throws IllegalArgumentException If there are any unfulfilled arguments
     */
    BiomeGenerationSettings build() throws IllegalArgumentException;

}
