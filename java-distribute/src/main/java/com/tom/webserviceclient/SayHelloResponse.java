
package com.tom.webserviceclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>sayHelloResponse complex type�� Java �ࡣ
 *
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 *
 * <pre>
 * &lt;complexType name="sayHelloResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sayHelloResponse", propOrder = {
        "_return"
})
public class SayHelloResponse {

    @XmlElement(name = "return")
    protected String _return;

    /**
     * ��ȡreturn���Ե�ֵ��
     *
     * @return possible object is
     * {@link String }
     */
    public String getReturn() {
        return _return;
    }

    /**
     * ����return���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setReturn(String value) {
        this._return = value;
    }

}
