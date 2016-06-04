
package integracion;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the integracion package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: integracion
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Pagar }
     * 
     */
    public Pagar createPagar() {
        return new Pagar();
    }

    /**
     * Create an instance of {@link PagarRequest }
     * 
     */
    public PagarRequest createPagarRequest() {
        return new PagarRequest();
    }

    /**
     * Create an instance of {@link PagarResponse }
     * 
     */
    public PagarResponse createPagarResponse() {
        return new PagarResponse();
    }

    /**
     * Create an instance of {@link PagarPayPalResponse }
     * 
     */
    public PagarPayPalResponse createPagarPayPalResponse() {
        return new PagarPayPalResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link LoginRequest }
     * 
     */
    public LoginRequest createLoginRequest() {
        return new LoginRequest();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link LoginPayPalResponse }
     * 
     */
    public LoginPayPalResponse createLoginPayPalResponse() {
        return new LoginPayPalResponse();
    }

    /**
     * Create an instance of {@link PayPalResponse }
     * 
     */
    public PayPalResponse createPayPalResponse() {
        return new PayPalResponse();
    }

}
