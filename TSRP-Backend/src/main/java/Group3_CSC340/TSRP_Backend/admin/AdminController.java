package Group3_CSC340.TSRP_Backend.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/user")
public class AdminController {

    @Autowired
    private AdminService service;

    @GetMapping("/login")
    public String showLogin(){
        return "login";
    }

    @GetMapping("/main")
    public String showAdminMain(){
        return "admin";
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