package com.test.demo.worktest;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Setter
@Getter
@RequiredArgsConstructor(staticName = "ofName")
public class Student {
    @NonNull private String name;
    private int age;
}