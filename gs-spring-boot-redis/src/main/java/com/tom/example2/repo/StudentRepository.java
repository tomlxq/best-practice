package com.tom.example2.repo;

import com.tom.example2.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * ssss
 *
 * @author TomLuo
 * @date 2023年04月22日 18:02
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, String> {}




