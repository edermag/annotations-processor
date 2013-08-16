package br.com.yaw.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Keep the all converters that have been opened.
 * 
 * @author eder.magalhaes
 */
public class ConverterRepository {

    private Map<Class<?>, Converter<?, ?>> converters;
    
    private ConverterRepository() {
        converters = new HashMap<Class<?>, Converter<?,?>>();
    }
    
    public static ConverterRepository create(List<ConverterLoader.ConverterTypeEntry> entries) {
        ConverterRepository instance = new ConverterRepository();
	    
        for (ConverterLoader.ConverterTypeEntry entry: entries) {
            instance.registerConverter(entry);
        }
        
        return instance;
    }
    
    protected void registerConverter(ConverterLoader.ConverterTypeEntry converterEntry) {
        Class<?> entityType = converterEntry.entityType;
        Class<? extends Converter<?, ?>> converterType = converterEntry.converterType;
        
        Converter<?, ?> converter = buildConverter(converterType);
        converters.put(entityType, converter);
    }
    
    public Converter<?, ?> getConversor(Class<?> entityType) {
        return converters.get(entityType);
    }
    
    private Converter<?, ?> buildConverter(Class<? extends Converter<?, ?>> converterType) {
        try {
            Converter<?, ?> converter = converterType.newInstance();
            return converter;
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid constructor for "+converterType.getCanonicalName());
        }
    }
}
