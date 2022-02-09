package com.leonam.aula.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.leonam.aula.entities.Category;
import com.leonam.aula.entities.Order;
import com.leonam.aula.entities.OrderItem;
import com.leonam.aula.entities.Payment;
import com.leonam.aula.entities.Product;
import com.leonam.aula.entities.User;
import com.leonam.aula.entities.enums.OrderStatus;
import com.leonam.aula.repositories.CategoryRepository;
import com.leonam.aula.repositories.OrderItemRepository;
import com.leonam.aula.repositories.OrderRepository;
import com.leonam.aula.repositories.ProductRepository;
import com.leonam.aula.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Leonam Braga", "leonam@gmail.com", "99999999", "123456");
		User u2 = new User(null, "Ketelyn Almeida", "ketelyn@gmail.com", "999999999", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		Category c1 = new Category(null, "Books");
		Category c2 = new Category(null, "Eletronics");
		Category c3 = new Category(null, "Computer");
		
		categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(c1);
		p2.getCategories().add(c2);
		p3.getCategories().add(c2);
		p3.getCategories().add(c3);
		p4.getCategories().add(c2);
		p4.getCategories().add(c3);
		p5.getCategories().add(c1);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPayment(pay1);
		
		orderRepository.save(o1);
		
		
	}
}
