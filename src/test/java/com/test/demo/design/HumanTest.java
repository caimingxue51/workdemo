package com.test.demo.design;

import com.test.demo.worktest.Student;
import com.test.demo.design.decorator.*;
import org.junit.Test;
 
public class HumanTest {
 
    //实例化中年男士对象
    @Test
    public void middleMan() {
        Human middle = new MiddleAge();
        Human middleMan = new MaleHuman(middle);
        System.out.print(middleMan.disguise());
    }
 
    //实例化老婆婆对象
    @Test
    public void oldWoman() {
        Human old = new OldAge ();
        Human oldWoman = new FemaleHuman(old);
        System.out.print(oldWoman.disguise());
    }
    @Test
    public void newStudent(){
        Student student = Student.ofName("zs").setAge(1);;
        //student.setAge(1).setName( "a" );
        System.out.println(student);
    }
}
