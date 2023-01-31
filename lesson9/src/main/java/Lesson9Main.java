import java.lang.annotation.Annotation;
import java.util.List;

public class Lesson9Main {
    public static void main(String[] args) {
        Class<MyClass> myClass = MyClass.class;
        Annotation[] myClassAnno = myClass.getAnnotations();
        
    }
}
