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
public class Treatment extends Services {

    private TypesTret types;
    private String problem;

    /**
     *
     * @param types
     * @param problem
     * @param id
     * @param date
     * @param price
     * @param nameOfAttendant
     */
    public Treatment(TypesTret types, String problem, int id, Date date, double price, String nameOfAttendant) {
        super(id, date, price, nameOfAttendant);
        this.types = types;
        this.problem = problem;
    }

    public Treatment(Treatment t) {
        super(t.getId() ,t.getDate(),t.getId(),t.getNameOfAttendant());
        this.types =t.getTypes();
        this.problem =t.getProblem();
    }

    /**
     * @return the types
     */
    public TypesTret getTypes() {
        return types;
    }

    /**
     * @param types the types to set
     */
    public void setTypes(TypesTret types) {
        this.types = types;
    }

    /**
     * @return the problem
     */
    public String getProblem() {
        return problem;
    }

    /**
     * @param problem the problem to set
     */
    public void setProblem(String problem) {
        this.problem = problem;
    }

    @Override
    public String toString() {
        return "Treatment{ " + super.toString() + " types=" + types + ", problem=" + problem + '}';
    }

}
