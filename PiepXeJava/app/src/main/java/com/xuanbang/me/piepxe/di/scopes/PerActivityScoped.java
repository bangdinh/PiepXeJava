package com.xuanbang.me.piepxe.di.scopes;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * A custom scoping annotation that specifies that the lifespan of a dependency be the same as that
 * of an Activity.
 *
 * This is used to annotate dependencies that behave like a singleton within the lifespan of an
 * Activity, Fragment, and child Fragments instead of the entire Application.
 */
@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivityScoped {
}
