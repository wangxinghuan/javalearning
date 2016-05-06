package javatest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wang on 16-5-6.
 */
public class HouseControllerTest {
    public static void main(String[] args) {
        HouseController controller = new HouseController();
        controller.addEvent(controller.new LightOn(10));
        controller.addEvent(controller.new LightOff(20));
        List<IEvent> eventList = new ArrayList<IEvent>();
        eventList.add(controller.new LightOn(10));
        eventList.add(controller.new LightOff(20));
        HouseController.Restart restart = controller.new Restart(30, eventList);
        controller.addEvent(restart);
        controller.start();
    }
}
