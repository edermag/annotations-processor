package br.com.yaw.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Specifies that the class can be converted.
 * 
 * @author eder.magalhaes
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Convertable {

    /**
     * @return The type of converter (@see Converter).
     */
    Class<? extends Converter<?, ?>> type();

}
