package com.tom.service;

import com.tom.entity.StudentEntity;
import com.tom.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * UserServiceImpl
 *
 * @author TomLuo
 * @date 2023年03月18日 1:11
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final StudentMapper studentMapper;

    @Override

    public void createUser() {
        StudentEntity entity = new StudentEntity();
        entity.setName("黎明你好");
        entity.setSex(1);
        entity.setBirthday(new Date());
        entity.setClassId("20000001");
        entity.setPlaceId("70000001");
        this.studentMapper.createStudentAutoKey(entity);
        log.info("新增学生ID: " + entity.getId());
    }

    @Override
    public void select_test_2_1() {
        StudentEntity entity = new StudentEntity();
        entity.setName("");
        entity.setSex(1);
        entity.setBirthday(new Date());
        entity.setClassId("20000001");
        //entity.setPlaceId("70000001");
        List<StudentEntity> list = this.studentMapper.getList_if(entity);
        for (StudentEntity e : list) {
            log.info(e.toString());
        }
    }

    @Override
    public void test7_2_foreach() {
        ArrayList<String> classIdList = new ArrayList<String>();
        classIdList.add("20000001");
        classIdList.add("20000002");
        List<StudentEntity> list = this.studentMapper.getStudentListByClassIds_foreach_list(classIdList);
        for (StudentEntity e : list) {
            log.info(e.toString());
        }
    }



}