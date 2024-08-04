package lk.ijse.gdse.corePrac;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext();
        ctx.register(MyConfig.class);
        ctx.refresh();
        ctx.close();
    }
}
