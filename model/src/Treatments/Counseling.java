/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Treatments;

import java.util.Date;


/**
 *
 * @author Dell
 */
public class Counseling extends Services{
    private TypesCons typs;
/**
 * 
 * @param typs
 * @param id
 * @param date
 * @param price
 * @param nameOfAttendant 
 */
    public Counseling(TypesCons typs , int id, Date date, double price, String nameOfAttendant) {
        super(id, date, price, nameOfAttendant);
        this.typs = typs;
    }

    public Counseling(Counseling c) {
        super(c.getId(), c.getDate(), c.getPrice(),c.getNameOfAttendant()); 
        this.typs = c.getTyps();
        
    }



    

    /**
     * @return the typs
     */
    public TypesCons getTyps() {
        return typs;
    }

    /**
     * @param typs the typs to set
     */
    public void setTyps(TypesCons typs) {
        this.typs = typs;
    }

    @Override
    public String toString() {
        return "Counseling{ "+ super.toString() + " typs=" + typs + '}';
    }


}
