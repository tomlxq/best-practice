package com.example;

import com.example.entity.CompResult;
import com.example.entity.Competition;
import com.example.entity.ConsultInfoResp;
import com.example.entity.ConsultOrder;
import com.example.entity.PatientInfo;
import com.example.entity.Student;
import com.example.entity.User;
import com.example.lib.OptionalUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Properties;

import static com.example.lib.OptionalUtils.getChampionName;
import static com.example.lib.OptionalUtils.getChampionName2;
import static com.example.lib.OptionalUtils.isEmpty;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * OptionalTest
 *
 * @author TomLuo
 * @date 2023年06月13日 19:21
 */
@Slf4j
public class OptionalTest {
    /**
     * 创建Optional类
     */
    @Test
    public void test1() {
        // 声明一个空Optional
        Optional<Object> empty = Optional.empty();

        // 依据一个非空值创建Optional
        Student student = new Student();
        Optional<Student> os1 = Optional.of(student);
        log.info("{}", os1);

        // 可接受null的Optional
        Student student1 = null;
        Optional<Student> os2 = Optional.ofNullable(student1);
        log.info("{}", os2);
    }

    /**
     * 判断Optional容器中是否包含对象
     */
    @Test
    public void test2() {
        Student student = new Student();
        Optional<Student> os1 = Optional.ofNullable(student);
        boolean present = os1.isPresent();
        log.info("{}", present);

        // 利用Optional的ifPresent方法做出如下：当student不为空的时候将name赋值为张三
        Optional.ofNullable(student).ifPresent(p -> p.setName("张三"));

    }

    /**
     * 获取Optional容器的对象
     *
     * @throws Exception
     */
    @Test
    public void test3() throws Exception {
        Student student = null;
        Optional<Student> os1 = Optional.ofNullable(student);
        // 使用get一定要注意，假如student对象为空，get是会报错的
        // java.util.NoSuchElementException: No value present
        assertThrows(NoSuchElementException.class, () -> os1.get());

        // 当student为空的时候,返回我们新建的这个对象,有点像三目运算的感觉
        Student student2 = os1.orElse(new Student("张三", 18));
        log.info("{}", student2);
        // orElseGet就是当student为空的时候，返回通过Supplier供应商函数创建的对象
        Student student3 = os1.orElseGet(() -> new Student("张三", 18));
        log.info("{}", student3);
        // orElseThrow就是当student为空的时候，可以抛出我们指定的异常
        assertThrows(Exception.class, () -> os1.orElseThrow(() -> new Exception()));
    }

    /**
     * 过滤
     */
    @Test
    public void test4() {
        Student student = new Student("李四", 3);
        Optional<Student> os1 = Optional.ofNullable(student);
        os1.filter(p -> p.getName().equals("张三")).ifPresent(x -> System.out.println("OK"));
    }

    /**
     * 映射
     */
    @Test
    public void test5() {
        Student student = new Student("李四", 3);
        Optional<Student> os1 = Optional.ofNullable(student);
        // 如果student对象不为空，就加一岁
        Optional<Student> emp = os1.map(e ->
        {
            e.setAge(e.getAge() + 1);
            return e;
        });
        log.info("{}", emp);
        Properties props = new Properties();

        String name = "name";
        props.put(name, "123");
        final Integer integer = Optional.ofNullable(props.getProperty(name))
                .flatMap(OptionalUtils::stringToInt)
                .filter(i -> i > 0)
                .orElse(0);

        log.info("{}", integer);
    }

    @Test
    public void test6() {
        ConsultOrder consultOrder=new ConsultOrder();
        ConsultInfoResp  consultInfoResp=new ConsultInfoResp();
        PatientInfoDao patientInfoDao=new PatientInfoDao();
        PatientInfo patientInfo = patientInfoDao.getPatientInfoById(consultOrder.getPatientId());
        if (patientInfo != null) {
            consultInfoResp.setPatientHead(patientInfo.getHead());
        }
        log.info("{}", consultInfoResp);
        ConsultInfoResp  consultInfoResp2=new ConsultInfoResp();
        // 使用Optional 和函数式编程，一行搞定，而且像说话一样
        Optional.ofNullable(patientInfo).ifPresent(p -> consultInfoResp2.setPatientHead(p.getHead()));
        log.info("{}", consultInfoResp2);
    }
    @Test
    public void test7() throws Exception {
        Student student = new Student(null, 3);
        assertThrows(Exception.class,()->{
        if (student == null || isEmpty(student.getName())) {
            throw new Exception();
        }}
        );
        String name = student.getName();
        // 业务省略...

        // 使用Optional改造
        assertThrows(Exception.class,()-> {
            Optional.ofNullable(student).filter(s -> !isEmpty(s.getName())).orElseThrow(() -> new Exception());
        });
    }

    /**
     * 去判读传进来的参数时候为空，或者是从数据库中获取的对象。由于某些原因，我们不能很流程的直接这样写。
     * @throws Exception
     */
    @Test
    public void test8() throws Exception {
        Competition comp=new Competition();
        comp.setResult(new CompResult());

        assertThrows( IllegalArgumentException.class,()->getChampionName(comp));
        assertThrows( IllegalArgumentException.class,()->getChampionName2(comp));
        comp.getResult().setChampion(new User());
        comp.getResult().getChampion().setName("123");
        log.info("{}", getChampionName(comp));
        log.info("{}", getChampionName2(comp));
    }

    /**
     * 类型之间的转换，并且当没有值的时候返回一个默认值
     * @throws Exception
     */

    @Test
    public void test9() throws Exception {
        RedisProperties redisProperties=new RedisProperties();
    int timeout = Optional.ofNullable(redisProperties.getTimeout())
            .map(x -> Long.valueOf(x.toMillis()).intValue())
            .orElse(10000);
    }
}