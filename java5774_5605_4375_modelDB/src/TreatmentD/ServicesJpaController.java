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
public class ServicesJpaController implements Serializable {

    /**
     *
     * @param emf
     */
    public ServicesJpaController(EntityManagerFactory emf) {
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
     * @param services
     */
    public void create(Services services) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(services);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     *
     * @param services
     * @throws NonexistentEntityException
     * @throws Exception
     */
    public void edit(Services services) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            services = em.merge(services);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = services.getId();
                if (findServices(id) == null) {
                    throw new NonexistentEntityException("The services with id " + id + " no longer exists.");
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
            Services services;
            try {
                services = em.getReference(Services.class, id);
                services.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The services with id " + id + " no longer exists.", enfe);
            }
            em.remove(services);
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
    public List<Services> findServicesEntities() {
        return findServicesEntities(true, -1, -1);
    }

    /**
     *
     * @param maxResults
     * @param firstResult
     * @return
     */
    public List<Services> findServicesEntities(int maxResults, int firstResult) {
        return findServicesEntities(false, maxResults, firstResult);
    }

    private List<Services> findServicesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Services.class));
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
    public Services findServices(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Services.class, id);
        } finally {
            em.close();
        }
    }

    /**
     *
     * @return
     */
    public int getServicesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Services> rt = cq.from(Services.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
