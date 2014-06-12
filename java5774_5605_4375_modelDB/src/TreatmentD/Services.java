/**
 * 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TreatmentD;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author Admin
 */
@XmlSeeAlso({Treatment.class,Counseling.class})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Services")
@Entity
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS)
public class Services implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    /**
     *
     */
    public enum TypesTret {

        /**
         *
         */
        SHIATSU,

        /**
         *
         */
        ACUPNCTURE ,

        /**
         *
         */
        MESO ,

        /**
         *
         */
        REFLEXOLOGY} //Treatment types

    /**
     *
     */
    public enum TypesCons {

        /**
         *
         */
        SHIATSU,

        /**
         *
         */
        ACUPNCTURE ,

        /**
         *
         */
        MESO ,

        /**
         *
         */
        REFLEXOLOGY} //counseling types
   @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    private String nameOfAttendant;
    private double price;

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     *
     * @param id
     * @param date
     * @param nameOfAttendant
     * @param price
     */
    public Services(Long id, Date date, String nameOfAttendant, double price) {
        this.date = date;
        this.nameOfAttendant = nameOfAttendant;
        this.price = price;
        
    }

    /**
     *
     */
    public Services() {
    }

    /**
     *
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Services)) {
            return false;
        }
        Services other = (Services) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Services{" + "id=" + id + ", date=" + date + ", nameOfAttendant=" + nameOfAttendant + ", price=" + price + '}';
    }

    /**
     *
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @return
     */
    public String getNameOfAttendant() {
        return nameOfAttendant;
    }

    /**
     *
     * @param nameOfAttendant
     */
    public void setNameOfAttendant(String nameOfAttendant) {
        this.nameOfAttendant = nameOfAttendant;
    }

    /**
     *
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
}
