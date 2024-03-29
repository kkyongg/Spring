package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("abcd");

        String name = helloLombok.getName();
        System.out.println("name = " + name);

        //@ToString -> helloLombok = HelloLombok(name=abcd, age=0)
        System.out.println("helloLombok = " + helloLombok);
    }
}
