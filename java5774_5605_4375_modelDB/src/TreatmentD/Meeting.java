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

/**
 *
 * @author Admin
 */
@Entity
public class Meeting implements Serializable {

    @ManyToOne()
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Patient patient;
    private Boolean payed;
    @Column(length = 3000)
    private Services service;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;

    public Meeting() {
    }

    public Meeting(Meeting m) {
        this.patient = m.getPatient();
        this.payed = m.isPayed();
        this.service = m.getService();
        this.date = m.getDate();
    }

    public Meeting(Long id, Patient patient, Boolean payed, Services service, Date date) {

        this.patient = patient;
        this.payed = payed;
        this.service = service;
        this.date = date;
    }
        public Meeting(Patient patient,  Services service, Date date) {

        this.patient = patient;
        this.payed = false;
        this.service = service;
        this.date = date;
    }
                public Meeting(Patient patient,  Services service) {

        this.patient = patient;
        this.payed = false;
        this.service = service;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

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

    @Override
    public String toString() {
        return "Meeting{" + "id=" + id + ", patient=" + patient + ", payed=" + payed + ", service=" + service + ", date=" + date + '}';
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Boolean isPayed() {
        return payed;
    }

    public void setPayed(Boolean payed) {
        this.payed = payed;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
