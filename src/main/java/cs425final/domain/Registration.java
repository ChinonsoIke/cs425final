package cs425final.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "registratiions")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer studentId;

    private String studentName;

    private String email;

    private Date date;

    public Registration(Integer studentId, String studentName, String email, Date date) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.email = email;
        this.date = date;
    }

    public Registration() {

    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getEmail() {
        return email;
    }

    public Date getDate() {
        return date;
    }

    public Integer getId() {
        return id;
    }
}
