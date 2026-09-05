package cs425final.domain;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "workshops")
public class Workshop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String description;

    private Date date;

    private Time time;

    private String venue;

    private Integer capacity;

    private Date registrationDeadline;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "workshop_id")
    private List<Registration> registrations;

    public Workshop(String title, String  description, Date date, Time time, String venue, Integer capacity, Date registrationDeadline) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.time = time;
        this.venue = venue;
        this.capacity = capacity;
        this.registrationDeadline = registrationDeadline;
    }

    public Workshop() {

    }

    public void addRegistration(Registration registration){
        registrations.add(registration);
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public String getVenue() {
        return venue;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Date getResitrationDeadline() {
        return registrationDeadline;
    }
}
