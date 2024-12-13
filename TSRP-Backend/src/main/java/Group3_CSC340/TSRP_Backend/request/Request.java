package Group3_CSC340.TSRP_Backend.request;

import jakarta.persistence.*;

@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int r_Id;

    @Column(nullable = false)
    private String sender;

    @Column(nullable = false)
    private boolean requestStatus = false;

    private String description;

    public Request(int r_Id, String sender, boolean requestStatus, String description) {
        this.r_Id = r_Id;
        this.sender = sender;
        this.requestStatus = requestStatus;
        this.description = description;
    }

    public Request(String sender, String description) {
        this.sender = sender;
        this.description = description;
    }

    public Request() {
    }

    public int getR_Id() {
        return r_Id;
    }

    public void setR_Id(int r_Id) {
        this.r_Id = r_Id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public boolean getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(boolean requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
