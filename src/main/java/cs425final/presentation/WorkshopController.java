package cs425final.presentation;

import cs425final.application.WorkshopService;
import cs425final.application.dtos.ApiResponse;
import cs425final.application.dtos.RegistrationRequest;
import cs425final.domain.Workshop;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WorkshopController {
    private WorkshopService workshopService;

    public WorkshopController(WorkshopService workshopService){
        this.workshopService = workshopService;
    }

    @GetMapping("workshops/{id}")
    public Optional<Workshop> getWorkshop(@PathVariable int id){
        return workshopService.getWorkshop(id);
    }

    @GetMapping("workshops")
    public List<Workshop> getWorkshops(){
        return workshopService.getWorkshops();
    }

    @PostMapping("workshops/register")
    public ApiResponse registerStudent(@RequestBody RegistrationRequest request){
        return workshopService.registerStudent(request);
    }
}
