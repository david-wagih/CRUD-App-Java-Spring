package com.siemens.firstproject.controller;
import com.siemens.firstproject.entity.Teacher;
import com.siemens.firstproject.repository.TeacherRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeacherController {

    private final TeacherRepository repo;

    public TeacherController(TeacherRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/Teacher/{email}")
    public Teacher getByEmail(@PathVariable String email){
        return repo.getTeacherByEmail(email);
    }

    @GetMapping("/Teacher")
    public Teacher[] getByFirstNameAndLastName(){
        // add the service layer method here.
        return repo.getTeachersByFirstNameOrLastName("a");

    }

    @PostMapping("/Teacher")
    public Teacher addNewTeacher(@RequestBody Teacher teacher){
        // add the service layer method here.
        return repo.save(teacher);
    }
    @DeleteMapping("/Teacher/{id}")
    public void deleteTeacher(@PathVariable Integer id){
        // add the service layer method here.
        repo.deleteById(id);
    }
}
