package java112.project3;

/**
 *  This is a JavaBean holding Http request data to be used by Project3 
 *  request attribute of HttpRequestServlet.java that will be read by propertiesJSP.jsp
 *  using EL expression language to retreive data from this javaBean.
 *
 *@author    Dave Sullivan
 */
public class HttpRequestData extends java.lang.Object {
    //Bean: default constuctor (empty), instance vars, getters/setters
    private String remoteHost;
    private String remoteAddr;
    private String requestHttpMethod;
    private String requestURI;
    private StringBuffer requestURL;
    private String protocol;
    private String serverName;
    private int serverPort;
    private String locale;
    private String queryString;
    private String queryParameter;
    private String requestHeader;

    /**
     *  Constructor for the HttpRequestData object
     */
    public HttpRequestData() {
        // add each attribute, getter/setter of the request data bean
        remoteHost  = "default value";
        remoteAddr  = "default value";
        requestHttpMethod  = "default value";
        requestURI  = "default value";
        requestURL  = null;
        protocol = "default value";
        serverName  = "default value";
        serverPort  = 0;
        locale = "default value";
        queryString = "default value";
        queryParameter = "default value";
        requestHeader = "default value";

    }

    /**
     *  Gets the remoteHost attribute of the HttpRequestData object
     *
     *@return The remoteHost value
     */
    public String getRemoteHost() {
        return remoteHost;
    }

    /**
     *  Gets the remoteAddr attribute of the HttpRequestData object
     *
     *@return The remoteAddr value
     */
    public String getRemoteAddr() {
        return remoteAddr;
    }

    /**
     *  Gets the requestHttpMethod attribute of the HttpRequestData object
     *
     *@return The requestHttpMethod value
     */
    public String getRequestHttpMethod() {
        return requestHttpMethod;
    }

    /**
     *  Gets the requestURI attribute of the HttpRequestData object
     *
     *@return The requestURI value
     */
    public String getRequestURI() {
        return requestURI;
    }

    /**
     *  Gets the requestURL attribute of the HttpRequestData object
     *
     *@return The requestURL value
     */
    public StringBuffer getRequestURL() {
        return requestURL;
    }

    /**
     *  Gets the protocol attribute of the HttpRequestData object
     *
     *@return The protocol value
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     *  Gets the serverName attribute of the HttpRequestData object
     *
     *@return The serverName value
     */
    public String getServerName() {
        return serverName;
    }

    /**
     *  Gets the serverPort attribute of the HttpRequestData object
     *
     *@return The serverPort value
     */
    public int getServerPort() {
        return serverPort;
    }

    /**
     *  Gets the locale attribute of the HttpRequestData object
     *
     *@return The locale value
     */
    public String getLocale() {
        return locale;
    }

    /**
     *  Gets the queryString attribute of the HttpRequestData object
     *
     *@return The queryString value
     */
    public String getQueryString() {
        return queryString;
    }

    /**
     *  Gets the queryParameter attribute of the HttpRequestData object
     *
     *@return The queryParameter value
     */
    public String getQueryParameter() {
        return queryParameter;
    }

    /**
     *  Gets the requestHeader attribute of the HttpRequestData object
     *
     *@return The requestHeader value
     */
    public String getRequestHeader() {
        return requestHeader;
    }

/******************************************************************************/

    /**
     *  Sets the remoteHost attribute of the HttpRequestData object
     *
     *@param remoteHost  The new remoteHost value
     */
    public void setRemoteHost(String remoteHost) {
        this.remoteHost = remoteHost;
    }

    /**
     *  Sets the remoteAddr attribute of the HttpRequestData object
     *
     *@param remoteAddr  The new remoteAddr value
     */
    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
    }

    /**
     *  Sets the requestHttpMethod attribute of the HttpRequestData object
     *
     *@param requestHttpMethod  The new requestHttpMethod value
     */
    public void setRequestHttpMethod(String requestHttpMethod) {
        this.requestHttpMethod = requestHttpMethod;
    }

    /**
     *  Sets the requestURI attribute of the HttpRequestData object
     *
     *@param requestURI  The new requestURI value
     */
    public void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }

    /**
     *  Sets the requestURL attribute of the HttpRequestData object
     *
     *@param requestURL  The new requestURL value
     */
    public void setRequestURL(StringBuffer requestURL) {
        this.requestURL = requestURL;
    }

    /**
     *  Sets the protocol attribute of the HttpRequestData object
     *
     *@param protocol  The new protocol value
     */
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     *  Sets the serverName attribute of the HttpRequestData object
     *
     *@param serverName  The new serverName value
     */
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    /**
     *  Sets the serverPort attribute of the HttpRequestData object
     *
     *@param serverPort  The new serverPort value
     */
    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    /**
     *  Sets the locale attribute of the HttpRequestData object
     *
     *@param locale  The new locale value
     */
    public void setLocale(String locale) {
        this.locale = locale;
    }

    /**
     *  Sets the queryString attribute of the HttpRequestData object
     *
     *@param queryString  The new queryString value
     */
    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    /**
     *  Sets the queryParameter attribute of the HttpRequestData object
     *
     *@param queryParameter  The new queryParameter value
     */
    public void setQueryParameter(String queryParameter) {
        this.queryParameter = queryParameter;
    }

    /**
     *  Sets the requestHeader attribute of the HttpRequestData object
     *
     *@param requestHeader  The new requestHeader value
     */
    public void setRequestHeader(String requestHeader) {
        this.requestHeader = requestHeader;
    }

}
