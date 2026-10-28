import java.util.*;

public class EventParticipants {

    public static Set<Integer> findAllParticipants(
            Set<Integer> event1,
            Set<Integer> event2) {
        Set<Integer> all = new HashSet<>(event1);
        all.addAll(event2);
        return all;
    }

    public static void main(String[] args) {
        Set<Integer> event1 =
                new HashSet<>(Arrays.asList(101, 102, 103));
        Set<Integer> event2 =
                new HashSet<>(Arrays.asList(103, 104, 105));

        Set<Integer> result =
                findAllParticipants(event1, event2);

        System.out.println(result);
    }
}
