package ourbusinessproject.ourbusinessproject;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class Bootstrap {
    private InitializationService initializationService;

    public Bootstrap(InitializationService initializationService){
        this.initializationService = initializationService;
    }

    @PostConstruct
    public void init(){
        try {
            initializationService.initProjects();
        }
        catch (RuntimeException e){
            e.printStackTrace();
        }
    }

    public InitializationService getInitializationService() {
        return initializationService;
    }
}
