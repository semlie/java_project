/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Treatments;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Dell
 */
public class Meeting {
    private Patient patient;
    private Boolean payed;
    private Services service;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Meeting(Meeting m) {
     this.patient = m.getPatient();
     this.payed = m.isPayed();
     this.service=m.getService();
     this.date=m.getDate();
    }
    
    public Boolean isPayed() {
        return payed;
    }

    public void setPayed(Boolean payed) {
        this.payed = payed;
    }
/**
 * 
 * @param patient
 * @param service
 * @param date 
 */
    public Meeting(Patient patient, Services service, Date date) {
        this.patient = patient;
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
        this.service = service;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "Meeting{" + "patient=" + patient + ", payed=" + payed + ", service=" + service + ", date=" + date + '}';
    }


    
}
