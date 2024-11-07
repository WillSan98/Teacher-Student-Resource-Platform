package Group3_CSC340.TSRP_Backend.student;

import jakarta.persistence.*;


@Entity
@Table(name ="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(nullable = false)
    private int s_id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;


    private String profileDescription;


    public Student(int s_id, String firstName, String lastName, String email, String password, String profileDescription) {
        this.s_id = s_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.profileDescription = profileDescription;
    }

    public Student(String firstName, String lastName, String email, String password, String profileDescription) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.profileDescription = profileDescription;
    }

    public Student() {

    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }
}
