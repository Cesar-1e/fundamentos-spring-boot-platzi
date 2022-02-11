package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.bean.reto01.MyMovimientoWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

    private ComponentDependency componentDependency;
    private MyBean myBean;
    private MyBeanWithDependency myBeanWithDependency;
    private MyMovimientoWithDependency myMovimientoWithDependency;


    //El autowired ya no es obligatorio
    @Autowired
    public FundamentosApplication(
            @Qualifier("componentTwoImplement") ComponentDependency componentDependency,
            MyBean myBean,
            MyBeanWithDependency myBeanWithDependency,
            MyMovimientoWithDependency myMovimientoWithDependency
    ){
        this.componentDependency = componentDependency;
        this.myBean = myBean;
        this.myBeanWithDependency = myBeanWithDependency;
        this.myMovimientoWithDependency = myMovimientoWithDependency;
    }

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

    @Override
    public void run(String... args) {
        componentDependency.saludar(); myBean.print();
        myBeanWithDependency.printWithDependency();
        myMovimientoWithDependency.printEgress(3);
    }
}
