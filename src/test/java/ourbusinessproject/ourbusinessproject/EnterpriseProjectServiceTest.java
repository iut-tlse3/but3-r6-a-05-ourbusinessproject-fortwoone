package ourbusinessproject.ourbusinessproject;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EnterpriseProjectServiceTest {

    private EnterpriseProjectService enterpriseProjectService;

    @Mock
    private EntityManager entityManager;
    private Project project;
    private Enterprise enterprise;

    private Long anId = 1L;

    @BeforeEach
    public void setUp() throws Exception {
        enterpriseProjectService = new EnterpriseProjectService(entityManager);
    }

    @Test
    @DisplayName("Check if a created project is persisted")
    public void testEntityManagerPersistAProjectWhenANewProjectIsCreated() {
        // when: trying to create a project
        project = enterpriseProjectService.newProject("a title", "a description");
        // then: the service delegates the entity manager to persist the project
        verify(enterpriseProjectService.getEntityManager()).persist(project);
        // and: the service asks the entity manager to synchronize with the database
        verify(entityManager).flush();
    }

    @Test
    @DisplayName("Check if a created enterprise is persisted")
    public void testEntityManagerPersistAnEnterpriseWhenEnterpriseIsSaved() {
        // when: trying to create an enterprise
        enterprise = enterpriseProjectService.newEnterprise(
                "a name",
                "a description",
                "a contact name",
                "acontact@email.com"
        );
        // then: the persist method is invoked on the entity manager
        verify(entityManager).persist(enterprise);
        // and: the service asks the entity manager to synchronize with the database
        verify(entityManager).flush();
    }

    @Test
    @DisplayName("Check if the project is found when providing the ID")
    public void testEntityManagerFindAProjectWhenProjectIsSearchedById() {
        // when: trying to save the project
        project = enterpriseProjectService.findProjectById(anId);
        // then: the service delegates the entity manager
        verify(entityManager).find(Project.class, anId);
    }

    @Test
    @DisplayName("Check if the enterprise is found when providing the ID")
    public void testEntityManagerFindAnEnterpriseWhenEnterpriseIsSearchedById() {
        // when: trying to find an enterprise
        enterprise = enterpriseProjectService.findEnterpriseById(anId);
        // then: the service delegates the entity manager
        verify(entityManager).find(Enterprise.class, anId);
    }

}