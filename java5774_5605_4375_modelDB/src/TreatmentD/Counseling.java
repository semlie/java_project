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

/**
 *
 * @author Admin
 */
@Entity
public class Counseling extends Services implements Serializable {

    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)

    @Enumerated(EnumType.STRING)
    private TypesCons typs;

    public Counseling() {
    }

    public Counseling(TypesCons typs) {
        this.typs = typs;
    }

    public Counseling(Counseling c) {
 super(c.getId(),c.getDate(),c.getNameOfAttendant(),c.getPrice());
        this.typs = c.getTyps();
    }

    public Counseling(TypesCons typs, Long id, Date date, String nameOfAttendant, double price) {
        super( id, date, nameOfAttendant, price);
        this.typs = typs;
    }

    public Counseling(TypesCons typeC, int id, Date d, double price, String nameOfAttendant) {
        super(new Long(id), d, nameOfAttendant, price);
        this.typs = typeC;
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
        if (!(object instanceof Counseling)) {
            return false;
        }
        Counseling other = (Counseling) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    public TypesCons getTyps() {
        return this.typs;
    }

    public void setTyps(TypesCons typs) {
        this.typs = typs;
    }

    @Override
    public String toString() {
        return "Counseling{" + "typs=" + typs + '}';
    }

   

}
