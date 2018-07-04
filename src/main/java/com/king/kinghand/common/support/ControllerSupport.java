package com.king.kinghand.common.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller公用的
 * @author wx
 *
 */
public abstract class ControllerSupport {
	
	//公共logger
	protected final Logger logger;

	public ControllerSupport() {
		logger = LoggerFactory.getLogger(this.getClass());
	}
	
	
	
	
	

}
