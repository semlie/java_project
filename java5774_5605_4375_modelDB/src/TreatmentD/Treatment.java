/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreatmentD;

import java.io.Serializable;
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

    private Long Rid;
    @Enumerated(EnumType.STRING)
    private TypesTret types;
    private String problem;

    public Long getId() {
        return Rid;
    }

    public void setId(Long id) {
        this.Rid = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (Rid != null ? Rid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the Rid fields are not set
        if (!(object instanceof Treatment)) {
            return false;
        }
        Treatment other = (Treatment) object;
        if ((this.Rid == null && other.Rid != null) || (this.Rid != null && !this.Rid.equals(other.Rid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TreatmentD.Treatment[ id=" + Rid + " ]";
    }

}
