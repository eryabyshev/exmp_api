import exmo.Exmo;
import org.json.simple.parser.ParseException;
import response.OrderBook;
import response.Trades;

import java.util.List;

public class Doc {


    public static void main(String[] args) throws ParseException {


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



    }


}
