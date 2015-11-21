package org.spongepowered.api.event.filter.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Allows listing for a supertype event and filtering to only receive events not
 * from a specific subset of the annotated event's subtypes.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Exclude {

    Class<?>[] value();

}
