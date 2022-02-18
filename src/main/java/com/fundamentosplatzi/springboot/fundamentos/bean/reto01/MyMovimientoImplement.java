package com.fundamentosplatzi.springboot.fundamentos.bean.reto01;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyMovimientoImplement implements MyMovimiento{
    Log LOGGER = LogFactory.getLog(MyMovimientoImplement.class);

    private int stock = 10;

    @Override
    public int egress(int quantity) {
        LOGGER.debug(stock + " se resta con " + quantity);
        return stock - quantity;
    }
}
