package com.tom.json;

import com.alibaba.fastjson.JSON;
import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.caucho.hessian.io.Hessian2StreamingInput;
import com.caucho.hessian.io.Hessian2StreamingOutput;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tom.serialize.Person;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/5
 */
public class TestJson {

    public static final int MAX_TIMES = 100000;

    public static void main(String[] args) throws IOException {
        testJson();
        testFastJson();
        testProtobuf();
        testHessian();
    }

    private static void testProtobuf() throws IOException {
        Person person = initPerson();
        byte[] bytes = null;
        Codec<Person> objectMapper = ProtobufProxy.create(Person.class, false);
        long start = System.currentTimeMillis();
        for (int i = 0; i < MAX_TIMES; i++) {
            bytes = objectMapper.encode(person);
        }
        Person parse = objectMapper.decode(bytes);
        System.out.println("花费时间jprotobuf：" + (System.currentTimeMillis() - start) + " ms  总大小：" + bytes.length);
        System.out.println(JSON.toJSONString(parse, true));
    }

    private static void testJson() throws IOException {
        Person person = initPerson();
        byte[] bytes = null;
        ObjectMapper objectMapper = new ObjectMapper();
        long start = System.currentTimeMillis();
        for (int i = 0; i < MAX_TIMES; i++) {
            bytes = objectMapper.writeValueAsBytes(person);

        }
        Person parse = objectMapper.readValue(bytes, Person.class);
        System.out.println("花费时间jackson：" + (System.currentTimeMillis() - start) + " ms  总大小：" + bytes.length);
        System.out.println(JSON.toJSONString(parse, true));
    }

    /**
     * fastjson
     */
    private static void testFastJson() {
        Person person = initPerson();
        String s = null;
        long start = System.currentTimeMillis();
        for (int i = 0; i < MAX_TIMES; i++) {
            s = JSON.toJSONString(person);
        }
        Person parse = JSON.parseObject(s, Person.class);
        System.out.println("花费时间fastjson：" + (System.currentTimeMillis() - start) + " ms  总大小：" + s.getBytes().length);
        System.out.println(JSON.toJSONString(parse, true));
    }

    private static void testHessian() throws IOException {
        Person person = initPerson();
        long start = System.currentTimeMillis();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Hessian2StreamingOutput h2so = new Hessian2StreamingOutput(baos);
        for (int i = 0; i < MAX_TIMES; i++) {
            h2so.writeObject(person);
        }
        byte[] bytes = baos.toByteArray();
        Hessian2StreamingInput h2si = new Hessian2StreamingInput(new ByteArrayInputStream(bytes));
        Person parse = (Person) h2si.readObject();
        System.out.println("花费时间Hessian：" + (System.currentTimeMillis() - start) + " ms  总大小：" + bytes.length);
        System.out.println(JSON.toJSONString(parse, true));
    }

    private static Person initPerson() {
        Person person = new Person();
        person.setName("罗贯中");
        person.setAge(29);
        person.setBirthday(new Date());
        return person;
    }
}
