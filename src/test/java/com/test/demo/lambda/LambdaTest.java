package com.test.demo.lambda;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author:cai.chaoxiong
 * @Date: 2019/2/26 9:48
 */
public class LambdaTest {
    @Test
    public void givenPreLambda_whenSortingEntitiesByName_thenCorrectlySorted() {
        List<Human> humans = Lists.newArrayList(new Human("Sarah", 10), new Human("Jack", 12));
        Collections.sort(humans, new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return h1.getName().compareTo(h2.getName());
            }
        });
        Assert.assertThat(humans.get(0), equalTo(new Human("Jack", 12)));
    }
    @Test
    public void whenSortingEntitiesByName_thenCorrectlySorted() {
        List<Human> humans = Lists.newArrayList(new Human("Sarah", 10), new Human("Jack", 12));

        //humans.sort((Human h1, Human h2) -> h1.getName().compareTo(h2.getName()));
        humans.sort(Comparator.comparing( Human::getName ));
        Assert.assertThat(humans.get(0).getName(), equalTo(new Human("Jack", 12).getName()));
    }
    @Test
    public void whenSortingEntitiesByNameThenAge_thenCorrectlySorted() {
        List<Human> humans = Lists.newArrayList(
                new Human("Sarah", 12), new Human("Sarah", 10), new Human("Zack", 12));

        humans.sort((lhs, rhs) -> {
            if (lhs.getName().equals(rhs.getName())) {
                return lhs.getAge() - rhs.getAge();
            } else {
                return lhs.getName().compareTo(rhs.getName());
            }
        });
        Assert.assertThat(humans.get(0).getName(), equalTo(new Human("Sarah", 10).getName()));
    }
    @Test
    public void givenComposition_whenSortingEntitiesByNameThenAge_thenCorrectlySorted() {
        List<Human> humans = Lists.newArrayList(
                new Human("Sarah", 12), new Human("Sarah", 10), new Human("Zack", 12));

        humans.sort(Comparator.comparing(Human::getName).thenComparing(Human::getAge));
        Assert.assertThat(humans.get(0).getName(), equalTo(new Human("Sarah", 10).getName()));
    }

    @Test
    public void interfaceTest(){
        String resulte = new Deal().say((msg)->{
            System.out.println(msg);
            return msg;
        });
    }

}
