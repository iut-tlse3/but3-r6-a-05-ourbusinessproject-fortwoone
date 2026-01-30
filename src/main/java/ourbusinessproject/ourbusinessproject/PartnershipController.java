package ourbusinessproject.ourbusinessproject;

import org.springframework.web.bind.annotation.*;

@RestController
public class PartnershipController {
    private EnterpriseProjectService enterpriseProjectService;
    private PartnershipService partnershipService;

    public PartnershipController(EnterpriseProjectService eps, PartnershipService ps){
        enterpriseProjectService = eps;
        partnershipService = ps;
    }

    @PostMapping("/api/v1/partnerships")
    public @ResponseBody Partnership addPartnership(Long project_id, Long enterprise_id){
        return partnershipService.newPartnership(
            enterpriseProjectService.findProjectById(project_id),
            enterpriseProjectService.findEnterpriseById(enterprise_id)
        );
    }

    @DeleteMapping("/api/v1/partnerships/{id}")
    public void removePartnership(@PathVariable Long id){
        partnershipService.remove(partnershipService.findPartnershipById(id));
    }
}
