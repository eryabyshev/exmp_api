import exmo.Exmo;
import org.json.simple.parser.ParseException;
import response.Trades;

import java.util.List;

public class Doc {


    public static void main(String[] args) throws ParseException {


        // get all pairs
        Exmo exmoPairs = new Exmo();
        for(String s : exmoPairs.getPairs())
            System.out.println(s);


        // https://api.exmo.com/v1/trades/?pair=BTC_USD
        Exmo exmoTrades = new Exmo();
        List<Trades> trades = exmoTrades.getTrades("BTC_USD");
        System.out.println(trades.get(4).getTradeId()
                            + " -> " +
                            trades.get(4).getPrice());



    }


}
