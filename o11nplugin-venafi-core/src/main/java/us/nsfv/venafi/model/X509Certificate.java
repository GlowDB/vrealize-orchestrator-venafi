package us.nsfv.venafi.model;

import org.springframework.beans.factory.annotation.Autowired;

import ch.dunes.vso.sdk.api.IPluginFactory;

import com.vmware.o11n.plugin.sdk.annotation.*;
import com.vmware.o11n.plugin.sdk.spring.AbstractSpringPluginFactory;

@VsoObject(description="Represents a X509 Certificate object in Venafi.")
public class X509Certificate {
    public static final String TYPE = "X509Certificate";
    
    // creates the scriptable object
    public static X509Certificate createScriptingSingleton(IPluginFactory factory) {
        return ((AbstractSpringPluginFactory) factory).createScriptingObject(X509Certificate.class);
    }
    
    // declare properties
    private String certificateDN;
    private String certificateThumbprint;
    private String venafiUniqueId;
    
    // expose properties to vCO/vRO
    @VsoProperty(description="The Certificate DN (path) in Venafi.")
    public String getCertificateDn() {
		return certificateDN;
	}
    @VsoProperty(description="SSL Thumbprint of the X509 Certificate.")
    public String getThumbprint() {
		return certificateThumbprint;
    }
    @VsoProperty(description="Unique internal ID for Venafi Object, type agnostic.")
    public String getVenafiUniqueId() {
		return venafiUniqueId;
	}
    
}
