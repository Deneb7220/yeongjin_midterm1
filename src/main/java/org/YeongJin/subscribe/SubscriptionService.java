package org.YeongJin.subscribe;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;




@Service
public class SubscriptionService {
	
	@Autowired
	SubscriptionDao subscriptionDao;
	Logger logger = LogManager.getLogger();
	
	public void subscribe() {
		Subscription subscription = new Subscription();
		subscription.setUserId("11");
		subscription.setName("박영진");
		subscription.setChannelId("10");
		subscription.setTitle("나는 의사다");
		
		try {
			subscriptionDao.addSubscription(subscription);
			logger.debug("구독했습니다.");
		}catch(DuplicateKeyException e) {
			subscriptionDao.deleteSubscription(subscription);
			logger.debug("구독해제 했습니다.");
		}
	}
	
	public void listSubscription() {
		List<Subscription> subscriptionList = subscriptionDao.listSubscriptions("11");
		logger.debug(subscriptionList);
	}

}
