package com.test.academichistory.repository;

import com.test.academichistory.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  // Se agrega la consulta para encontrar a un estudiante por el card_id(es unico como la cedula)
  @Query(value = "SELECT * FROM student s WHERE s.card_id=?1", nativeQuery = true)
  Optional<Student> findByCard_id(Long card_id);
}
