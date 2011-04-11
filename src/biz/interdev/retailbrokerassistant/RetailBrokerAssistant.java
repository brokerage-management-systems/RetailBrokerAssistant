/**
 * Created by Matthew Weppler on 10/13/2010.
 * http://mattweppler.info/projects/retail-brokers-assistant
 */
	
//TODO Add commission table
/*
 * Validate calculations... 
 */

//TODO Add Twitter stock search
/*
 * http://dev.twitter.com/apps/483584
 * http://dev.twitter.com/console
 * http://apiwiki.twitter.com/
 * 
 */

//TODO Look into some news apis
/*
 * http://developer.yahoo.com/search/news/V1/newsSearch.html
 * http://blog.newscloud.com/welcome-to-newscloud.html
 * 
 * Reuters:
 * http://spotlight.reuters.com/user/register
 * http://spotlight.reuters.com/project/apiDemo
 * http://mashable.com/2008/05/12/reuters-ap/
 */

package biz.interdev.retailbrokerassistant;

import biz.interdev.retailbrokerassistant.controller.RetailBrokerAssistantController;
import biz.interdev.retailbrokerassistant.model.RetailBrokerAssistantModel;
import biz.interdev.retailbrokerassistant.view.RetailBrokerAssistantView;;

public class RetailBrokerAssistant {

	public static void main(String[] args) {
		RetailBrokerAssistantModel model = new RetailBrokerAssistantModel();
		RetailBrokerAssistantView view = new RetailBrokerAssistantView(model);
		RetailBrokerAssistantController controller = new RetailBrokerAssistantController(model, view);
	}
}
