public class NetworkRule {

    private String policy;
    private String protocol;
    private String sourceIP;
    private String destinationIP;
    private String port;

    public String getPolicy() {
        return policy;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getSourceIP() {
        return sourceIP;
    }

    public String getDestinationIP() {
        return destinationIP;
    }

    public String getPort() {
        return port;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public void setSourceIP(String sourceIP) {
        this.sourceIP = sourceIP;
    }

    public void setDestinationIP(String destinationIP) {
        this.destinationIP = destinationIP;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
