package org.spongepowered.api.event.filter.cause;

import org.spongepowered.api.event.cause.Cause;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Sets the parameter an array of all causes of the array component type in the
 * cause chain. The type of a parameter annotated with this annotation
 * <strong>MUST</strong> be an array type.
 * 
 * @see Cause#allOf(Class)
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface All {

    /**
     * Whether this listener should be skipped if the array would be empty.
     * 
     * @return Should ignore if empty
     */
    boolean ignoreEmpty() default true;
}
