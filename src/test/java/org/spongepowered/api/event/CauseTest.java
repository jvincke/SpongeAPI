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
package org.spongepowered.api.event;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mockito;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.NamedCause;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CauseTest {

    @Test
    public void testEmptyCause() {
        Cause.empty();
    }

    @Test
    public void testPopulatedCause() {
        Cause.of("foo");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullCause() {
        Cause.of((Object) null);
    }

    @Test
    public void testWithCause() {
        final Cause old = Cause.of("foo");
        final Cause newCause = old.with("bar");
        assertThat(old, not(newCause));
        assertThat(newCause.all().contains("foo"), is(true));
        assertThat(newCause.all().contains("bar"), is(true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullCause() {
        final Cause old = Cause.of("foo");
        final Cause newCause = old.with((Object) null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullCauses() {
        final Cause old = Cause.empty();
        final Cause newCause = old.with(null, null);
    }

    @Test
    public void testToString() {
        final Cause cause = Cause.of("foo", "bar", 1, 2, true, false);
        final String causeString = cause.toString();
        assertThat(causeString.isEmpty(), is(false));
    }

    @Test
    public void testBefore() {
        final Cause cause = Cause.of("foo", 1, 2);
        final Optional<?> optional = cause.before(Integer.class);
        assertThat(optional.isPresent(), is(true));
        assertThat(optional.get(), is("foo"));
    }

    @Test
    public void testAfter() {
        final Cause cause = Cause.of("foo", 1, 2);
        final Optional<?> optional = cause.after(Integer.class);
        assertThat(optional.isPresent(), is(true));
        assertThat(optional.get(), is(2));
    }

    @Test
    public void testNoneAfter() {
        final Cause cause = Cause.of("foo", 1);
        final Optional<?> optional = cause.after(Integer.class);
        assertThat(optional.isPresent(), is(false));
    }

    @Test
    public void testNoneBefore() {
        final Cause cause = Cause.of("foo", 1);
        final Optional<?> optional = cause.before(String.class);
        assertThat(optional.isPresent(), is(false));
    }

    @Test
    public void testEmpty() {
        final Cause empty = Cause.of();
        assertThat(empty.isEmpty(), is(true));
    }

    @Test
    public void testEmptyWithEmpty() {
        final Cause empty = Cause.empty();
        assertThat(empty.with().isEmpty(), is(true));
    }

    @Test
    public void testNoneOf() {
        final Cause cause = Cause.of("foo", 1, 2, 3);
        assertThat(cause.noneOf(Integer.class), hasSize(1));
        assertThat(cause.noneOf(Integer.class).get(0), is("foo"));
    }

    @Test
    public void testJustBecauseIcan() {
        final Cause cause = Cause.of();
        final Cause testing = cause.with().with().with().with(new ArrayList<>()).with();
        assertThat(testing.isEmpty(), is(true));
        assertThat(testing.allOf(String.class), hasSize(0));
        assertThat(testing.noneOf(String.class), hasSize(0));
    }

    @Test
    public void testNamedCause() {
        final Player player = Mockito.mock(Player.class);
        final NamedCause ownerCause = NamedCause.of(NamedCause.OWNER, player);
        final Cause playerCause = Cause.of(ownerCause);
        Optional<Player> optional = playerCause.get(NamedCause.OWNER);
        assertThat(optional.isPresent(), is(true));
    }

    @Test
    public void testAbsentNamedCause() {
        final Cause emptyCause = Cause.of();
        final Optional<Object> optional = emptyCause.get(NamedCause.OWNER);
        assertThat(optional.isPresent(), is(false));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalNamedCause() {
        final Player player = Mockito.mock(Player.class);
        final Player playerB = Mockito.mock(Player.class);
        final NamedCause namedA = NamedCause.of(NamedCause.OWNER, player);
        final NamedCause namedB = NamedCause.of(NamedCause.OWNER, playerB);
        final Cause cause = Cause.of(namedA, namedB);
        // The line above should throw an exception!
    }

    @Test
    public void testNamedCauseMap() {
        final Player player = Mockito.mock(Player.class);
        final NamedCause owner = NamedCause.of(NamedCause.OWNER, player);
        final Living entity = Mockito.mock(Living.class);
        final NamedCause living = NamedCause.of("summoned", entity);
        final Cause cause = Cause.of(living, owner);
        final Map<String, Object> map = cause.getNamedCauses();
        assertThat(map.containsKey(NamedCause.OWNER), is(true));
        assertThat(map.containsKey("summoned"), is(true));
        int index = 0;
        final List<Object> all = cause.all();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            assertThat(all.get(index), equalTo(entry.getValue()));
            index++;
        }
    }

    @Test
    public void testNamedBefore() {
        final Player player = Mockito.mock(Player.class);
        final NamedCause owner = NamedCause.of(NamedCause.OWNER, player);
        final Living entity = Mockito.mock(Living.class);
        final NamedCause living = NamedCause.of("summoned", entity);
        final Cause cause = Cause.of(living, owner);
        final Optional<?> optional = cause.before(NamedCause.OWNER);
        assertThat(optional.isPresent(), is(true));
    }

    @Test
    public void testNoNamedBefore() {
        final Player player = Mockito.mock(Player.class);
        final NamedCause owner = NamedCause.of(NamedCause.OWNER, player);
        final Cause cause = Cause.of(owner);
        final Optional<?> optional = cause.before(NamedCause.OWNER);
        assertThat(optional.isPresent(), is(false));
    }

    @Test
    public void testNamedAfter() {
        final Player player = Mockito.mock(Player.class);
        final NamedCause owner = NamedCause.of(NamedCause.OWNER, player);
        final Living entity = Mockito.mock(Living.class);
        final NamedCause living = NamedCause.of("summoned", entity);
        final Cause cause = Cause.of(living, owner);
        final Optional<?> optional = cause.after("summoned");
        assertThat(optional.isPresent(), is(true));
    }

    @Test
    public void testNoNamedAfter() {
        final Player player = Mockito.mock(Player.class);
        final NamedCause owner = NamedCause.of(NamedCause.OWNER, player);
        final Cause cause = Cause.of(owner);
        final Optional<?> optional = cause.after(NamedCause.OWNER);
        assertThat(optional.isPresent(), is(false));
    }

    @Test
    public void testNamedWith() {
        final Cause cause = Cause.of(NamedCause.of("Test Block", Mockito.mock(BlockSnapshot.class)));
        User user = Mockito.mock(User.class);
        User owner = Mockito.mock(User.class);
        final Cause enhanced = cause.with(NamedCause.of(NamedCause.NOTIFIER, user)).with(NamedCause.of(NamedCause.OWNER, owner));
        final Map<String, Object> causes = enhanced.getNamedCauses();

        final Optional<User> optional = enhanced.first(User.class);
        assertThat(optional.isPresent(), is(true));
        List<Object> allCauses = enhanced.all();
        assertThat(allCauses, hasSize(3));
    }

}
