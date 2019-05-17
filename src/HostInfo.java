

public class HostInfo {
    private static final long serialVersionUID = 1L;
    private String localhost    = "127.0.0.1";
    private String RMI_HOSTNAME = "java.rmi.server.hostname";
    private String SERVICE_PATH = "rmi://localhost/BillingService";

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getLocalhost() {
        return localhost;
    }

    public String getSERVICE_PATH() {
        return SERVICE_PATH;
    }

    public String getRMI_HOSTNAME() {
        return RMI_HOSTNAME;
    }

    public void setLocalhost(String localhost) {
        this.localhost = localhost;
    }

    public void setRMI_HOSTNAME(String RMI_HOSTNAME) {
        this.RMI_HOSTNAME = RMI_HOSTNAME;
    }

    public void setSERVICE_PATH(String SERVICE_PATH) {
        this.SERVICE_PATH = SERVICE_PATH;
    }
}
