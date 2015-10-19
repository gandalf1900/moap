package moap.frodo.no.generated;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.3
 * 2015-10-20T10:07:49.327+02:00
 * Generated source version: 3.1.3
 * 
 */
@WebServiceClient(name = "EchoServiceImplService", 
                  wsdlLocation = "file:/C:/apps/moap/moap-client/src/main/resources/wsdl/echo.wsdl",
                  targetNamespace = "http://ws.service.moap.frodo.no/") 
public class EchoServiceImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://ws.service.moap.frodo.no/", "EchoServiceImplService");
    public final static QName EchoServiceImplPort = new QName("http://ws.service.moap.frodo.no/", "EchoServiceImplPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/apps/moap/moap-client/src/main/resources/wsdl/echo.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(EchoServiceImplService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/C:/apps/moap/moap-client/src/main/resources/wsdl/echo.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public EchoServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public EchoServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EchoServiceImplService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public EchoServiceImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public EchoServiceImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public EchoServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns EchoServiceWS
     */
    @WebEndpoint(name = "EchoServiceImplPort")
    public EchoServiceWS getEchoServiceImplPort() {
        return super.getPort(EchoServiceImplPort, EchoServiceWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EchoServiceWS
     */
    @WebEndpoint(name = "EchoServiceImplPort")
    public EchoServiceWS getEchoServiceImplPort(WebServiceFeature... features) {
        return super.getPort(EchoServiceImplPort, EchoServiceWS.class, features);
    }

}
