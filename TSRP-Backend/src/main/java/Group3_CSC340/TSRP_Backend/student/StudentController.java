package Group3_CSC340.TSRP_Backend.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService Studentservice;




    @GetMapping("/feed")
    public String getAllStudents(Model model) {
        model.addAttribute( "studentList",Studentservice.getAllStudents());
        return "posts-list";
    }

    @GetMapping("/{s_id}")
    public String getOneStudent(@PathVariable int s_id, Model model) {
       model.addAttribute("student",  Studentservice.getStudentById(s_id));
       return "s_profile";
    }

    @GetMapping("/posts")
    public String showHomeFeed() {return "redirect:/posts/all";}

    @GetMapping("/createForm")
    public String showCreateForm() {return "s_signup";}

    @PostMapping("/new")
    public String addNewStudent(Student student) {
        Studentservice.saveStudent(student);
        return "redirect:/students/" + student.getS_id();
    }

    @GetMapping("/update/{s_id}")
    public String showUpdateForm(@PathVariable int s_id, Model model) {
        model.addAttribute("student", Studentservice.getStudentById(s_id));
        return "s_profile-update";
    }

    @PostMapping("/update")
    public String updateStudent(Student student) {
        Studentservice.saveStudent(student);
        return "redirect:/students/" + student.getS_id();
    }

    @GetMapping("/delete/{s_id}")
    public String deleteStudentById(@PathVariable int s_id) {
        Studentservice.deleteStudentById(s_id);
        return "redirect:s_signup";
    }


}
