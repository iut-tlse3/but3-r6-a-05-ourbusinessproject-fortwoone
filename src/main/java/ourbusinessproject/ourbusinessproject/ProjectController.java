package ourbusinessproject.ourbusinessproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;

@RestController
public class ProjectController {
    public record ReturnedProject(String title, String description, String enterprise){
        public ReturnedProject(Project p){
            this(p.getTitle(), p.getDescription(), p.getEnterprise().getName());
        }
    }

    private EnterpriseProjectService enterpriseProjectService;

    public ProjectController(EnterpriseProjectService enterpriseProjectService){
        this.enterpriseProjectService = enterpriseProjectService;
    }

    @GetMapping("/api/projects")
    public @ResponseBody List<ReturnedProject> findAllProjectsWithEnterprises(){
        List<Enterprise> enterprises = enterpriseProjectService.findAllEnterprises();
        List<ReturnedProject> returned = new ArrayList<>();

        enterprises.forEach(
            (Enterprise e) -> {
                e.getProjects().forEach(
                    (Project p) -> returned.add(new ReturnedProject(p))
                );
            }
        );

        return returned;
    }
}
