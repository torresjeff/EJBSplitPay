
package integracion;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PagarResult" type="{http://tempuri.org/}PagarPayPalResponse" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "pagarResult"
})
@XmlRootElement(name = "PagarResponse")
public class PagarResponse implements Serializable{

    @XmlElement(name = "PagarResult")
    protected PagarPayPalResponse pagarResult;

    /**
     * Gets the value of the pagarResult property.
     * 
     * @return
     *     possible object is
     *     {@link PagarPayPalResponse }
     *     
     */
    public PagarPayPalResponse getPagarResult() {
        return pagarResult;
    }

    /**
     * Sets the value of the pagarResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PagarPayPalResponse }
     *     
     */
    public void setPagarResult(PagarPayPalResponse value) {
        this.pagarResult = value;
    }

}
