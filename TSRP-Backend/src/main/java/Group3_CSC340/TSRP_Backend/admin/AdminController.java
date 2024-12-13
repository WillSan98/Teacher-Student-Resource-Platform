package Group3_CSC340.TSRP_Backend.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import Group3_CSC340.TSRP_Backend.Class.ClassService;
import Group3_CSC340.TSRP_Backend.Club.ClubService;

@Controller
@RequestMapping("/user")
public class AdminController {

    @Autowired
    private AdminService service;

    @Autowired
    private ClassService cService;

    @Autowired
    private ClubService clubService;

    @GetMapping("/start")
    public String showLogin(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, 
                        @RequestParam("password") String password, 
                        Model model) {
        User user = service.loginUser(email, password);

        if (user != null) {
            model.addAttribute("user", user);
            switch (user.getUserType()) {
                case "Student":
                    return "redirect:/student/" + user.getUserId();
                case "Teacher":
                    return "redirect:/teacher/" + user.getUserId();
                case "Admin":
                    return "redirect:/user/" + user.getUserId();
                default:
                    return "error";
            }
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "redirect:/user/start";
        }
    }    

    @GetMapping("/{userId}")
    public String showAdminMain(){
        return "admin";
    }

    @GetMapping("/classes")
    public String showAdminClass(Model model){
        model.addAttribute("classList", cService.getAllClasses());
        return "a_classes";
    }

    @GetMapping("/clubs")
    public String showAdminClubs(Model model){
        model.addAttribute("classList", clubService.getAllClubs());
        return "a_clubs";
    }

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("userList", service.getActiveUsers());
        model.addAttribute("banList", service.getBannedUsers());
        return "a_users";
    }

    @GetMapping("/createUser")
    public String showCreateUser(){
        return "u_create";
    }
    @PostMapping("/new")
    public String addNewUser(User user) {
        service.saveUser(user);
        return "redirect:/user/all";
    }

    @GetMapping("/update/{userId}")
    public String showUpdateUser(@PathVariable int userId, Model model){
        model.addAttribute("user", service.getUserById(userId));
        return "u_update";
    }
    @PostMapping("/update")
    public String updateUser(User user) {
        service.saveUser(user);
        return "redirect:/user/all";
    }

    @GetMapping("/banUser/{userId}")
    public String banUser(@PathVariable int userId) {
        service.banUser(userId);
        return "redirect:/user/all";
    }

    @GetMapping("/unBanUser/{userId}")
    public String unBanUser(@PathVariable int userId) {
        service.unBanUser(userId);
        return "redirect:/user/all";
    }

    @GetMapping("/delete/{userId}")
    public String deleteUserById(@PathVariable int userId) {
        service.deleteUserById(userId);
        return "redirect:/user/all";
    }

}