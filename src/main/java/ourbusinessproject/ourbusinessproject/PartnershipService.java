package ourbusinessproject.ourbusinessproject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PartnershipService {
    @PersistenceContext
    private EntityManager entityManager;

    public PartnershipService(EntityManager manager){
        entityManager = manager;
    }

    public Partnership newPartnership(Project p, Enterprise e){
        Partnership created = new Partnership();
        created.setCreationDate(new Date());
        created.setProject(p);
        created.setEnterprise(e);
        p.addPartnership(created);
        e.addPartnership(created);
        entityManager.persist(created);
        entityManager.flush();
        return created;
    }

    public Partnership findPartnershipById(Long id){
        return entityManager.find(Partnership.class, id);
    }

    public void remove(Partnership p){
        entityManager.remove(p);
        entityManager.flush();
    }
}
