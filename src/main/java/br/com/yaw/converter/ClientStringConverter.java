package br.com.yaw.converter;

import br.com.yaw.config.Converter;
import br.com.yaw.model.Client;

/**
 * Convert a Client to String.
 * 
 * @author eder.magalhaes
 */
public class ClientStringConverter implements Converter<Client, String> {

    public String convert(Client clie) {
        String content = String.format("Client: %s - Address: %s", clie.getName(), clie.getAddress());
        return content;
    }

}

