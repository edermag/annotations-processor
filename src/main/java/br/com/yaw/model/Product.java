package br.com.yaw.model;

import br.com.yaw.config.Convertable;
import br.com.yaw.converter.ProductJSONConverter;

/**
 * Bean that can be converted to JSON (String).
 * 
 * @author eder.magalhaes
 */
@Convertable(type=ProductJSONConverter.class)
public class Product {

    private String description;
    
    private Double value;
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public Double getValue() {
        return value;
    }
    
    public void setValue(Double value) {
        this.value = value;
    }
    
}
