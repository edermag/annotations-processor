package br.com.yaw.config;

/**
 * Root interface for converters.
 * 
 * @author eder.magalhaes
 *
 * @param <From> The original type, source of conversion.
 * @param <To> The new type after conversion.
 */
public interface Converter<From, To> {

    To convert(From from);

}
