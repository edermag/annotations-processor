package br.com.yaw.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

/**
 * Looking by @Convertable classes to open the converters.
 * 
 * @author eder.magalhaes
 */
public final class ConverterLoader {

    private ConverterLoader(){}
    
    public static class ConverterTypeEntry {
        	
        final Class<?> entityType;
        
        final Class<? extends Converter<?, ?>> converterType;
  
        private ConverterTypeEntry(Class<?> entityType, Class<? extends Converter<?, ?>> converterType) {
            this.entityType = entityType;
            this.converterType = converterType;
        }
    }
    
    private static Set<Class<?>> getClassConvertables() {
        Reflections reflections = new Reflections(
                new ConfigurationBuilder().setUrls(ClasspathHelper
                        .forJavaClassPath()));
        Set<Class<?>> convertables = reflections.getTypesAnnotatedWith(Convertable.class);
        return convertables;
    }
    
    public static List<ConverterTypeEntry> loadConverters() {
        Set<Class<?>> convertables = getClassConvertables();
        
        List<ConverterTypeEntry> entries = new ArrayList<ConverterLoader.ConverterTypeEntry>();
        
        for (Class<?> convertable : convertables) {
            Convertable annotation = convertable.getAnnotation(Convertable.class);
            Class<? extends Converter<?, ?>> converterType = annotation.type();
            entries.add(new ConverterTypeEntry(convertable, converterType));
        }
		return entries;
	}

}
