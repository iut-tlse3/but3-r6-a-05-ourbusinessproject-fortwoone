package ourbusinessproject.ourbusinessproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;

@RestController
public class ProjectController {
    private EnterpriseProjectService enterpriseProjectService;

    public ProjectController(EnterpriseProjectService enterpriseProjectService){
        this.enterpriseProjectService = enterpriseProjectService;
    }

    @GetMapping("/api/projects")
    public @ResponseBody List<Project> findAllProjectsWithEnterprises(){
        return enterpriseProjectService.findAllProjects();
    }
}
