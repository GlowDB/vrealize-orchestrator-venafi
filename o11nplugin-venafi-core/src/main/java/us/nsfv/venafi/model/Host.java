package us.nsfv.venafi.model;

// add java classes
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import ch.dunes.vso.sdk.api.IPluginFactory;
import com.vmware.o11n.plugin.sdk.annotation.*;
import com.vmware.o11n.plugin.sdk.spring.AbstractSpringPluginFactory;
import java.io.IOException;

@VsoObject(description="Defines a connection to a Venafi TPM Server and its related properties.")
public class Host {
    public static final String TYPE = "Host";
    // define default values
    private String id;
    private String name;
    private String hostName;
    private String userName;
    private String password;
    // default port is 443
    int port = 443;

    public static Host createScriptingSingleton(IPluginFactory factory) {
        return ((AbstractSpringPluginFactory) factory).createScriptingObject(Host.class);
    }

    // define a constructor method. You can have multiple such as a simple one, or more complex (select ports, etc)
    @VsoConstructor(description="Simple Venafi Host Constructor")
    public Host(
        @VsoParam(description="FQDN of Venafi Host") String fqdn,
        @VsoParam(description="User account for authentication") String user,
        @VsoParam(description="Password for authentication") String password) {
        this.hostName = fqdn;
        this.userName = user;
        this.password = password;
    }
 
    @VsoMethod(description="Reloads the Venafi Host connection object.")
    public static void reload() {
        System.out.println("Certificate was reloaded.");
    }


    // use spring restTemplate to do a GET
    @VsoMethod(description="Using Spring Framework REST Client to get XKCD data.")
    public String getXKCDComic() {
        // disable SSL verification (see /helpers folder)
        SSLCertificateValidation.disable();
        // construct REST Template from the Spring framework
        RestTemplate restTemplate = new RestTemplate();
        // execute the GET to URL, second arg is the type to expect in return aka string
        String data = restTemplate.getForObject("https://xkcd.com/info.0.json", String.class);
        // output the dataz
        return data.toString();
    }
    
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
