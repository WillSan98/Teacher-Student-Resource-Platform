package Group3_CSC340.TSRP_Backend.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/request")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @GetMapping("/all")
    public String getAllRequests(Model model) {
        model.addAttribute("a_List", requestService.getARequests());
        model.addAttribute("freeList", requestService.getNRequests());
        return "a_requests";
    }

    @GetMapping("/createRequest")
    public String showCreateRequest(){
        return "r_create";
    }
    @PostMapping("/new")
    public String addNewRequest(Request request) {
        requestService.saveRequest(request);
        return "redirect:/request/all";
    }

    @PostMapping("/update")
    public String updateRequest(Request request) {
        requestService.saveRequest(request);
        return "redirect:/request/all";
    }

    @GetMapping("/{r_Id}")
    public Request getOneRequest(@PathVariable int r_Id) {
        return requestService.getRequestById(r_Id);
    }

    @GetMapping("/acceptRequest/{r_Id}")
    public String acceptRequest(@PathVariable int r_Id) {
        requestService.acceptRequest(r_Id);
        return "redirect:/request/all";
    }

    @GetMapping("/freeRequest/{r_Id}")
    public String freeRequest(@PathVariable int r_Id) {
        requestService.freeRequest(r_Id);
        return "redirect:/request/all";
    }

    @GetMapping("/delete/{r_Id}")
    public String deleteRequestById(@PathVariable int r_Id) {
        requestService.deleteRequestById(r_Id);
        return "redirect:/request/all";
    }

}