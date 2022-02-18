package com.fundamentosplatzi.springboot.fundamentos.bean.reto01;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyMovimientoWithDependencyImplement implements MyMovimientoWithDependency{
    Log LOGGER = LogFactory.getLog(MyMovimientoWithDependencyImplement.class);
    private MyMovimiento myMovimiento;

    public MyMovimientoWithDependencyImplement(MyMovimiento myMovimiento) {
        this.myMovimiento = myMovimiento;
    }

    @Override
    public void printEgress(int quantity) {
        int saldo = myMovimiento.egress(quantity);
        LOGGER.info("El resultado debe ser: " + saldo);
        System.out.println("Tengo 10 en el stock y voy a retirar " + quantity + ", me quedan: " + saldo);
    }
}
