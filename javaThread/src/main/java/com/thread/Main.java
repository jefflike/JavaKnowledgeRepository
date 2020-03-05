package com.thread;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
/*        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(asyncDemo.class);
        AsyncService asyncService = (AsyncService) context.getBean("asyncService");
        asyncService.a();
        asyncService.b();*/
boolean a ;
        boolean b ;
        boolean c ;
        System.out.println( a = true && (b = true) || (c = true));
        System.out.println(a);
        System.out.println(b);
//        System.out.println(c);
    }
}
