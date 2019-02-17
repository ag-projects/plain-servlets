package com.agharibi.websockets;

public class KitchenDisplaySessionHandlerFactory {

    private static KitchenDisplaySessionHandler handler;

    public static KitchenDisplaySessionHandler getHandler() {

        if (handler == null) {
            handler = new KitchenDisplaySessionHandler();
        }
        return handler;
    }
}
