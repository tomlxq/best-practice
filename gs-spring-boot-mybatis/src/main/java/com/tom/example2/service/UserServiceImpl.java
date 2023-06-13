package com.tom.example2.service;

import org.apache.ibatis.session.SqlSessionFactory;
import com.tom.entity.Model;
import com.tom.entity.StudentEntity;
import com.tom.example2.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
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

    private final SqlSessionFactory  sqlSessionFactory;
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



    @Override
    public void insertModelBatch() {
        List<Model> list = new ArrayList<Model>();
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH);
        for (Model model : list) {
            session.insert("insertStatement", model);
        }
        session.flushStatements();
    }

    @Override
    public void insertModelBatch2() {

    }

    /*@Override
    public void insertModelBatch2() {
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH);
        try {
            ArticleMapper mapper = session.getMapper(ArticleMapper.class);
            Article row = new Article();
            row.setId(100L);
            row.setTitle("Joe");
            row.setAuthor("Jones");


            InsertStatementProvider<Article> insertStatement = insert(row)
                    .into(simpleTable)
                    .map(id).toProperty("id")
                    .map(firstName).toProperty("firstName")
                    .map(lastName).toProperty("lastName")
                    .map(birthDate).toProperty("birthDate")
                    .map(employed).toProperty("employed")
                    .map(occupation).toProperty("occupation")
                    .build()
                    .render(RenderingStrategies.MYBATIS3);

            int rows = mapper.insert(insertStatement);
        } finally {
            session.close();
        }
    }*/
}