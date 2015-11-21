package org.spongepowered.api.event.filter.cause;

import org.spongepowered.api.event.cause.Cause;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Sets the parameter to the last object in the cause chain of the parameter
 * type.
 * 
 * @see Cause#last(Class)
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface Last {

}
