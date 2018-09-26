import exmo.Exmo;
import exmoException.ExmoException;
import org.json.simple.parser.ParseException;
import response.OrderBook;
import response.Ticker;
import response.Trades;
import response.UserInfo;

import java.util.List;
import java.util.Map;

public class Doc {


    public static void main(String[] args) throws ParseException, ExmoException {


        /**
         * method getPairs()
         * return ArrayList of String
         * this list have all names of all pairs for trade
         */
        Exmo exmoPairs = new Exmo();
        for(String s : exmoPairs.getPairs())
            System.out.println(s);


        /**
         * @link https://api.exmo.com/v1/trades/?pair=BTC_USD
         * method getTrades(String pairName)
         * return ArrayList of Trades
         * Object Trades equals JSON answer from Exmo
         * {
         *   "BTC_USD": [
         *     {
         *       "trade_id": 3,
         *       "type": "sell",
         *       "price": "100",
         *       "quantity": "1",
         *       "amount": "100",
         *       "date": 1435488248
         *     }
         *   ]
         * }
         * where
         * trade_id - trade identifier
         * type - type of transaction
         * price - the price of the transaction
         * quantity - number of transactions
         * amount - the amount of the transaction
         * date - date and time of the transaction in Unix format
         */

        Exmo exmoTrades = new Exmo();
        List<Trades> trades = exmoTrades.getTrades("BTC_USD");
        System.out.println(trades.get(4).getTradeId()
                            + " -> " +
                            trades.get(0).getPrice());


        /**
         * @link https://api.exmo.com/v1/order_book/?pair=BTC_USD
         * method getOrderBook(String pairName, int limit);
         * return object OrderBook, this object is equivalent
         * response:
         *
         * {
         *   "BTC_USD": {
         *     "ask_quantity": "3",
         *     "ask_amount": "500",
         *     "ask_top": "100",
         *     "bid_quantity": "1",
         *     "bid_amount": "99",
         *     "bid_top": "99",
         *     "ask": [[100,1,100],[200,2,400]],
         *     "bid": [[99,1,99]]
         *   }
         * }
         *
         * where,
         * ask_quantity - the volume of all orders for sale
         * ask_amount - the sum of all orders for sale
         * ask_top - the minimum sale price
         * bid_quantity - the volume of all purchase orders
         * bid_amount - the sum of all purchase orders
         * bid_top - maximum purchase price
         * bid - list of purchase orders, where each line is the price, quantity and amount
         * ask - list of orders for sale, where each line is the price, quantity and amount
         */
        Exmo exmoOrderBook = new Exmo();
        OrderBook orderBook = exmoOrderBook.getOrderBook("BTC_USD", 3);
        List<OrderBook.PriceQuantitySumm> askList = orderBook.getAsk();

        for (int i = 0; i < askList.size(); i++){
            System.out.println((i + 1) + ". price: " + askList.get(i).getPrice() +
                    "\n   quantity: " + askList.get(i).getQuantity() +
                    "\n   summ: " + askList.get(i).getSum());
        }


        /**
         * @https://api.exmo.com/v1/ticker/
         * method getTicker(String pairName)
         * returns Ticker object,this object is equivalent
         * response:
         * {
         *   "BTC_USD": {
         *     "buy_price": "589.06",
         *     "sell_price": "592",
         *     "last_trade": "591.221",
         *     "high": "602.082",
         *     "low": "584.51011695",
         *     "avg": "591.14698808",
         *     "vol": "167.59763535",
         *     "vol_curr": "99095.17162071",
         *     "updated": 1470250973
         *   }
         * }
         * where,
         * high - the maximum transaction price for 24 hours
         * low - the minimum transaction price for 24 hours
         * avg - average transaction price for 24 hours
         * vol - the volume of all transactions for 24 hours
         * vol_curr - the sum of all transactions for 24 hours
         * last_trade - the last transaction price
         * buy_price - current maximum purchase price
         * sell_price - current minimum sale price
         * updated - date and time of data update
         */
        Exmo exmoTicker = new Exmo();
        Ticker ticker = exmoTicker.getTicker("BTC_USD");
        System.out.println("1 BTC = " + ticker.getLastTrade() + " USD");


        /**
         * @link https://api.exmo.com/v1/currency/
         * method getCurrency() returnes list of String.
         * This list is equivalen response:
         * ["USD","EUR","RUB","BTC","DOGE","LTC"]
         */
        Exmo exmoCurrency = new Exmo();
        for(String s : exmoCurrency.getCurrency()){
            System.out.print(s + " ");
        }


        /**
         * Method getUserInfo() returns object UserInfo,
         * witch is equivalent response:
         * {
         *   "uid": 10542,
         *   "server_date": 1435518576,
         *   "balances": {
         *     "BTC": "970.994",
         *     "USD": "949.47"
         *   },
         *   "reserved": {
         *     "BTC": "3",
         *     "USD": "0.5"
         *   }
         * }
         * where,
         * uid is the user ID
         * server_date - server date and time
         * balances - available balance of the user
         * reserved - user balance in orders
         */
        Exmo userInfoExmo = new Exmo("K-3c71a6cc6b3af7c4ad50d864e66936fa0cea39b4",
                                   "S-a2a3d3afb32f3639a749b0d620f328c941f67946");
        UserInfo userInfo = userInfoExmo.getUserInfo();
        System.out.println("My user ID : " + userInfo.getUid());

        for(Map.Entry<String, Double> entry : userInfo.getBalances().entrySet()){
            if(entry.getValue().compareTo(Double.valueOf(0d)) > 0)
                System.out.println(entry.getKey() + " - " + entry.getValue().toString());
        }




    }


}
