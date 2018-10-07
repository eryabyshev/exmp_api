package response;

public class Order {

    private long orderId;
    private long created;
    private String type;
    private String pair;
    private double price;
    private double quantity;
    private double amount;


    public Order(long orderId, long created, String type, String pair, double price, double quantity, double amount) {
        this.orderId = orderId;
        this.created = created;
        this.type = type;
        this.pair = pair;
        this.price = price;
        this.quantity = quantity;
        this.amount = amount;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPair() {
        return pair;
    }

    public void setPair(String pair) {
        this.pair = pair;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
