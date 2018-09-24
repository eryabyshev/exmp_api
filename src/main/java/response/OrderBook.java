package response;

import java.util.List;

public class OrderBook {

    private double askQuantity;
    private double askAmount;
    private double askTop;
    private double bidQuantity;
    private double bidAmount;
    private double bidTop;
    private List<PriceQuantitySumm> ask;
    private List<PriceQuantitySumm> bid;


    public static class PriceQuantitySumm{
        private double price;
        private double quantity;
        private double sum;

        public PriceQuantitySumm(double price, double quantity, double sum) {
            this.price = price;
            this.quantity = quantity;
            this.sum = sum;
        }


        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getQuantity() {
            return quantity;
        }

        public void setQuantity(double quantity) {
            this.quantity = quantity;
        }

        public double getSum() {
            return sum;
        }

        public void setSum(double sum) {
            this.sum = sum;
        }

    }

    public OrderBook(double askQuantity, double askAmount, double askTop, double bidQuantity, double bidAmount,
                     double bidTop, List<PriceQuantitySumm> ask, List<PriceQuantitySumm> bid) {
        this.askQuantity = askQuantity;
        this.askAmount = askAmount;
        this.askTop = askTop;
        this.bidQuantity = bidQuantity;
        this.bidAmount = bidAmount;
        this.bidTop = bidTop;

        this.ask = ask;
        this.bid = bid;
    }

    public double getAskQuantity() {
        return askQuantity;
    }

    public void setAskQuantity(double askQuantity) {
        this.askQuantity = askQuantity;
    }

    public double getAskAmount() {
        return askAmount;
    }

    public void setAskAmount(double askAmount) {
        this.askAmount = askAmount;
    }

    public double getAskTop() {
        return askTop;
    }

    public void setAskTop(double askTop) {
        this.askTop = askTop;
    }

    public double getBidQuantity() {
        return bidQuantity;
    }

    public void setBidQuantity(double bidQuantity) {
        this.bidQuantity = bidQuantity;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
    }

    public double getBidTop() {
        return bidTop;
    }

    public void setBidTop(double bidTop) {
        this.bidTop = bidTop;
    }

    public List<PriceQuantitySumm> getAsk() {
        return ask;
    }

    public void setAsk(List<PriceQuantitySumm> ask) {
        this.ask = ask;
    }

    public List<PriceQuantitySumm> getBid() {
        return bid;
    }

    public void setBid(List<PriceQuantitySumm> bid) {
        this.bid = bid;
    }
}
