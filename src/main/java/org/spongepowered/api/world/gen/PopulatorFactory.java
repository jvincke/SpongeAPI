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
package org.spongepowered.api.world.gen;

import org.spongepowered.api.world.gen.populator.BigMushroom;
import org.spongepowered.api.world.gen.populator.BlockBlob;
import org.spongepowered.api.world.gen.populator.Cactus;
import org.spongepowered.api.world.gen.populator.DeadBush;
import org.spongepowered.api.world.gen.populator.DesertWell;
import org.spongepowered.api.world.gen.populator.DoublePlant;
import org.spongepowered.api.world.gen.populator.Dungeon;
import org.spongepowered.api.world.gen.populator.EnderCrystalPlatform;
import org.spongepowered.api.world.gen.populator.Flower;
import org.spongepowered.api.world.gen.populator.Forest;
import org.spongepowered.api.world.gen.populator.Glowstone;
import org.spongepowered.api.world.gen.populator.IcePath;
import org.spongepowered.api.world.gen.populator.IceSpike;
import org.spongepowered.api.world.gen.populator.Lake;
import org.spongepowered.api.world.gen.populator.Melon;
import org.spongepowered.api.world.gen.populator.Mushroom;
import org.spongepowered.api.world.gen.populator.Ore;
import org.spongepowered.api.world.gen.populator.Pumpkin;
import org.spongepowered.api.world.gen.populator.RandomBlock;
import org.spongepowered.api.world.gen.populator.RandomObject;
import org.spongepowered.api.world.gen.populator.Reed;
import org.spongepowered.api.world.gen.populator.SeaFloor;
import org.spongepowered.api.world.gen.populator.Shrub;
import org.spongepowered.api.world.gen.populator.Vine;
import org.spongepowered.api.world.gen.populator.WaterLily;

/**
 * A factory for creating new populators for use in modifying WorldGenerators.
 */
public interface PopulatorFactory {

    /**
     * Creates a new {@link BigMushroom} populator builder.
     * 
     * @return A new builder instance
     */
    BigMushroom.Builder createBigMushroomPopulator();

    /**
     * Creates a new {@link BlockBlob} populator builder.
     * 
     * @return A new builder instance
     */
    BlockBlob.Builder createBlockBlockPopulator();

    /**
     * Creates a new {@link Cactus} populator builder.
     * 
     * @return A new builder instance
     */
    Cactus.Builder createCactusPopulator();

    /**
     * Creates a new {@link DesertWell} populator builder.
     * 
     * @return A new builder instance
     */
    DesertWell.Builder createDesertWellPopulator();

    /**
     * Creates a new {@link DeadBush} populator builder.
     * 
     * @return A new builder instance
     */
    DeadBush.Builder createDeadBushPopulator();

    /**
     * Creates a new {@link DoublePlant} populator builder.
     * 
     * @return A new builder instance
     */
    DoublePlant.Builder createDoublePlantPopulator();

    /**
     * Creates a new {@link Dungeon} populator builder.
     * 
     * @return A new builder instance
     */
    Dungeon.Builder createDungeonPopulator();

    /**
     * Creates a new {@link EnderCrystalPlatform} populator builder.
     * 
     * @return A new builder instance
     */
    EnderCrystalPlatform.Builder createEnderCrystalPlatformPopulator();

    /**
     * Creates a new {@link Flower} populator builder.
     * 
     * @return A new builder instance
     */
    Flower.Builder createFlowerPopulator();

    /**
     * Creates a new {@link Forest} populator builder.
     * 
     * @return A new builder instance
     */
    Forest.Builder createForestPopulator();

    /**
     * Creates a new {@link Glowstone} populator builder.
     * 
     * @return A new builder instance
     */
    Glowstone.Builder createGlowstonePopulator();

    /**
     * Creates a new {@link IcePath} populator builder.
     * 
     * @return A new builder instance
     */
    IcePath.Builder createIcePathPopulator();

    /**
     * Creates a new {@link IceSpike} populator builder.
     * 
     * @return A new builder instance
     */
    IceSpike.Builder createIceSpikePopulator();

    /**
     * Creates a new {@link Lake} populator builder.
     * 
     * @return A new builder instance
     */
    Lake.Builder createLakePopulator();

    /**
     * Creates a new {@link Melon} populator builder.
     * 
     * @return A new builder instance
     */
    Melon.Builder createMelonPopulator();

    /**
     * Creates a new {@link Mushroom} populator builder.
     * 
     * @return A new builder instance
     */
    Mushroom.Builder createMushroomPopulator();

    /**
     * Creates a new {@link Ore} populator builder.
     * 
     * @return A new builder instance
     */
    Ore.Builder createOrePopulator();

    /**
     * Creates a new {@link Pumpkin} populator builder.
     * 
     * @return A new builder instance
     */
    Pumpkin.Builder createPumpkinPopulator();

    /**
     * Creates a new {@link RandomBlock} populator builder.
     * 
     * @return A new builder instance
     */
    RandomBlock.Builder createRandomBlockPopulator();

    /**
     * Creates a new {@link RandomObject} populator builder.
     * 
     * @return A new builder instance
     */
    RandomObject.Builder createRandomObjectPopulator();

    /**
     * Creates a new {@link Reed} populator builder.
     * 
     * @return A new builder instance
     */
    Reed.Builder createReedPopulator();

    /**
     * Creates a new {@link SeaFloor} populator builder.
     * 
     * @return A new builder instance
     */
    SeaFloor.Builder createSeaFloorPopulator();

    /**
     * Creates a new {@link Shrub} populator builder.
     * 
     * @return A new builder instance
     */
    Shrub.Builder createShrubPopulator();

    /**
     * Creates a new {@link Vine} populator builder.
     * 
     * @return A new builder instance
     */
    Vine.Builder createVinePopulator();

    /**
     * Creates a new {@link WaterLily} populator builder.
     * 
     * @return A new builder instance
     */
    WaterLily.Builder createWaterLilyPopulator();

    PopulatorObject getDesertWellObject();
    
}
