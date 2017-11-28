/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radio;

/**
 *
 * @author Georgi
 */
public class RadioTest {

    private String text = "Closure";

    private class RadioListener implements EventListener {

        @Override
        public void react(RadioEvent event) {
            System.out.println(text);
        }

    }

    public EventListener getListener() {
        return new RadioListener();
    }

    public static void main(String[] args) {
        RadioOperator operator = new RadioOperator(100);

        // Create an annonumous listener
        operator.addListener(new EventListener() {
            @Override
            public void react(RadioEvent event) {
                System.out.printf("Listener 1 is not happy with the event %s\n", event.getMessage());
            }
        });

        operator.addListener(new EventListener() {
            @Override
            public void react(RadioEvent event) {
                System.out.printf("Listener 2 is happy with the event %s\n", event.getMessage());
            }
        });

        operator.addListener(new EventListener() {
            @Override
            public void react(RadioEvent event) {
                System.out.printf("Listener 3 doesn't care about %s\n", event.getMessage());
            }
        });

        operator.fireBroadcastEvent(new RadioEvent("It's going to rain"));
    }
}
