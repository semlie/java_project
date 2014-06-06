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
public class CounselingJpaController implements Serializable {

    /**
     *
     * @param emf
     */
    public CounselingJpaController(EntityManagerFactory emf) {
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
     * @param counseling
     */
    public void create(Counseling counseling) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(counseling);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     *
     * @param counseling
     * @throws NonexistentEntityException
     * @throws Exception
     */
    public void edit(Counseling counseling) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            counseling = em.merge(counseling);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = counseling.getId();
                if (findCounseling(id) == null) {
                    throw new NonexistentEntityException("The counseling with id " + id + " no longer exists.");
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
            Counseling counseling;
            try {
                counseling = em.getReference(Counseling.class, id);
                counseling.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The counseling with id " + id + " no longer exists.", enfe);
            }
            em.remove(counseling);
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
    public List<Counseling> findCounselingEntities() {
        return findCounselingEntities(true, -1, -1);
    }

    /**
     *
     * @param maxResults
     * @param firstResult
     * @return
     */
    public List<Counseling> findCounselingEntities(int maxResults, int firstResult) {
        return findCounselingEntities(false, maxResults, firstResult);
    }

    private List<Counseling> findCounselingEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Counseling.class));
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
    public Counseling findCounseling(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Counseling.class, id);
        } finally {
            em.close();
        }
    }

    /**
     *
     * @return
     */
    public int getCounselingCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Counseling> rt = cq.from(Counseling.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
