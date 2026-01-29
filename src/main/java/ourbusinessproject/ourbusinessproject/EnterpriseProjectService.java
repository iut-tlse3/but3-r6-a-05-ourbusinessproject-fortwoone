package ourbusinessproject.ourbusinessproject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Project project = new Project();
        project.setTitle(title);
        project.setDescription(description);
        project.setEnterprise(enterprise);
        entityManager.persist(project);
        entityManager.flush();
        enterprise.addProject(project);
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

    public List<Project> findAllProjects(){
        TypedQuery<Project> query = entityManager.createQuery(
            "SELECT p FROM Project p ORDER BY title",
            Project.class
        );
        return query.getResultList();
    }

    public List<Enterprise> findAllEnterprises(){
        TypedQuery<Enterprise> query = entityManager.createQuery(
            "SELECT e FROM Enterprise e JOIN FETCH e.projects",
            Enterprise.class
        );
        return query.getResultList();
    }

    public Project findProjectById(Long id){
        return entityManager.find(Project.class, id);
    }

    public Enterprise findEnterpriseById(Long id){
        return entityManager.find(Enterprise.class, id);
    }
}
