package com.ashok.dev.sharemarket.delegate;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;

@Provider
public class SessionFilter implements ContainerRequestFilter {
	Logger logger = Logger.getLogger(SessionFilter.class);

	@Override
	public void filter(ContainerRequestContext requestContext)
			throws IOException {
			logger.info("Filter Working");
	}
	
	
}