package wordnet.genshin.domain;

public class Users {
    private String user;

    private Long currentConnections;

    private Long totalConnections;

    private Long maxSessionControlledMemory;

    private Long maxSessionTotalMemory;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Long getCurrentConnections() {
        return currentConnections;
    }

    public void setCurrentConnections(Long currentConnections) {
        this.currentConnections = currentConnections;
    }

    public Long getTotalConnections() {
        return totalConnections;
    }

    public void setTotalConnections(Long totalConnections) {
        this.totalConnections = totalConnections;
    }

    public Long getMaxSessionControlledMemory() {
        return maxSessionControlledMemory;
    }

    public void setMaxSessionControlledMemory(Long maxSessionControlledMemory) {
        this.maxSessionControlledMemory = maxSessionControlledMemory;
    }

    public Long getMaxSessionTotalMemory() {
        return maxSessionTotalMemory;
    }

    public void setMaxSessionTotalMemory(Long maxSessionTotalMemory) {
        this.maxSessionTotalMemory = maxSessionTotalMemory;
    }
}