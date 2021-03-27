package webflux;


import org.junit.Test;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

public class testWebfux {

    @Test
    public void TestWebFlux01() {

        Mono.fromCallable(()->{
            Map<String,String> map=new HashMap<>();
            map.put("name","瓜田李下");
            map.put("age","20");
            return map;
        }).flatMap(map ->{
            Person person=new Person();
            person.setName(map.get("name"));
            person.setAge(Integer.parseInt(map.get("age")));
            return Mono.just(person);
        }).subscribe(System.out::println);
    }


}

