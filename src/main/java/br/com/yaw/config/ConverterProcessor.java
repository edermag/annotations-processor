package br.com.yaw.config;

/**
 * Make conversion from the <i>entity</id> (bean).
 * 
 * @author eder.magalhaes
 */
public class ConverterProcessor {

    private static final EmptyConverter EMPTY = new EmptyConverter();
    
    private ConverterRepository repository;
    
    @SuppressWarnings("unchecked")
    public <T, E> T makeConversion(E entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Isn't possible to convert null.");
        }
        
        Converter<E, T> conversor = (Converter<E, T>) repository.getConversor(entity.getClass());
        if (conversor == null)
            return (T) EMPTY.convert(null);
        
        try {
            return (T) conversor.convert(entity);
        } catch (Exception ex) {
            String msg = "Erro na conversão de "+conversor.getClass().getCanonicalName();
            System.err.println(msg);
            throw new RuntimeException(msg + entity, ex);
        }
    }
    
    public void setRepository(ConverterRepository repository) {
        this.repository = repository;
    }

    /**
     * Implements a Nullable converter.
     */
    private static class EmptyConverter implements Converter<Object, String> {
        private EmptyConverter(){}
        
        public String convert(Object from) {
            return "";
        }
    }
}
