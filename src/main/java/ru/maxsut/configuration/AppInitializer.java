package ru.maxsut.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer{

}
//public class AppInitializer implements WebApplicationInitializer {
//
//	private static final String DISPATCHER_SERVLET = "dispatcher";
//
//	public void onStartup(ServletContext container) throws ServletException {
//
//		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//		ctx.register(AppConfig.class);
//		container.addListener(new ContextLoaderListener(ctx));
//		ctx.setServletContext(container);
//
//		ServletRegistration.Dynamic servlet = container.addServlet(
//				DISPATCHER_SERVLET, new DispatcherServlet(ctx));
//
//		servlet.setLoadOnStartup(1);
//		servlet.addMapping("/");
//	}
//
//}
