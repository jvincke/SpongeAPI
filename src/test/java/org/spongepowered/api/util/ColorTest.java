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
package org.spongepowered.api.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ColorTest {

    @Test
    public void testColorAwtTranslation() {
        final Color color = Color.of(java.awt.Color.BLUE);
        final java.awt.Color javaTranslated = color.asJavaColor();
        assertTrue(java.awt.Color.BLUE.equals(javaTranslated));
    }

    @Test
    public void testAverage() {
        final Color blue = Color.of(java.awt.Color.BLUE);
        final Color green = Color.of(java.awt.Color.GREEN);
        final Color average = Color.mixColors(blue, green);
        final java.awt.Color javaColor = average.asJavaColor();
        int javaRed = javaColor.getRed();
        int javaGreen = javaColor.getGreen();
        int javaBlue = javaColor.getBlue();
    }

    @Test
    public void testUnknown() {
        final java.awt.Color unknown = Color.UNKNOWN.asJavaColor();
        int javaRed = unknown.getRed();
        int javaGreen = unknown.getGreen();
        int javaBlue = unknown.getBlue();
    }

}
