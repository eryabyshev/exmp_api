package response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderBook {

    private double askQuantity;
    private double askAmount;
    private double askTop;
    private double bidQuantity;
    private double bidAmount;
    private double bidTop;
    private List<PriceQuantitySumm> ask;
    private List<PriceQuantitySumm> bid;


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PriceQuantitySumm{
        private double price;
        private double quantity;
        private double sum;
    }
}
