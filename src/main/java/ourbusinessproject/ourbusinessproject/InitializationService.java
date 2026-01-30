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

    @Autowired
    private PartnershipService partnershipService;

    private Enterprise e1, e2;
    private Project p1, p2, p3;
    private Partnership pa1, pa2, pa3;


    @Transactional
    public void initProjects(){
        // Si l'on tente d'insérer un projet invalide dans le corps de cette méthode,
        // aucun des trois projets ne sera sauvegardé. En effet, comme nous effectuons les ajouts
        // depuis une transaction, toute opération qui échoue entraîne l'annulation de tous les changements demandés.
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

    @Transactional
    public void initPartnerships(){
        pa1 = partnershipService.newPartnership(p1, e2);
        pa2 = partnershipService.newPartnership(p2, e1);
        pa3 = partnershipService.newPartnership(p3, e2);
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

    public Partnership getPartnershipP1E1WithE2() {
        return pa1;
    }

    public Partnership getPartnershipP1E2WithE1() {
        return pa2;
    }

    public Partnership getPartnershipP2E1WithE2(){
        return pa3;
    }
}
