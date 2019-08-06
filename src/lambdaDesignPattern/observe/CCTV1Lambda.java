package lambdaDesignPattern.observe;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CCTV1Lambda {
    private List<Consumer<String>> consumerList = new ArrayList<>();

    public CCTV1Lambda registerConsumer(Consumer<String> c) {
        consumerList.add(c);
        return this;
    }

    public void notifyPeople(String news) {
        for (Consumer<String> c : consumerList)
            c.accept(news);
    }
}
