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
public abstract class Services {
    public enum TypesTret {SHIATSU,ACUPNCTURE ,MESO ,REFLEXOLOGY} //Treatment types
    public enum TypesCons {SHIATSU,ACUPNCTURE ,MESO ,REFLEXOLOGY} //counseling types
    private int id;
    private Date date;
    private String nameOfAttendant;
    private double price;
    
 /**
  * 
  * @param id
  * @param date
  * @param price
  * @param nameOfAttendant 
  */
    public Services(int id, Date date, double price, String nameOfAttendant) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.nameOfAttendant = nameOfAttendant;
    }
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the nameOfAttendant
     */
    public String getNameOfAttendant() {
        return nameOfAttendant;
    }

    /**
     * @param nameOfAttendant the nameOfAttendant to set
     */
    public void setNameOfAttendant(String nameOfAttendant) {
        this.nameOfAttendant = nameOfAttendant;
    }

    @Override
    public String toString() {
        return "id=" + id + ", date=" + date + ", price=" + price + ", nameOfAttendant=" + nameOfAttendant ;
    }
    
}
