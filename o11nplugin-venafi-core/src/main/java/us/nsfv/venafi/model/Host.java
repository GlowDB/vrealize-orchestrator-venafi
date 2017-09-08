package us.nsfv.venafi.model;

import org.springframework.beans.factory.annotation.Autowired;

import ch.dunes.vso.sdk.api.IPluginFactory;

import com.vmware.o11n.plugin.sdk.annotation.*;
import com.vmware.o11n.plugin.sdk.spring.AbstractSpringPluginFactory;

@VsoObject(description="Defines a connection to a Venafi TPM Server and its related properties.")
public class Host {
    public static final String TYPE = "Host";

    public static Host createScriptingSingleton(IPluginFactory factory) {
        return ((AbstractSpringPluginFactory) factory).createScriptingObject(Host.class);
    }

    @VsoMethod(description="Reloads the Venafi Host connection object.")
    private static void reload() {
        
    }
    // properties of the Host in vRO
    private String id;
    private String name;
    private int port;
    private String hostName;
    private String userName;
    private String password;

    // expose the properties to the Scripting Object
    @VsoProperty(description="Internal ID of the Venafi connection")
    public String getId() {
		return id;
	}

    @VsoProperty(description="Display name of the Venafi connection")
    public String getName() {
		return name;
	}
    @VsoProperty(description="Service port used to connect to the Venafi server")
    public int getPort() {
		return port;
	}
    @VsoProperty(description="Host name/FQDN of the Venafi server")
    public String getHostName() {
		return hostName;
	}
    @VsoProperty(description="Username for Venafi server connection")
    public String getUserName() {
		return userName;
	}
    @VsoProperty(description="Password for Venafi server connectionn")
    public String getPassword() {
		return password;
	}
 
}
