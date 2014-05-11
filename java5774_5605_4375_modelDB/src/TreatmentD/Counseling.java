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

/**
 *
 * @author Admin
 */
@Entity
public class Counseling extends Services implements Serializable {
    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
        
    private Long Rid;
    private String  sid;
    @Enumerated(EnumType.STRING)
    private TypesCons typs;

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
        if (!(object instanceof Counseling)) {
            return false;
        }
        Counseling other = (Counseling) object;
        if ((this.Rid == null && other.Rid != null) || (this.Rid != null && !this.Rid.equals(other.Rid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TreatmentD.Counseling[ id=" + Rid + " ]";
    }
    
}
