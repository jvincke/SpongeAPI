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
package org.spongepowered.api;

import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.data.ImmutableDataRegistry;
import org.spongepowered.api.data.manipulator.DataManipulatorRegistry;
import org.spongepowered.api.data.value.ValueFactory;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.recipe.RecipeRegistry;
import org.spongepowered.api.resourcepack.ResourcePack;
import org.spongepowered.api.scoreboard.displayslot.DisplaySlot;
import org.spongepowered.api.statistic.BlockStatistic;
import org.spongepowered.api.statistic.EntityStatistic;
import org.spongepowered.api.statistic.ItemStatistic;
import org.spongepowered.api.statistic.Statistic;
import org.spongepowered.api.statistic.StatisticGroup;
import org.spongepowered.api.statistic.TeamStatistic;
import org.spongepowered.api.status.Favicon;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.translation.Translation;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.util.rotation.Rotation;
import org.spongepowered.api.world.extent.ExtentBufferFactory;
import org.spongepowered.api.world.gen.GeneratorPopulator;
import org.spongepowered.api.world.gen.Populator;
import org.spongepowered.api.world.gen.PopulatorFactory;
import org.spongepowered.api.world.gen.WorldGeneratorModifier;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * Provides an easy way to retrieve types from a {@link Game}.
 *
 * <p>Note that the registries may be in flux, especially during game
 * initialization. These will be accurate for the time they are called, however
 * they may change at a later point. Do not assume that the contents of a collection
 * will be all the entries that will exist.</p>
 *
 * <p>Some of the returned instances my become incorrect if they are later
 * overwritten. However, this should occur prior to
 * {@link GameState#POST_INITIALIZATION}.</p>
 */
public interface GameRegistry {

    /**
     * Attempts to retrieve the specific type of {@link CatalogType} based on
     * the string id given.
     *
     * <p>Some types may not be available for various reasons including but not
     * restricted to: mods adding custom types, plugins providing custom types,
     * game version changes.</p>
     *
     * @param typeClass The class of the type of {@link CatalogType}
     * @param id The string id of the catalog type
     * @param <T> The type of catalog type
     * @return The found catalog type, if available
     */
    <T extends CatalogType> Optional<T> getType(Class<T> typeClass, String id);

    /**
     * Gets a collection of all available found specific types of
     * {@link CatalogType} requested.
     *
     * <p>The presented {@link CatalogType}s may not exist in default catalogs
     * due to various reasons including but not restricted to: mods, plugins,
     * game changes.</p>
     *
     * @param typeClass The class of {@link CatalogType}
     * @param <T> The type of {@link CatalogType}
     * @return A collection of all known types of the requested catalog type
     */
    <T extends CatalogType> Collection<T> getAllOf(Class<T> typeClass);

    /**
     * Gets a builder of the desired class type, examples may include:
     * {@link org.spongepowered.api.item.inventory.ItemStack.Builder}, etc.
     *
     * @param builderClass The class of the builder
     * @param <T> The type of builder
     * @return The builder, if available
     * @throws IllegalArgumentException If there is no supplier for the given builder class
     */
    <T extends ResettableBuilder<? super T>> T createBuilder(Class<T> builderClass) throws IllegalArgumentException;

    /**
     * Gets a {@link Collection} of the default GameRules.
     *
     * @return The default GameRules.
     */
    Collection<String> getDefaultGameRules();

    /**
     * Gets the {@link Statistic} for the given {@link StatisticGroup} and
     * {@link EntityType}. If the statistic group is not a valid
     * {@link EntityStatistic} group then {@link Optional#empty()} will be
     * returned.
     *
     * @param statisticGroup The type of statistic to return
     * @param entityType The entity type for the statistic to return
     * @return The entity statistic or Optional.empty() if not found
     */
    Optional<EntityStatistic> getEntityStatistic(StatisticGroup statisticGroup, EntityType entityType);

    /**
     * Gets the {@link Statistic} for the given {@link StatisticGroup} and
     * {@link ItemType}. If the statistic group is not a valid
     * {@link ItemStatistic} group then {@link Optional#empty()} will be
     * returned.
     *
     * @param statisticGroup The type of statistic to return
     * @param itemType The item type for the statistic to return
     * @return The item statistic or Optional.empty() if not found
     */
    Optional<ItemStatistic> getItemStatistic(StatisticGroup statisticGroup, ItemType itemType);

    /**
     * Gets the {@link Statistic} for the given {@link StatisticGroup} and
     * {@link BlockType}. If the statistic group is not a valid
     * {@link BlockStatistic} group then {@link Optional#empty()} will be
     * returned.
     *
     * @param statisticGroup The type of statistic to return
     * @param blockType The block type for the statistic to return
     * @return The block statistic or Optional.empty() if not found
     */
    Optional<BlockStatistic> getBlockStatistic(StatisticGroup statisticGroup, BlockType blockType);

    /**
     * Gets the {@link Statistic} for the given {@link StatisticGroup} and
     * team's {@link TextColor}. If the {@link StatisticGroup} is not a valid
     * {@link TeamStatistic} group then {@link Optional#empty()} will be
     * returned.
     *
     * @param statisticGroup The type of statistic to return
     * @param teamColor The team's color for the statistic to return
     * @return The team statistic or Optional.empty() if not found
     */
    Optional<TeamStatistic> getTeamStatistic(StatisticGroup statisticGroup, TextColor teamColor);

    /**
     * Gets a list of all available {@link Statistic}s which belong to the given
     * {@link StatisticGroup}.
     *
     * @param statisticGroup The statisticType to return
     * @return An immutable collection containing all statistics in the group
     */
    Collection<Statistic> getStatistics(StatisticGroup statisticGroup);

    /**
     * Registers a custom statistic.
     *
     * @param stat The custom statistic
     */
    void registerStatistic(Statistic stat);

    /**
     * Gets the {@link Rotation} with the provided degrees.
     *
     * @param degrees The degrees of the rotation
     * @return The {@link Rotation} with the given degrees or Optional.empty() if not found
     */
    Optional<Rotation> getRotationFromDegree(int degrees);

    /**
     * Creates a new {@link GameProfile} using the specified unique identifier and name.
     *
     * @param uuid The unique identifier for the profile
     * @param name The name for the profile
     * @return The created profile
     */
    GameProfile createGameProfile(UUID uuid, String name);

    /**
     * Loads a {@link Favicon} from the specified encoded string. The format of
     * the input depends on the implementation.
     *
     * @param raw The encoded favicon
     * @return The loaded favicon
     * @throws IOException If the favicon couldn't be loaded
     */
    Favicon loadFavicon(String raw) throws IOException;

    /**
     * Loads a favicon from a specified {@link Path}.
     *
     * @param path The path to the favicon
     * @return The loaded favicon from the file
     * @throws IOException If the favicon couldn't be loaded
     * @throws FileNotFoundException If the file doesn't exist
     */
    Favicon loadFavicon(Path path) throws IOException;

    /**
     * Loads a favicon from a specified {@link URL}.
     *
     * @param url The favicon URL
     * @return The loaded favicon from the URL
     * @throws IOException If the favicon couldn't be loaded
     */
    Favicon loadFavicon(URL url) throws IOException;

    /**
     * Loads a favicon from a specified {@link InputStream}.
     *
     * @param in The favicon input stream
     * @return The loaded favicon from the input stream
     * @throws IOException If the favicon couldn't be loaded
     */
    Favicon loadFavicon(InputStream in) throws IOException;

    /**
     * Loads a favicon from a specified {@link BufferedImage}.
     *
     * @param image The favicon image
     * @return The loaded favicon from the image
     * @throws IOException If the favicon couldn't be loaded
     */
    Favicon loadFavicon(BufferedImage image) throws IOException;

    /**
     * Retrieves the RecipeRegistry for this GameRegistry.
     *
     * @return The recipe registry
     */
    RecipeRegistry getRecipeRegistry();

    /**
     * Gets a {@link ResourcePack} that's already been created by its ID.
     *
     * @param id The ID of the pack
     * @return The ResourcePack with the specified ID, or Optional.empty() if
     *         none could be found
     */
    Optional<ResourcePack> getResourcePackById(String id);

    /**
     * Gets a {@link DisplaySlot} which displays only for teams
     * with the provided color.
     *
     * @param color The color for the display slot
     * @return The {@link DisplaySlot} with the provided color, or Optional.empty() if not found
     */
    Optional<DisplaySlot> getDisplaySlotForColor(TextColor color);

    /**
     * Registers a {@link WorldGeneratorModifier}, so that the server is able to
     * use it for modifying the world generator of a new world.
     *
     * @param modifier The modifier to register
     */
    void registerWorldGeneratorModifier(WorldGeneratorModifier modifier);

    /**
     * Gets the {@link PopulatorFactory} for creating {@link Populator}s and
     * {@link GeneratorPopulator}s.
     *
     * @return The populator factory
     */
    PopulatorFactory getPopulatorFactory();

    /**
     * Gets the {@link ExtentBufferFactory} for creating buffers
     * to store extent data.
     *
     * @return The extent buffer factory
     */
    ExtentBufferFactory getExtentBufferFactory();

    /**
     * Gets the {@link ValueFactory} for creating values.
     *
     * @return The value factory
     */
    ValueFactory getValueFactory();

    /**
     * Gets the {@link Translation} with the provided ID.
     *
     * @param id The ID of the translation
     * @return The {@link Translation} with the given ID or Optional.empty() if not found
     */
    Optional<Translation> getTranslationById(String id);

}
