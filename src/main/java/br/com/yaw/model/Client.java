package br.com.yaw.model;

import br.com.yaw.config.Convertable;
import br.com.yaw.converter.ClientStringConverter;

/**
 * Bean that can be converted to String.
 * 
 * @author eder.magalhaes
 */
@Convertable(type=ClientStringConverter.class)
public class Client {

    private String name;
    
    private String idDoc;
    
    private String address;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getIdDoc() {
        return idDoc;
    }
    
    public void setIdDoc(String idDoc) {
        this.idDoc = idDoc;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
}
