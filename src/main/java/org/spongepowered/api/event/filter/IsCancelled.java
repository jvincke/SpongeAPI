package org.spongepowered.api.event.filter;

import org.spongepowered.api.event.Cancellable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Filters out only events which are cancelled at the time that the listener is
 * called.
 * 
 * <p> The annotated event type <strong>MUST</strong> be cancellable (eg. must
 * extend {@link Cancellable}). </p>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IsCancelled {

}
