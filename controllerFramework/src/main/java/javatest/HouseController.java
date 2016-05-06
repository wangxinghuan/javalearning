package javatest;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wang on 16-5-6.
 */
public class HouseController extends IController {
    private boolean lightOn = false;

    public class LightOn extends IEvent {

        public LightOn(long delayTime) {
            super(delayTime);
        }

        public void action() {
            if (!lightOn) {
                lightOn = true;
            }
        }

        @Override
        public String toString() {
            return eventTime + ": light on";
        }
    }

    public class LightOff extends IEvent {

        public LightOff(long delayTime) {
            super(delayTime);
        }

        public void action() {
            if (lightOn) {
                lightOn = false;
            }
        }

        @Override
        public String toString() {
            return eventTime + ": light off";
        }
    }

    public  class Restart extends IEvent {
        private List<IEvent> eventList = new ArrayList<IEvent>();

        public Restart(long delayTime, List<IEvent> eventList) {
            super(delayTime);
            this.eventList = eventList;
        }

        public void action() {
            for (IEvent event : eventList) {
                event.start();
                addEvent(event);
            }

            if (eventList != null) {
                start();
                addEvent(this);
            }

        }

        @Override
        public String toString() {
            return eventTime + ": restart events";
        }
    }

    public class Terminate extends IEvent {
        private IEvent event;

        public Terminate(IEvent event) {
            super(0);
            this.event = event;

        }

        public void action() {
            removeEvent(event);
        }

        @Override
        public String toString() {
            return "terminate event";
        }
    }
}
