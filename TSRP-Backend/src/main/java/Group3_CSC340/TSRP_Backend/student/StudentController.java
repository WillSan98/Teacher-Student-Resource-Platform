package Group3_CSC340.TSRP_Backend.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

        @Autowired
        private StudentService service;



    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/{s_id}")
    public Student getOneStudent(@PathVariable int s_Id) {
        return service.getStudentById(s_Id);
    }


    @PostMapping("/new")
        public List<Student> addNewStudent(@RequestBody Student student) {
            service.addNewStudent(student);
            return service.getAllStudents();
    }

    @PutMapping("/update/{s_id}")
    public Student updateStudent(@PathVariable int s_Id, @RequestBody Student student) {
        service.updateStudent(s_Id, student);
        return service.getStudentById(s_Id);
    }

    @DeleteMapping("/delete/{s_id}")
    public List<Student> deleteStudentById(@PathVariable int s_Id, @RequestBody Student student) {
        service.deleteStudentById(s_Id);
        return service.getAllStudents();
    }


}
