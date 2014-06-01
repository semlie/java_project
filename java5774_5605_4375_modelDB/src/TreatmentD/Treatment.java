/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreatmentD;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Admin
 */
@Entity
public class Treatment extends Services implements Serializable {

    private static final long serialVersionUID = 1L;

    @Enumerated(EnumType.STRING)
    private TypesTret types;
    private String problem;
    public Treatment(Treatment t){
         super(new Long(t.getId()), t.getDate(), t.getNameOfAttendant(), t.getPrice());
        this.types = t.getTypes();
        this.problem = t.getProblem();
        
    }
    public Treatment(TypesTret typeT, String problem, int id, Date d, double price, String nameOfAttendant) {
       super(new Long(id), d, nameOfAttendant, price);
        this.types = typeT;
        this.problem = problem;
    }

    public Treatment(TypesTret types, String problem, Long id, Date date, String nameOfAttendant, double price) {
        super(id, date, nameOfAttendant, price);
        this.types = types;
        this.problem = problem;
    }

    public Treatment() {
    }
    

    public Long getId() {
        return super.getId();
    }

    public void setId(Long id) {
        super.setId(id);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the getId() fields are not set
        if (!(object instanceof Treatment)) {
            return false;
        }
        Treatment other = (Treatment) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Treatment{" + "types=" + types + ", problem=" + problem + '}';
    }

    public TypesTret getTypes() {
        return types;
    }

    public void setTypes(TypesTret types) {
        this.types = types;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    

}
