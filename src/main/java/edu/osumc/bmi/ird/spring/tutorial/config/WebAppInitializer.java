package edu.osumc.bmi.ird.spring.tutorial.config;

import edu.osumc.bmi.ird.spring.tutorial.util.PropertiesLoader;
import edu.osumc.bmi.ird.spring.tutorial.util.ResourceProperties;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Properties;

/**
 * Created by swang on 3/3/2015.
 */
public class WebAppInitializer implements WebApplicationInitializer {

    private static final PropertiesLoader propertiesLoader = new PropertiesLoader();

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext context = getContext();

        // Manage the lifecycle of the root application context
        servletContext.addListener(new ContextLoaderListener(context));

        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherServlet = new
                AnnotationConfigWebApplicationContext();
        dispatcherServlet.register(MvcConfig.class);

        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new
                DispatcherServlet(dispatcherServlet));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }

    /**
     * Creates annotation driven context initializer. Active profile will be loaded from
     * properties files.
     *
     * @return AnnotationConfigWebApplicationContext
     */
    private AnnotationConfigWebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("edu.osumc.bmi.ird.spring.tutorial.config");
        //context.register(AppConfig.class, ServiceConfig.class);
        Properties properties = propertiesLoader.load(ResourceProperties.SPRING_PROPERTIES_FILE);
        context.getEnvironment().setActiveProfiles(
                properties.getProperty("spring.profiles.active"));

        return context;
    }
}
