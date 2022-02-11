package com.fundamentosplatzi.springboot.fundamentos.configuration;

import com.fundamentosplatzi.springboot.fundamentos.bean.*;
import com.fundamentosplatzi.springboot.fundamentos.bean.reto01.MyMovimiento;
import com.fundamentosplatzi.springboot.fundamentos.bean.reto01.MyMovimientoImplement;
import com.fundamentosplatzi.springboot.fundamentos.bean.reto01.MyMovimientoWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.bean.reto01.MyMovimientoWithDependencyImplement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation(){
        return new MyBean2Implement();
    }

    @Bean
    public MyOperation beanOperationOperation(){
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependency beanOperationOperationWithDependency(MyOperation myOperation){
        return new MyBeanWithDependencyImplement(myOperation);
    }

    @Bean
    public MyMovimiento beanMovimiento(){
        return new MyMovimientoImplement();
    }

    @Bean
    public MyMovimientoWithDependency beanMovimientoWithDependency(MyMovimiento myMovimiento){
        return new MyMovimientoWithDependencyImplement(myMovimiento);
    }
}
