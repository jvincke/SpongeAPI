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
package org.spongepowered.api.event.filter;

import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.CauseTracked;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Filters which allow sourcing additional parameters from cause objects, if the
 * object is not present in the cause then the listener is not called.
 * 
 * <p> The targeted event type of the annotated listener <strong>MUST</strong>
 * track causes (eg. it must extent {@link CauseTracked}). </p>
 */
public class CauseFilters {

    /**
     * Sets the parameter to the first object in the cause chain of the
     * parameter type.
     * 
     * @see Cause#first(Class)
     */
    @Target(ElementType.PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface First {

    }

    /**
     * Sets the parameter to the last object in the cause chain of the parameter
     * type.
     * 
     * @see Cause#last(Class)
     */
    @Target(ElementType.PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface Last {

    }

    /**
     * Sets the parameter an array of all causes of the array component type in
     * the cause chain. The type of a parameter annotated with this annotation
     * <strong>MUST</strong> be an array type.
     * 
     * @see Cause#allOf(Class)
     */
    @Target(ElementType.PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface All {

        /**
         * Whether this listener should be skipped if the array would be empty.
         * 
         * @return Should ignore if empty
         */
        boolean ignoreEmpty() default true;
    }

    private CauseFilters() {
    }

}
