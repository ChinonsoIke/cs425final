package cs425final.application;

import cs425final.application.dtos.ApiResponse;
import cs425final.application.dtos.RegistrationRequest;
import cs425final.domain.Registration;
import cs425final.domain.Workshop;
import cs425final.infrastructure.WorkshopRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Service
public class WorkshopServiceImpl implements WorkshopService{
    private final WorkshopRepository workshopRepository;

    public WorkshopServiceImpl(WorkshopRepository workshopRepository){
        this.workshopRepository = workshopRepository;
    }

    public void seed(){
        List<Workshop> workshops = workshopRepository.findAll();

        if(workshops.size() < 2){
//            List<Workshop> workshops = new ArrayList<Workshop>();
            workshops.add(new Workshop("CS Demo 1", "Lorem ipsum",
                    new Date(2022,9,14), new Time(16,0,0),
                    "Verill", 2, new Date(2022, 8, 30)));
            workshops.add(new Workshop("CS demo 2", "Lorem ipsum",
                    new Date(2026, 9, 22), new Time(16,0,0),
                    "McLaughlin", 4, new Date(2026, 9, 17)));

            workshopRepository.saveAll(workshops);
        }
    }

    public Optional<Workshop> getWorkshop(int id){
        return workshopRepository.findById(id);
    }

    public List<Workshop> getWorkshops(){
        return workshopRepository.findAll();
    }

    public ApiResponse registerStudent(RegistrationRequest request) {
        Workshop workshop = workshopRepository.findById(request.workshopId).orElseThrow();

        if(workshop.getResitrationDeadline().before(new java.util.Date())){
            return new ApiResponse(false, "Registration deadline has passed");
        }

        if(workshop.getCapacity() < 1){
            return new ApiResponse(false, "This workshop is full");
        }

        workshop.addRegistration(new Registration(request.studentId, request.studentName, request.email, new java.util.Date()));
        workshop.setCapacity(workshop.getCapacity() - 1);
        workshopRepository.save(workshop);

        return new ApiResponse(true, "Successful");
    }
}
