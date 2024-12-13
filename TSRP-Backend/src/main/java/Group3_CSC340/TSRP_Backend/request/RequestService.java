package Group3_CSC340.TSRP_Backend.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    public List<Request> getNRequests() {
        return requestRepository.findByRequestStatusFalse();
    }

    public List<Request> getARequests() {
        return requestRepository.findByRequestStatusTrue();
    }

    public void acceptRequest(int r_Id) {
        Request request = requestRepository.findById(r_Id).orElse(null);
        if (request != null) {
            request.setRequestStatus(true);
            requestRepository.save(request);
        }
    }

    public void freeRequest(int r_Id) {
        Request request = requestRepository.findById(r_Id).orElse(null);
        if (request != null) {
            request.setRequestStatus(false);
            requestRepository.save(request);
        }
    }

    public Request getRequestById(int r_Id) {
        return requestRepository.findById(r_Id).orElse(null);
    }

    public void saveRequest(Request request){
        requestRepository.save(request);
    }

    public void deleteRequestById(int r_Id) {
        requestRepository.deleteById(r_Id);
    }
}
