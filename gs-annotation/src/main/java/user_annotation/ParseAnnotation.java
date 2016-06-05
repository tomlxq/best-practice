package user_annotation; /**
 * Created by tom on 2016/6/6.
 */
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ParseAnnotation {

    public static void parseTypeAnnotation() throws ClassNotFoundException {
        Class clazz = Class.forName("user_annotation.UserAnnotation");

        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            TestA testA = (TestA)annotation;
            System.out.println("id= "+testA.id()+"; name= "+testA.name()+"; gid = "+testA.gid());
        }
    }

    public static void parseMethodAnnotation(){
        Method[] methods = UserAnnotation.class.getDeclaredMethods();
        for (Method method : methods) {

            boolean hasAnnotation = method.isAnnotationPresent(TestA.class);
            if (hasAnnotation) {

                TestA annotation = method.getAnnotation(TestA.class);
                System.out.println("method = " + method.getName()
                        + " ; id = " + annotation.id() + " ; description = "
                        + annotation.name() + "; gid= "+annotation.gid());
            }
        }
    }

    public static void parseConstructAnnotation(){
        Constructor[] constructors = UserAnnotation.class.getConstructors();
        for (Constructor constructor : constructors) {

            boolean hasAnnotation = constructor.isAnnotationPresent(TestA.class);
            if (hasAnnotation) {

                TestA annotation =(TestA) constructor.getAnnotation(TestA.class);
                System.out.println("constructor = " + constructor.getName()
                        + " ; id = " + annotation.id() + " ; description = "
                        + annotation.name() + "; gid= "+annotation.gid());
            }
        }
    }
    public static void main(String[] args) throws ClassNotFoundException {
        parseTypeAnnotation();
        parseMethodAnnotation();
        parseConstructAnnotation();
    }
}
