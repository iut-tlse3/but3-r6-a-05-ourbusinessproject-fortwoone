package ourbusinessproject.ourbusinessproject;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class InitializationService {
    @Autowired
    private EnterpriseProjectService enterpriseProjectService;

    private Enterprise e1, e2;
    private Project p1, p2, p3;

    @Transactional
    public void initProjects(){
        e1 = enterpriseProjectService.newEnterprise(
            "Enterprise 1",
            "The first enterprise",
            "Joe Tartenpion",
            "joe.tartenpion@wanadoo.fr"
        );
        e2 = enterpriseProjectService.newEnterprise(
            "Enterprise 2",
            "The second enterprise",
            "Jules Doe",
            "jules.doe@gmail.com"
        );

        p1 = enterpriseProjectService.newProject(
            "project 1E1",
            "The first enterprise's project.",
            e1
        );
        p2 = enterpriseProjectService.newProject(
            "project 1E2",
            "The first enterprise's second project.",
            e2
        );
        p3 = enterpriseProjectService.newProject(
            "project 2E1",
            "The second enterprise's project.",
            e1
        );
    }

    public Enterprise getEnterprise1() {
        return e1;
    }

    public Enterprise getEnterprise2() {
        return e2;
    }

    public Project getProject1E1() {
        return p1;
    }

    public Project getProject1E2() {
        return p2;
    }

    public Project getProject2E1() {
        return p3;
    }
}
