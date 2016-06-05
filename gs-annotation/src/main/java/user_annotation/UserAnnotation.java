package user_annotation; /**
 * Created by tom on 2016/6/6.
 */
import java.util.HashMap;
import java.util.Map;


@TestA(name="type",gid=Long.class) //类成员注解
public class UserAnnotation {
    @TestA(name="param",id=1,gid=Long.class) //类成员注解
    private Integer age;
    @TestA (name="construct",id=2,gid=Long.class)//构造方法注解
    public UserAnnotation(){
    }
    @TestA(name="public method",id=3,gid=Long.class) //类方法注解
    public void a(){
        Map m = new HashMap(0);
    }
    @TestA(name="protected method",id=4,gid=Long.class) //类方法注解
    protected void b(){
        Map m = new HashMap(0);
    }
    @TestA(name="private method",id=5,gid=Long.class) //类方法注解
    private void c(){
        Map m = new HashMap(0);
    }
    public void b(Integer a){
    }
}
