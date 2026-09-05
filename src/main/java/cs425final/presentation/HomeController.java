package cs425final.presentation;

import cs425final.application.WorkshopService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private WorkshopService workshopService;

    public HomeController(WorkshopService workshopService){
        this.workshopService = workshopService;
    }

    @GetMapping("/ping")
    public String ping(){
        workshopService.seed();
        return "cs425final is running!";
    }
}
