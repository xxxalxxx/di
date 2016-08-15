package com.example.al.daggertest.scope;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
/**
 * Created by al on 13.08.16.
 */
@Scope
@Documented
@Retention(value=RUNTIME)
public @interface PerApplication {
}
