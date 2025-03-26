import java.util.List;
import java.util.stream.Gatherer;
import java.util.concurrent.atomic.AtomicInteger;

public class GathererExample {

    public static Gatherer<String, AtomicInteger, String> addSupermarketList() {
        return Gatherer.ofSequential(
                //counter
                AtomicInteger::new,

                Gatherer.Integrator.ofGreedy(
                        (counter, element, downstream) -> {
                            String numberedItem = counter + " - " + element;
                            downstream.push(numberedItem);
                            counter.incrementAndGet();
                            return true;
                        }),

                Gatherer.defaultFinisher());
    }

    public static void main(String[] args) {
        List<String> fruits = List.of("rice", "bread", "beans", "tomato", "onion", "apple", "orange");

        List<String> numeredSupermarketList = fruits.stream().gather(addSupermarketList()).toList();

        System.out.print(numeredSupermarketList);
    }
}

