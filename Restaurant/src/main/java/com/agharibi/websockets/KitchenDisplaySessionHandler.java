package com.agharibi.websockets;

import com.agharibi.data.MenuDao;
import com.agharibi.data.MenuDaoFactory;
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
        sendAllOrders(session);
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

    private void sendMessage(JSONObject message, Session session) {
        try {
            session.getBasicRemote().sendText(message.toString());
        } catch (IOException e) {
            this.removeSession(session);
        }
    }

    private JSONObject generateJsonForOrder(Order order) {
        JSONObject json = new JSONObject();
        json.append("id", order.getId().toString());
        json.append("status", order.getStatus());
        json.append("content", order.toString());

        json.append("action", "add");
        json.append("update", new Date().toString());
        return json;
    }

    public void newOrder(Order order) {
        JSONObject json = this.generateJsonForOrder(order);
        this.sendMessage(json);
    }

    private void sendAllOrders(Session session) {
        MenuDao menuDao = MenuDaoFactory.getMenuDao();
        List<Order> orders = menuDao.getAllOrders();

        for(Order order: orders) {
            sendMessage(generateJsonForOrder(order), session);
        }
    }
}
