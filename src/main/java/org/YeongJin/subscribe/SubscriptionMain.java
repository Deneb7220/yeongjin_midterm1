package org.YeongJin.subscribe;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SubscriptionMain {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("subscription-context.xml");
		SubscriptionService subscriptionService = context.getBean("subscriptionService", SubscriptionService.class);
		
		subscriptionService.subscribe();
		subscriptionService.listSubscription();
		context.close();
	}

}
