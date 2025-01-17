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
package org.spongepowered.api.scoreboard;


import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Set;

/**
 * A team on a scoreboard that has a common display theme and other
 * properties.
 *
 * <p>A team is comprised of different members, represented by {@link Text} objects.
 * While any {@link Text} can be added to a team, certain {@link Text}s convey a special
 * meaning.</p>
 *
 * <p>Examples of this include players, whose names gain the prefix and suffix of
 * the team they are on.</p>
 */
public interface Team {

    /**
     * Creates a new {@link Builder} to build a {@link Team}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }


    /**
     * Gets the name of this team.
     *
     * @return The name of this team
     */
    String getName();

    /**
     * Gets the name displayed to users for this team.
     *
     * @return The display name for this team
     */
    Text getDisplayName();

    /**
     * Gets the color of this team.
     *
     * <p>The team's color is a distinct concept from its prefix or suffix.
     * It is only used for colored sidebar display slots, and certain statistic
     * criteria.</p>
     *
     * @return The team color
     */
    TextColor getColor();

    /**
     * Sets the color of this team.
     *
     * <p>The team's color is a distinct concept from its prefix or suffix.
     * It is only used for colored sidebar display slots, and certain statistic
     * criteria.</p>
     *
     * @param color The team color
     * @throws IllegalArgumentException If color is {@link TextColors#RESET}
     */
    void setColor(TextColor color) throws IllegalArgumentException;

    /**
     * Sets the name displayed to users for this team.
     *
     * @param displayName The {@link Text} to use
     * @throws IllegalArgumentException If displayName is longer than 32
     *     characters
     */
    void setDisplayName(Text displayName) throws IllegalArgumentException;

    /**
     * Gets the prefix prepended to the display name of users on this team.
     *
     * @return The prefix for this team
     */
    Text getPrefix();

    /**
     * Sets the prefix prepended to the display name of users on this team.
     *
     * @param prefix The new prefix for this team
     * @throws IllegalArgumentException If prefix is longer than 16
     *     characters
     */
    void setPrefix(Text prefix) throws IllegalArgumentException;

    /**
     * Gets the suffix appended to the display name of users on this team.
     *
     * @return The team's current suffix
     */
    Text getSuffix();

    /**
     * Sets the suffix appended to the display name of users on this team.
     *
     * @param suffix The new suffix for this team.
     * @throws IllegalArgumentException If suffix is longer than 16
     *     characters
     */
    void setSuffix(Text suffix) throws IllegalArgumentException;

    /**
     * Gets whether friendly fire is enabled.
     *
     * @return Whether friendly fire is enabled
     */
    boolean allowFriendlyFire();

    /**
     * Sets whether friendly fire is enabled.
     *
     * @param enabled Whether friendly fire is enabled
     */
    void setAllowFriendlyFire(boolean enabled);

    /**
     * Gets whether invisible team members are shown.
     *
     * @return Whether to show invisible team members
     */
    boolean canSeeFriendlyInvisibles();

    /**
     * Sets whether invisible team members are shown.
     *
     * @param enabled Whether to show invisible teammates
     */
    void setCanSeeFriendlyInvisibles(boolean enabled);

    /**
     * Gets the {@link Visibility} which controls to who nametags
     * of players on this team are visible to.
     *
     * @return The {@link Visibility} for this team's nametags
     */
    Visibility getNameTagVisibility();

    /**
     * Sets the {@link Visibility} which controls to who nametags
     * of players on this team are visible to.
     *
     * @param visibility The {@link Visibility} for this team's nametags
     */
    void setNameTagVisibility(Visibility visibility);

    /**
     * Gets the {@link Visibility} which controls who death Texts
     * for players on this team are visible to.
     *
     * @return The {@link Visibility} for this team's death Texts
     */
    Visibility getDeathTextVisibility();

    /**
     * Sets the {@link Visibility} which controls who death Texts
     * of players on this team are visible to.
     *
     * @param visibility The {@link Visibility} for this team's death Texts
     */
    void setDeathTextVisibility(Visibility visibility);

    /**
     * Gets the {@link Text}s representing the members of this team.
     *
     * @return the {@link Text}s for this team's members
     */
    Set<Text> getMembers();

    /**
     * Adds the specified {@link Text} to this team.
     *
     * <p>While any {@link Text} may be added, the {@link Text}
     * to use should normally be obtained by calling {@link TeamMember#getTeamRepresentation()}
     * on a {@link TeamMember}, such as a {@link Player}.</p>
     *
     * @param member the {@link Text} to add
     */
    void addMember(Text member);

    /**
     * Removes the specified {@link Text} from this team.
     *
     * <p>While any {@link Text} may be removed, the {@link Text}
     * to use should normally be obtained by calling {@link TeamMember#getTeamRepresentation()}
     * on a {@link TeamMember}, such as a {@link Player}.</p
     *
     * @param member The {@link Text} to remove
     * @return Whether the {@link Text} was on this team
     */
    boolean removeMember(Text member);

    /**
     * Returns a {@link Set} of parent {@link Scoreboard}s this {@link Team} is
     * registered to.
     *
     * @return A {@link Set} of parent {@link Scoreboard}s this {@link Team} is
     *         registered to
     */
    Set<Scoreboard> getScoreboards();

    /**
     * Represents a builder tp create {@link Team} instances.
     */
    interface Builder extends ResettableBuilder<Builder> {

        /**
         * Sets the name of the {@link Team}.
         *
         * @param name The name to set
         * @return This builder
         */
        Builder name(String name);

        /**
         * Sets the color of the {@link Team}.
         *
         * <p>The team's color is a distinct concept from its prefix or suffix.
         * It is only used for colored sidebar display slots, and certain statistic
         * criteria.</p>
         *
         * @param color The color to set
         * @return This builder
         * @throws IllegalArgumentException If color is {@link TextColors#RESET}
         */
        Builder color(TextColor color) throws IllegalArgumentException;

        /**
         * Sets the name displayed to users for the {@link Team}.
         *
         * <p>Display names may be truncated in order to meet an implementation-defined length limit.
         * In Vanilla, this is sixteen characters.</p>
         *
         * @param displayName The {@link Text} to set
         * @return This builder
         * @throws IllegalArgumentException If the name is invalid
         */
        Builder displayName(Text displayName) throws IllegalArgumentException;

        /**
         * Sets the prefix prepended to the display name of users on the {@link Team}.
         *
         * <p>Display names may be truncated in order to meet an implementation-defined length limit.
         * In Vanilla, this is sixteen characters.</p>
         *
         * @param prefix The new prefix for the {@link Team}
         * @return This builder
         */
        Builder prefix(Text prefix);

        /**
         * Sets the suffix appended to the display name of users on the {@link Team}.
         *
         * <p>Display names may be truncated in order to meet an implementation-defined length limit.
         * In Vanilla, this is sixteen characters.</p>
         *
         * @param suffix The new suffix for the {@link Team}.
         * @return This builder
         */
        Builder suffix(Text suffix);

        /**
         * Sets whether friendly fire is enabled for the {@link Team}.
         *
         * @param enabled Whether friendly fire is enabled
         * @return This builder
         */
        Builder allowFriendlyFire(boolean enabled);

        /**
         * Sets whether invisible team members are shown for the {@link Team}.
         *
         * @param enabled Whether to show invisible teammates
         * @return This builder
         */
        Builder canSeeFriendlyInvisibles(boolean enabled);

        /**
         * Sets the {@link Visibility} which controls to who nametags
         * of players on the {@link Team} are visible to.
         *
         * @param visibility The {@link Visibility} for the {@link Team}'s nametags
         * @return This builder
         */
        Builder nameTagVisibility(Visibility visibility);

        /**
         * Sets the {@link Visibility} which controls who death Texts
         * of players on the {@link Team} are visible to.
         *
         * @param visibility The {@link Visibility} for the {@link Team}'s death Texts
         * @return This builder
         */
        Builder deathTextVisibility(Visibility visibility);

        /**
         * Sets the set of {@link Text} members on the {@link Team}.
         *
         * <p>By default, this is the empty set.</p>
         *
         * @param users The set of {@link Text} members on the {@link Team}
         * @return This builder
         */
        Builder members(Set<Text> users);

        /**
         * Builds an instance of a {@link Team}.
         *
         * @return A new instance of a {@link Team}
         * @throws IllegalStateException if the {@link Team} is not complete
         */
        Team build() throws IllegalStateException;

    }
}
