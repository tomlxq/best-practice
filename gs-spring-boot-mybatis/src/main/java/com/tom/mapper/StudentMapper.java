package com.tom.mapper;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2021/1/10
 */

import com.tom.entity.StudentEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    public StudentEntity getStudentById(int id);

    public int addStudent(StudentEntity student);

    public int updateStudentName(@Param("name") String name, @Param("id") int id);

    public StudentEntity getStudentByIdWithClassInfo(int id);

    void createStudentAutoKey(StudentEntity entity);

    List<StudentEntity> getList_if(StudentEntity entity);
    public List<StudentEntity> getStudentListByClassIds_foreach_array(String[] classIds);

    public List<StudentEntity> getStudentListByClassIds_foreach_list(List<String> classIdList);
}
