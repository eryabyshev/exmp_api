package response;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Trades {

    //дата и время сделки в формате Unix
    private Date date;
    //сумма сделки
    private double amount;
    //идентификатор сделки
    private long tradeId;
    //кол-во по сделке
    private double quantity;
    //цена сделки
    private double price;
    //тип сделки
    private String type;

    public Trades(long date, double amount, long tradeId, double quantity, double price, String type) {
        this.date = new Date(date);
        this.amount = amount;
        this.tradeId = tradeId;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
    }


    public Date getDate() {
        return date;
    }

    public long getDateLongTime(){
        return date.getTime();
    }


    public String getDateSting(){
        SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyy hh:mm:ss");
        return dt.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getTradeId() {
        return tradeId;
    }

    public void setTradeId(long tradeId) {
        this.tradeId = tradeId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
