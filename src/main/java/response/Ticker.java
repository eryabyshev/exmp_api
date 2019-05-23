package response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
