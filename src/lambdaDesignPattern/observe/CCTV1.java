package lambdaDesignPattern.observe;

import java.util.ArrayList;
import java.util.List;

public class CCTV1 {
    private List<People> peopleList = new ArrayList<>();

    public CCTV1 registerPeople(People p) {
        peopleList.add(p);
        return this;
    }

    public void notifyPeople(String news) {
        for (People p : peopleList)
            p.accept(news);
    }
}
