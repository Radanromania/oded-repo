//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.01.14 at 04:53:10 PM EST 
//


package customer.xml;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the customer.xml package. 
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

    private final static QName _Customer_QNAME = new QName("http://xml.customer", "customer");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: customer.xml
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CustomerType }
     * 
     */
    public CustomerType createCustomerType() {
        return new CustomerType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.customer", name = "customer")
    public JAXBElement<CustomerType> createCustomer(CustomerType value) {
        return new JAXBElement<CustomerType>(_Customer_QNAME, CustomerType.class, null, value);
    }

}
