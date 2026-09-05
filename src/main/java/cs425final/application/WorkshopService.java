package cs425final.application;

import cs425final.application.dtos.ApiResponse;
import cs425final.application.dtos.RegistrationRequest;
import cs425final.domain.Workshop;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface WorkshopService {
    void seed();
    Optional<Workshop> getWorkshop(int id);
    List<Workshop> getWorkshops();
    ApiResponse registerStudent(RegistrationRequest request);
}
