package response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private long orderId;
    private long created;
    private String type;
    private String pair;
    private double price;
    private double quantity;
    private double amount;
}
