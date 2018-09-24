package response;

public class Ticker {
    private double high;
    private double low;
    private double avg;
    private double vol;
    private double volCurr;
    private double lastTrade;
    private double buyPrice;
    private double sellPrice;
    private long updated;

    public Ticker(double high, double low, double avg, double vol, double volCurr, double lastTrade, double buyPrice,
                  double sellPrice, long updated) {
        this.high = high;
        this.low = low;
        this.avg = avg;
        this.vol = vol;
        this.volCurr = volCurr;
        this.lastTrade = lastTrade;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.updated = updated;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public double getVol() {
        return vol;
    }

    public void setVol(double vol) {
        this.vol = vol;
    }

    public double getVolCurr() {
        return volCurr;
    }

    public void setVolCurr(double volCurr) {
        this.volCurr = volCurr;
    }

    public double getLastTrade() {
        return lastTrade;
    }

    public void setLastTrade(double lastTrade) {
        this.lastTrade = lastTrade;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }
}
