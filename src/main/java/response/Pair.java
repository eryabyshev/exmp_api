package response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pair {
    private String name;
    private double minQuantity;
    private double maxQuantity;
    private double minPrice;
    private double maxPrice;
    private double maxAmount;
    private double minAmount;
}