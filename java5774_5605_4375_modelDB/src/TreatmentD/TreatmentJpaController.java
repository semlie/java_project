/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TreatmentD;

import TreatmentD.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Admin
 */
public class TreatmentJpaController implements Serializable {

    /**
     *
     * @param emf
     */
    public TreatmentJpaController(EntityManagerFactory emf) {
        this.emf = emf;
               EntityManager em = this.emf.createEntityManager();
    }
    private EntityManagerFactory emf = null;

    /**
     *
     * @return
     */
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     *
     * @param treatment
     */
    public void create(Treatment treatment) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(treatment);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     *
     * @param treatment
     * @throws NonexistentEntityException
     * @throws Exception
     */
    public void edit(Treatment treatment) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            treatment = em.merge(treatment);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = treatment.getId();
                if (findTreatment(id) == null) {
                    throw new NonexistentEntityException("The treatment with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     *
     * @param id
     * @throws NonexistentEntityException
     */
    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Treatment treatment;
            try {
                treatment = em.getReference(Treatment.class, id);
                treatment.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The treatment with id " + id + " no longer exists.", enfe);
            }
            em.remove(treatment);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     *
     * @return
     */
    public List<Treatment> findTreatmentEntities() {
        return findTreatmentEntities(true, -1, -1);
    }

    /**
     *
     * @param maxResults
     * @param firstResult
     * @return
     */
    public List<Treatment> findTreatmentEntities(int maxResults, int firstResult) {
        return findTreatmentEntities(false, maxResults, firstResult);
    }

    private List<Treatment> findTreatmentEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Treatment.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public Treatment findTreatment(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Treatment.class, id);
        } finally {
            em.close();
        }
    }

    /**
     *
     * @return
     */
    public int getTreatmentCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Treatment> rt = cq.from(Treatment.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
