/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Treatments;

import java.util.List;

/**
 *
 * @author Dell
 */
public class Meeting {
    private Patient patient;
    private Boolean payed;
    private Services service;

    public Meeting(Meeting m) {
     this.patient = m.getPatient();
     this.payed = m.isPayed();
     this.service=m.getService();
    }
    
    public Boolean isPayed() {
        return payed;
    }

    public void setPayed(Boolean payed) {
        this.payed = payed;
    }

       

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
        return "Meeting{ " + "patient=" + patient + ", payed=" + payed + ", service=" + service + '}';
    }
    
}
