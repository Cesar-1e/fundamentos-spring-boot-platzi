package com.fundamentosplatzi.springboot.fundamentos.bean.reto01;

public class MyMovimientoImplement implements MyMovimiento{
    private int stock = 10;

    @Override
    public int egress(int quantity) {
        return stock - quantity;
    }
}
