package us.nsfv.venafi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vmware.o11n.plugin.sdk.spring.AbstractSpringPluginAdaptor;


public final class VenafiTPMPluginAdaptor extends  AbstractSpringPluginAdaptor{

        private static final String DEFAULT_CONFIG = "us/nsfv/venafi/pluginConfig.xml";
    
    public static final String PLUGIN_NAME = "Venafi TPM";
    
    static final String ROOT = "${rootElement}Finder";
    static final String REL_ROOTS = "roots";
    
    @Override
    protected ApplicationContext createApplicationContext(ApplicationContext defaultParent) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                new String[] { DEFAULT_CONFIG }, false, defaultParent);
        applicationContext.setClassLoader(getClass().getClassLoader());
        applicationContext.refresh();
    
        return applicationContext;
    }
}