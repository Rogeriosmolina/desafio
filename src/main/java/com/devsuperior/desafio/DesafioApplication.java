package com.devsuperior.desafio;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.devsuperior.entities.Order;
import com.devsuperior.services.OrderService;

@SpringBootApplication
@ComponentScan({"com.devsuperior"})
public class DesafioApplication implements CommandLineRunner{
	@Autowired
	private OrderService orderService;
	
	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Order> pedidos = Arrays.asList(new Order(1034, 150, 20), new Order(2282, 800, 10), new Order(1309, 95.90, 0));
		Order order = pedidos.get(2);
		
		double valorTotal = orderService.total(order);
		System.out.printf("Pedido codigo  : %s %n", order.getCode());
		System.out.printf("Valor Total    : R$ %.2f %n", valorTotal);
		
	}

}
