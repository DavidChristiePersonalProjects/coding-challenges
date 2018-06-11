package com.apofina.shoppingcartservice;

import com.apofina.shoppingcartservice.basket.BasketController;
import static org.assertj.core.api.Assertions.assertThat;
//import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingCartServiceApplicationTests {
    
    @Autowired
    private BasketController basketController;

	@Test
	public void contextLoads() {
            //Assert.assertThat();
            assertThat(basketController).isNotNull();
	}

}
