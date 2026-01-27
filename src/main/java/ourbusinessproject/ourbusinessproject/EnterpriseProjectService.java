package ourbusinessproject.ourbusinessproject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class EnterpriseProjectService {
    @PersistenceContext
    private EntityManager entityManager;

    public EnterpriseProjectService(EntityManager manager){
        entityManager = manager;
    }

    public EntityManager getEntityManager(){
        return entityManager;
    }

    public Project newProject(String title, String description, Enterprise enterprise){
        if (enterprise == null){
            throw new ConstraintViolationException("enterprise cannot be null", new HashSet<>());
        }
        Project project = new Project();
        project.setTitle(title);
        project.setDescription(description);
        project.setEnterprise(enterprise);
        enterprise.addProject(project);
        entityManager.persist(project);
        entityManager.flush();
        return project;
    }

    public Enterprise newEnterprise(String name, String description, String contactName, String contactEmail){
        Enterprise enterprise = new Enterprise();
        enterprise.setName(name);
        enterprise.setDescription(description);
        enterprise.setContactName(contactName);
        enterprise.setContactEmail(contactEmail);
        entityManager.persist(enterprise);
        entityManager.flush();
        return enterprise;
    }

    public Project findProjectById(Long id){
        return entityManager.find(Project.class, id);
    }

    public Enterprise findEnterpriseById(Long id){
        return entityManager.find(Enterprise.class, id);
    }
}
