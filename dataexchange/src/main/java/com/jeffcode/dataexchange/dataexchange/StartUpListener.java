package com.jeffcode.dataexchange.dataexchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.lang.reflect.Field;

public class StartUpListener implements ServletContextListener {
	private static final Logger LOG = LoggerFactory.getLogger(StartUpListener.class);

	@Override
	public void contextInitialized(ServletContextEvent event) {
		WebApplicationContext context = (WebApplicationContext) event.getServletContext()
				.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		setCtx(context);
	}

	protected ContextLoader createContextLoader() {
		return new ContextLoader();
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		setCtx(null);
	}

	private void setCtx(WebApplicationContext context) {
		try {
			Field ctx = AppContextUtil.class.getDeclaredField("ctx");
			boolean isAccess = ctx.isAccessible();
			if (!isAccess) {
				ctx.setAccessible(true);
			}
			ctx.set(AppContextUtil.class, context);
			ctx.setAccessible(isAccess);
		} catch (NoSuchFieldException e) {
			LOG.error("", e);
		} catch (IllegalAccessException e) {
			LOG.error("", e);
		}
	}

}
