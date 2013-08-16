package br.com.yaw.converter;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import br.com.yaw.config.Converter;
import br.com.yaw.model.Product;

/**
 * Convert Product to String in JSON format.
 * 
 * @author eder.magalhaes
 */
public class ProductJSONConverter  implements Converter<Product, String> {

    public String convert(Product from) {
        try {
            ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String content = String.format("Product [JSON]:%n%s", writer.writeValueAsString(from));
            return content;
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Isn't possible to convert a Product "+ex.getMessage(), ex);
        }
    }

}
