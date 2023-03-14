package com.siemens.firstproject.repository;
import com.siemens.firstproject.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeacherRepository extends JpaRepository<Teacher , Integer> {
    Teacher getTeacherByEmail(String email);
    Teacher getTeacherByFirstName(String firstName);


    @Query("SELECT t FROM Teacher t WHERE t.firstName LIKE %:letter% OR t.lastName LIKE %:letter%")
    default Teacher[] getTeachersByFirstNameOrLastName(String letter){
        return findAll().stream()
                .filter(teacher -> teacher.getFirstName().contains(letter) || teacher.getLastName().contains(letter))
                .toArray(Teacher[]::new);
    }
}
