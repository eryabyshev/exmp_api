package response;

import java.util.Map;

public class UserInfo {
    private long uid;
    private long serverDate;
    Map<String, Double> balances;
    Map<String, Double> reserved;

    public UserInfo(long uid, long serverDate, Map<String, Double> balances, Map<String, Double> reserved) {
        this.uid = uid;
        this.serverDate = serverDate;
        this.balances = balances;
        this.reserved = reserved;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getServerDate() {
        return serverDate;
    }

    public void setServerDate(long serverDate) {
        this.serverDate = serverDate;
    }

    public Map<String, Double> getBalances() {
        return balances;
    }

    public void setBalances(Map<String, Double> balances) {
        this.balances = balances;
    }

    public Map<String, Double> getReserved() {
        return reserved;
    }

    public void setReserved(Map<String, Double> reserved) {
        this.reserved = reserved;
    }
}
