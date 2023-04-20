package com.tom.mapper;

import com.tom.entity.StudentEntity;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * TestMapper
 *
 * @author TomLuo
 * @date 2023年04月20日 22:33
 */
@SpringBootTest
@MapperScan(basePackages = "com.tom.mapper")
public class TestMapper {
    @Autowired
    private StudentMapper studentMapper;
    @Test
    public void test7_foreach() {
        String[] classIds = { "20000001", "20000002" };
        List<StudentEntity> list = this.studentMapper.getStudentListByClassIds_foreach_array(classIds);
        for (StudentEntity e : list) {
            System.out.println(e.toString());
        }
    }
    @Test
    public void test7_2_foreach() {
        ArrayList<String> classIdList = new ArrayList<String>();
        classIdList.add("20000001");
        classIdList.add("20000002");
        List<StudentEntity> list = this.studentMapper.getStudentListByClassIds_foreach_list(classIdList);
        for (StudentEntity e : list) {
            System.out.println(e.toString());
        }
    }
}