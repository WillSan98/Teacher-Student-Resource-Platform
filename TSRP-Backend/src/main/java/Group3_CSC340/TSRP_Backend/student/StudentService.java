package Group3_CSC340.TSRP_Backend.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int s_Id) {
        return studentRepository.findById(s_Id).orElse(null);
    }

    public void addNewStudent(Student student) {
        studentRepository.save(student);
    }


    public void updateStudent(int s_Id, Student student) {
        Student existing = getStudentById(s_Id);
      
        existing.setFirstName(student.getFirstName());
        existing.setLastName(student.getLastName());
        existing.setEmail(student.getEmail());
        existing.setPassword(student.getPassword());
        existing.setProfileDescription(student.getProfileDescription());

        studentRepository.save(existing);
    
    }

    public void deleteStudentById(int s_Id) {
        studentRepository.deleteById(s_Id);
    }
}
