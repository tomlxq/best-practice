package com.tom.example2.mapper;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2021/1/10
 */

import com.tom.entity.StudentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface StudentMapper {

    public StudentEntity getStudentById(int id);

    public int addStudent(StudentEntity student);

    public int updateStudentName(@Param("name") String name, @Param("id") int id);

    public StudentEntity getStudentByIdWithClassInfo(int id);

    /**
     * 4selectKey 标签
     * 在insert语句中，在Oracle经常使用序列、在MySQL中使用函数来自动生成插入表的主键，而且需要方法能返回这个生成主键。
     * 使用myBatis的selectKey标签可以实现这个效果。
     * @param entity
     */
    void createStudentAutoKey(StudentEntity entity);

    /**
     * 5if标签
     * @param entity
     * @return
     */
    List<StudentEntity> getList_if(StudentEntity entity);
    public List<StudentEntity> getStudentListByClassIds_foreach_array(String[] classIds);

    public List<StudentEntity> getStudentListByClassIds_foreach_list(List<String> classIdList);


}
