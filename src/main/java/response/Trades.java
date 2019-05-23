package response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Trades {


    private Date date;

    private double amount;
    private long tradeId;
    private double quantity;
    private double price;
    private String type;


    public Trades(long date, double amount, long tradeId, double quantity, double price, String type) {
        this.date = new Date(date);
        this.amount = amount;
        this.tradeId = tradeId;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
    }

}
