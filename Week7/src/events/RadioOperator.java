/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

/**
 *
 * @author Georgi
 */
public class RadioOperator {

    private EventListener[] listeners;
    private int currentIdx;

    public RadioOperator(int maximumListeners) {
        listeners = new EventListener[maximumListeners];
        currentIdx = 0;
    }

    public void addListener(EventListener listener) {
        if (currentIdx > listeners.length) {
            System.err.println("Can't add more listeners!");
        } else {
            listeners[currentIdx++] = listener;
        }        
    }

    public void fireBroadcastEvent(RadioEvent event) {
        for (int i = 0; i < currentIdx; i++) {
            EventListener listener = listeners[currentIdx];
            if (listener != null) {
                listener.react(event);
            }
        }
    }

}
