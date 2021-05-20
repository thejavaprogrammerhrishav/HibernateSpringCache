package com.hdsoft.cache;


import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {
    public static void main(String[] args) throws InterruptedException {

        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("/app.xml") ;
        context.refresh();

        Service d = context.getBean(Service.class);

     /*   System.out.println(d.find());
        System.out.println(d.findAll());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println(d.findAll());*/

        MyThread m1=new MyThread(d);
        MyThread m2=new MyThread(d);
        System.out.println();



        Model byID = d.findByID(5555);
        System.out.println(byID);

        Model byID2 = d.findByID(5555);
        System.out.println(byID2);

        Model byID3 = d.findByID(5555);
        System.out.println(byID3);

        System.out.println("\n");

        m1.start();
        Thread.sleep(6000);
        m2.start();

        //all.stream().forEach(System.out::println);
    }

    static class MyThread extends Thread{
        private final Service d;

        public MyThread(Service d){
            this.d=d;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           /* for(int i=1; i<=500;i++){
                Model m=new Model();
                if(i%2==0) {
                    m.setName("Test "+i);
                }else{
                    m.setName("Name "+(i*2));
                }
                m.setContact("111122223336655447788");

                System.out.println(Thread.currentThread().getName()+" - Model Saved, ID: "+d.save(m));
            }*/
            List<Model> all = d.findAll();
            System.out.println("Size: "+all.size());

            List<Model> all2= d.findAll();
            System.out.println("Size: "+all2.size());
            System.out.println("\n");
        }
    }
}
