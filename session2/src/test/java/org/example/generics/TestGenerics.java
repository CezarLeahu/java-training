package org.example.generics;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static org.example.generics.StaticMethods.doSomethingElse;
import static org.example.generics.StaticMethods.randomElement;
import static org.example.generics.WithTypeRestrictions.searchMaxValue;

public class TestGenerics {
    @Test
    public void demoGenericsOnMethods() {
        Methods m = new Methods();

        m.doSomeWork("querty");
        System.out.println();

        Long l = m.doSomethingElse(1, Long.class); // no cast, the return type is known
        System.out.println("Returned: " + l);
        System.out.println();

        // this would be invalid - the second argument dictates the return type
        // String s = m.doSomethingElse(1, Long.class);
    }

    @Test
    public void demoGenericsOnStaticMethods() {
        StaticMethods.doSomeWork("querty");
        System.out.println();

        Long l = doSomethingElse(1, Long.class); // no cast, the return type is known
        System.out.println("Returned value: " + l);
        System.out.println();

        String e = randomElement("1", "2", "3", "4", "5"); // doesn't allow mixed types in the
        // collection
        System.out.println("Random element: " + e);
    }

    @Test
    public void demoGenericsOnClass() {
        Tuple<String, Integer> grade = new Tuple<>("Franz", 4);
        System.out.println(grade);

        Object leftObjRef = grade.getA(); // will work

        String leftObjRefWithCast = (String) leftObjRef;
        System.out.println("leftObjRefWithCast: " + leftObjRefWithCast);

        String leftStrRef = grade.getA(); // will work without a cast
        System.out.println("leftStrRef: " + leftStrRef);
    }

    @Test
    public void demoTypeRestrictions() {
        System.out.println(searchMaxValue(Set.of(1, 3, 5, 4, 2)));

        System.out.println(searchMaxValue(Set.of(1.0, 3.0, 5.0, 4.0, 2.0)));

        System.out.println(searchMaxValue(Set.of(0x01, 0x05, 0x10, 0x0A, 0x0F)));
    }

    @Test
    public void demoReturnTypes() {
        IocContext ctx = new IocContext();
        ctx.addBean("name", "John Doe");
        ctx.addBean("age", 27);
        ctx.addBean("admission", Instant.now());

        // Some time later

        int age = ctx.getBean("age", Integer.class);
        Date admissionDate = Date.from(ctx.getBean("admission", Instant.class));
        String name = ctx.getBean("name", String.class);

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Admission date: " + admissionDate);
    }

    @Test
    public void demoReturnTypesWithoutGenerics() {
        IocContext ctx = new IocContext();
        ctx.addBean("name", "John Doe");
        ctx.addBean("age", 27);
        ctx.addBean("admission", Instant.now());

        // Some time later

        //int age = (int) ctx.getBean("age");
        //Date admissionDate = Date.from((Instant) ctx.getBean("admission"));
        //String name = (String) ctx.getBean("name");

        Integer age = ctx.getBean("age", Integer.class);
        Date admissionDate = Date.from(ctx.getBean("admission", Instant.class));
        String name = ctx.getBean("name", String.class);

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Admission date: " + admissionDate);
    }

    @Test
    public void misc() {
        List basic = new ArrayList(); // what all generics are in practice (at run-time), no type info carried around
        basic.add(1);
        basic.add(2.0);
        basic.add('3');
        basic.add("4");
        System.out.println(basic);

        List<Object> objects = new ArrayList<>();
        objects.add(1);
        objects.add(2.0);
        objects.add('3');
        objects.add("4");
        System.out.println(objects);

        List<?> castedToUnknown = objects;
        System.out.println(castedToUnknown);

        List<?> unknown = new ArrayList<>();
        //unknown.add(1);   // compilation error
        //unknown.add(2.0); // compilation error
        //unknown.add('3'); // compilation error
        //unknown.add("4"); // compilation error
        System.out.println(unknown);

        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        System.out.println(strings);

        // Invalid casts
        // List<Object> listOfObjecs = strings; // compilation error
        // List<Object> anotherListOfObjecs = new ArrayList<Integer>(); // compilation error

        // Valid casts
        List<?> unknownStrings = strings;
        System.out.println(unknownStrings);

        Collection<String> collectionOfStrings = strings;
        System.out.println(collectionOfStrings);

        Collection<Character> chars = Set.of('x', 'y', 'z');
        System.out.println(chars);
    }
}
