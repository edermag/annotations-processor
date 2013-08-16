package br.com.yaw.converter;

import java.text.NumberFormat;

import br.com.yaw.config.Converter;
import br.com.yaw.model.Product;

/**
 * Convert Product to a simple String.
 * 
 * @author eder.magalhaes
 */
public class ProductStringConverter implements Converter<Product, String> {

    private static final String CURRENCY_SIMBOL;

    static {
        CURRENCY_SIMBOL = NumberFormat.getCurrencyInstance().getCurrency().getSymbol();
    }

    public String convert(Product m) {
        String content = String.format("Product: %s - Value: %s %.2f", 
                m.getDescription(), CURRENCY_SIMBOL, m.getValue());
        return content;
    }

}
