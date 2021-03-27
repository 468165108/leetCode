package webflux;


import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class testWebfux {

    private static final Logger log= LoggerFactory.getLogger(testWebfux.class);


    @Test
    public void TestWebFlux11() {
        log.info("121212");
    }


    @Test
    public void TestWebFlux01() {

        Mono.fromCallable(() -> {
            Map<String, String> map = new HashMap<>();
            map.put("name", "瓜田李下");
            map.put("age", "20");
            return map;
        }).flatMap(map -> {
            Person person = new Person();
            person.setName(map.get("name"));
            person.setAge(Integer.parseInt(map.get("age")));
            return Mono.just(person);
        }).subscribe(System.out::println);
    }

    @Test
    public void TestWebFlux02() {
        Mono<Person> user = findCurrentUser();
        user.subscribe(a-> log.info(JSON.toJSONString(a)));
    }

    @Test
    public void TestWebFlux03() {
        Flux<Integer> numbers = Flux
                .just(1, 2, 3, 4)
                .log();
        numbers
                .reduce(Integer::sum)
                .subscribe(sum -> log.info("Sum is: {}", sum));
        numbers
                .reduce((a, b) -> a * b)
                .subscribe(product -> log.info("Product is: {}", product));
    }


    public Mono<Person> findCurrentUser() {
        if (1 == 1) return Mono.just(new Person("Jane", 1));
        else return Mono.empty();
    }


    @Test
    public void TestWebFlux04() {
        AtomicInteger sum = new AtomicInteger(0);
        log.info("Sum is: {}", sum.get());

        Flux
                .just(1, 2, 3, 4)
                .reduce(Integer::sum)
                .subscribe(sum::set);
        System.out.println("Sum is: {}"+sum.get());
        log.info("Sum is: {}", sum.get());
    }

}

