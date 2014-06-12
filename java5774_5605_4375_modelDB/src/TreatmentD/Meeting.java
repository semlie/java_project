/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreatmentD;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author Admin
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Meeting")
@Entity
public class Meeting implements Serializable {

    @ManyToOne()
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Patient patient;
    private boolean payed;
    @Column(length = 3000)
    private Services service;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;

    /**
     *
     */
    public Meeting() {
    }

    /**
     *
     * @param m
     */
    public Meeting(Meeting m) {
        this.patient = m.getPatient();
        this.payed = m.isPayed();
        this.service = m.getService();
        this.date = m.getDate();
    }

    /**
     *
     * @param id
     * @param patient
     * @param payed
     * @param service
     * @param date
     */
    public Meeting(Long id, Patient patient, Boolean payed, Services service, Date date) {

        this.patient = patient;
        this.payed = payed;
        this.service = service;
        this.date = date;
    }

    /**
     *
     * @param patient
     * @param service
     * @param date
     */
    public Meeting(Patient patient, Services service, Date date) {

        this.patient = patient;
        this.payed = false;
        this.service = service;
        this.date = date;
    }

    /**
     *
     * @param patient
     * @param service
     */
    public Meeting(Patient patient, Services service) {

        this.patient = patient;
        this.payed = false;
        this.service = service;
    }

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
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meeting)) {
            return false;
        }
        Meeting other = (Meeting) object;
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
        return "Meeting{" + "id=" + id + ", patient=" + patient + ", payed=" + payed + ", service=" + service + ", date=" + date + '}';
    }

    /**
     *
     * @return
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     *
     * @param patient
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     *
     * @return
     */
    public Boolean isPayed() {
        return payed;
    }

    /**
     *
     * @param payed
     */
    public void setPayed(Boolean payed) {
        this.payed = payed;
    }

    /**
     *
     * @return
     */
    public Services getService() {
        return service;
    }

    /**
     *
     * @param service
     */
    public void setService(Services service) {
        this.service = service;
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

}
