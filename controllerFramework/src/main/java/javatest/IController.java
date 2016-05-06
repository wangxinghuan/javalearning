package javatest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wang on 16-5-6.
 */
public abstract class IController {
    /**
     * 设置控制类的抽象
     */
    private List<IEvent> eventList = new ArrayList<IEvent>();

    public void addEvent(IEvent event) {
        eventList.add(event);
    }

    public void removeEvent(IEvent event) {
        if (eventList.contains(event)) {
            eventList.remove(event);
        }
    }

    public void start() {
        while (eventList.size() > 0) {
            for (int i = 0; i < eventList.size(); i++) {
                IEvent event = eventList.get(i);
                event.start();
                if (event.isReady()) {
                    System.out.println(event);
                    event.action();
                    eventList.remove(event);
                    i--;
                }
            }
        }
    }
}
