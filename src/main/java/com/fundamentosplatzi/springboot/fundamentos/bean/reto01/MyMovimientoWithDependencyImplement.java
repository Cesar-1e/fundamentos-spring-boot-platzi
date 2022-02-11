package com.fundamentosplatzi.springboot.fundamentos.bean.reto01;

public class MyMovimientoWithDependencyImplement implements MyMovimientoWithDependency{
    private MyMovimiento myMovimiento;

    public MyMovimientoWithDependencyImplement(MyMovimiento myMovimiento) {
        this.myMovimiento = myMovimiento;
    }

    @Override
    public void printEgress(int quantity) {
        System.out.println("Tengo 10 en el stock y voy a retirar " + quantity + ", me quedan: " + myMovimiento.egress(quantity));
    }
}
