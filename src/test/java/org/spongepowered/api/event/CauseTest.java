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

import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.mockito.Mockito;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.cause.Cause;

import java.util.ArrayList;
import java.util.List;
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

    @Test(expected = NullPointerException.class)
    public void testNullCause() {
        Cause.of((Object) null);
    }

    @Test
    public void testWithCause() {
        final Cause old = Cause.of("foo");
        final Cause newCause = old.with("bar");
        assert old != newCause;
        assert newCause.all().contains("foo");
        assert newCause.all().contains("bar");
    }

    @Test(expected = NullPointerException.class)
    public void testWithNullCause() {
        final Cause old = Cause.of("foo");
        final Cause newCause = old.with((Object) null);
    }

    @Test(expected = NullPointerException.class)
    public void testWithNullCauses() {
        final Cause old = Cause.empty();
        final Cause newCause = old.with(null, null);
    }

    @Test
    public void testToString() {
        final Cause cause = Cause.of("foo", "bar", 1, 2, true, false);
        final String causeString = cause.toString();
        System.err.println(causeString);
    }

    @Test
    public void testPlayerCause() {
        final Player mockPlayer = mock(Player.class);
        final Cause playerCause = Cause.of(mockPlayer);
        final Optional<Player> optional = playerCause.first(Player.class);
        optional.get();
    }

    @Test
    public void testMultiple() {
        List<Player> mockPlayers = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            mockPlayers.add(mock(Player.class));
        }
        final Cause playerCuases = Cause.of(mockPlayers);
        List<Player> players = playerCuases.allOf(Player.class);
        assert mockPlayers.containsAll(players) && players.containsAll(mockPlayers);
    }

    @Test
    public void testOrder() {
        List<Player> mockPlayers = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            mockPlayers.add(mock(Player.class));
        }
        final Cause playerCauses = Cause.of(mockPlayers);
        List<Player> players = playerCauses.allOf(Player.class);
        for (int i = 0; i < 1000; i++) {
            assert mockPlayers.get(i) == players.get(i);
        }
    }

    @Test
    public void testEquals() {
        final Cause aCause = Cause.of("Test");
        final Cause bCause = Cause.of("Test");
        final Cause cCause = Cause.of("Derp");
        assert aCause.equals(bCause) && bCause.equals(aCause);
        assert !aCause.equals(cCause) && !bCause.equals(cCause);
    }



}
