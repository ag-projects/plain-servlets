package com.agharibi.websockets;

import com.agharibi.domain.Order;
import org.json.JSONObject;

import javax.websocket.Session;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KitchenDisplaySessionHandler {

    private List<Session> sessions = new ArrayList();

    public void addSession(Session session) {
        sessions.add(session);
    }

    public void removeSession(Session session) {
        sessions.remove(session);
    }

    private void sendMessage(JSONObject message) {
        for (Session session : sessions) {
            try {
                session.getBasicRemote().sendText(message.toString());
            } catch (IOException e) {
                this.removeSession(session);
            }
        }
    }

    public void newOrder(Order order) {
        JSONObject json = new JSONObject();
        json.append("id", order.getId().toString());
        json.append("status", order.getStatus());
        json.append("content", order.toString());

        json.append("action", "add");
        json.append("update", new Date().toString());

        this.sendMessage(json);
    }
}