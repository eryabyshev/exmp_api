package exmo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import response.OrderBook;
import response.Ticker;
import response.Trades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exmo {

    private ExmoFrame exmoFrame;


    public Exmo(String key, String secret){
        exmoFrame = new ExmoFrame(key, secret);
    }

    public Exmo(){
        exmoFrame = new ExmoFrame();
    }

    public void setKey(String key){
        exmoFrame.setKey(key);
    }

    public void setSecret(String secret){
        exmoFrame.setSecret(secret);
    }


    public List<String> getPairs() throws ParseException {
        JSONParser parser = new JSONParser();
        Object object = parser.parse(exmoFrame.publicAPIRequest("ticker", null));
        List<String> pairs = new ArrayList<>();
        JSONObject jo = (JSONObject)object;

        for (Object key: jo.keySet()){
            pairs.add((String)key);
        }
        return pairs;
    }

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

    public List<Trades> getTrades(String pairName) throws ParseException {
        Map<String, String> param = new HashMap<>();
        param.put("pair", pairName);

        String tradesResult = exmoFrame.publicAPIRequest("trades", param);
        if(tradesResult.equals("{}"))
            return null;

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(tradesResult);
        JSONObject jo = (JSONObject) obj;

        List<JSONObject> jsonObjectList = (List<JSONObject>) jo.get(pairName);

        List<Trades> trades = new ArrayList<>();

        for (JSONObject j : jsonObjectList) {
            trades.add(new Trades(Long.valueOf(j.get("date").toString()),
                    Double.valueOf(j.get("amount").toString()),
                    Long.valueOf(j.get("trade_id").toString()),
                    Double.valueOf(j.get("quantity").toString()),
                    Double.valueOf(j.get("price").toString()),
                    j.get("type").toString()));
        }

        return trades;
    }


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

    public OrderBook getOrderBook(String pairName, int limit) throws ParseException {
        Map<String, String> param = new HashMap<>();
        param.put("pair", pairName);
        param.put("limit", Integer.toString(limit));
        String result = exmoFrame.publicAPIRequest("order_book", param);

        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(result);
        JSONObject jo = (JSONObject) obj.get(pairName);

        double bidQuantity = Double.valueOf(jo.get("bid_quantity").toString());
        double bidAmount = Double.valueOf(jo.get("bid_amount").toString());
        double askTop = Double.valueOf(jo.get("ask_top").toString());
        double askAmount = Double.valueOf(jo.get("ask_amount").toString());
        double bidTop = Double.valueOf(jo.get("bid_top").toString());
        double askQuantity = Double.valueOf(jo.get("ask_quantity").toString());

        List<OrderBook.PriceQuantitySumm> ask = dolist((JSONArray) jo.get("ask"));
        List<OrderBook.PriceQuantitySumm> bid = dolist((JSONArray) jo.get("bid"));
        return new OrderBook(askQuantity, askAmount, askTop, bidQuantity, bidAmount, bidTop, ask, bid);

    }

    private static List<OrderBook.PriceQuantitySumm> dolist(JSONArray jsonArray) {
        List<OrderBook.PriceQuantitySumm> result = new ArrayList<>();

        for (Object i : jsonArray) {
            JSONArray ja = (JSONArray) i;
            OrderBook.PriceQuantitySumm pqs
                    = new OrderBook.PriceQuantitySumm(Double.valueOf(ja.get(0).toString()),
                    Double.valueOf(ja.get(1).toString()), Double.valueOf(ja.get(2).toString()));

            result.add(pqs);
        }
        return result;
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
    public Ticker getTicker(String pairName) throws ParseException {
        String result = exmoFrame.publicAPIRequest("ticker", null);

        JSONParser parser = new JSONParser();
        JSONObject jo = (JSONObject) parser.parse(result);
        JSONObject target = (JSONObject) jo.get(pairName);

        double high =  Double.valueOf(target.get("high").toString());
        double low =  Double.valueOf(target.get("low").toString());
        double avg =  Double.valueOf(target.get("avg").toString());
        double vol =  Double.valueOf(target.get("vol").toString());
        double volCurr =  Double.valueOf(target.get("vol_curr").toString());
        long updated = Long.valueOf(target.get("updated").toString());
        double lastTrade =  Double.valueOf(target.get("last_trade").toString());
        double buyPrice =  Double.valueOf(target.get("buy_price").toString());
        double sellPrice =  Double.valueOf(target.get("sell_price").toString());

        return new Ticker(high, low, avg, vol,
                volCurr, lastTrade, buyPrice, sellPrice, updated);

    }


    /**
     * @link https://api.exmo.com/v1/currency/
     * method getCurrency() returnes list of String.
     * This list is equivalen response:
     * ["USD","EUR","RUB","BTC","DOGE","LTC"]
     */
    public List<String> getCurrency() throws ParseException {
        String result = exmoFrame.publicAPIRequest("currency", null);
        JSONParser parser = new JSONParser();
        return new ArrayList<>((JSONArray) parser.parse(result));
    }






}