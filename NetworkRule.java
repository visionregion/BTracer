public class NetworkRule {

    private String policy;
    private String protocol;
    private String sourceIP;
    private String sourceIPmask;
    private String destinationIP;
    private String destinationIPmask;
    private String sourcePort;
    private String destinationPort;

    public NetworkRule() {}

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

    public String getSourcePort() {
        return sourcePort;
    }

    public String getDestinationPort() {
        return destinationPort;
    }

    public String getSourceIPmask() {
        return sourceIPmask;
    }

    public String getDestinationIPmask() {
        return destinationIPmask;
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

    public void setSourcePort(String port) {
        this.sourcePort = port;
    }

    public void setDestinationPort(String port) {
        this.destinationPort = port;
    }

    public void setSourceIPmask(String sourceIPmask) {
        this.sourceIPmask = sourceIPmask;
    }

    public void setDestinationIPmask(String destinationIPmask) {
        this.destinationIPmask = destinationIPmask;
    }
}
