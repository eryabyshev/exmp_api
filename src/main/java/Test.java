import exmo.ExmoFrame;
import exmoException.ExmoException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import response.OrderBook;
import response.Ticker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {

        public static void main(String[] args) throws ExmoException, ParseException {

//            ExmoFrame e = new ExmoFrame("K-3c71a6cc6b3af7c4ad50d864e66936fa0cea39b4","S-a2a3d3afb32f3639a749b0d620f328c941f67946");
//            String result = e.authenticatedRequest("user_info", null);
//            System.out.println(result);
//            String result2 = e.authenticatedRequest("user_cancelled_orders", new HashMap<String, String>() {{
//                put("limit", "2");
//                put("offset", "0");
//            }});
//            System.out.println(result2);
//
//            e = new ExmoFrame();
//            Map<String, String> arguments = new HashMap<>();
//            arguments.put("pair", "BTC_USD");
//            String result3 = e.publicAPIRequest("order_book", arguments);
//            System.out.println(result3);
//
//
//
//            // get all pairs
//            Exmo exmo = new Exmo();
//            for(String s : exmo.getPairs())
//                System.out.println(s);


//            ExmoFrame exmoFrame = new ExmoFrame();
//
//            Map<String, String> param = new HashMap<>();
//            param.put("pair", "BTC_USD");
//            String tradesResult = exmoFrame.publicAPIRequest("trades", param);
//
//            JSONParser parser = new JSONParser();
//
//            Object obj = parser.parse(tradesResult);
//            JSONObject jo = (JSONObject) obj;
//
//            List<JSONObject> jsonObjectList = (List<JSONObject>) jo.get("BTC_USD");
//
//            List<Trades> trades = new ArrayList<>();
//
//            for (JSONObject j : jsonObjectList) {
//                trades.add(new Trades(Long.valueOf(j.get("date").toString()),
//                        Double.valueOf(j.get("amount").toString()),
//                        Long.valueOf(j.get("trade_id").toString()),
//                        Double.valueOf(j.get("quantity").toString()),
//                        Double.valueOf(j.get("price").toString()),
//                        j.get("type").toString()));
//
//            }




            //order_book
//            ExmoFrame exmoFrame = new ExmoFrame();
//
//            Map<String, String> param = new HashMap<>();
//            param.put("pair", "BTC_USD");
//            param.put("limit", "2");
//
//            String result = exmoFrame.publicAPIRequest("order_book", param);
//            System.out.println(result);
//
//            JSONParser parser = new JSONParser();
//            JSONObject obj = (JSONObject) parser.parse(result);
//            JSONObject jo = (JSONObject) obj.get("BTC_USD");
//
//            double bidQuantity = Double.valueOf(jo.get("bid_quantity").toString());
//            double bidAmount = Double.valueOf(jo.get("bid_amount").toString());
//            double askTop = Double.valueOf(jo.get("ask_top").toString());
//            double askAmount = Double.valueOf(jo.get("ask_amount").toString());
//            double bidTop = Double.valueOf(jo.get("bid_top").toString());
//            double askQuantity = Double.valueOf(jo.get("ask_quantity").toString());
//
//            List<OrderBook.PriceQuantitySumm> ask = dolist((JSONArray) jo.get("ask"));
//            List<OrderBook.PriceQuantitySumm> bid = dolist((JSONArray) jo.get("bid"));
//
//            OrderBook orderBook = new OrderBook(askQuantity, askAmount, askTop, bidQuantity, bidAmount, bidTop, ask, bid);
//
//
//        }
//
//
//        public static List<OrderBook.PriceQuantitySumm> dolist(JSONArray jsonArray){
//            List<OrderBook.PriceQuantitySumm> result = new ArrayList<>();
//
//            for(Object i : jsonArray){
//                JSONArray ja = (JSONArray)i;
//                OrderBook.PriceQuantitySumm pqs
//                        = new OrderBook.PriceQuantitySumm(Double.valueOf(ja.get(0).toString()),
//                        Double.valueOf(ja.get(1).toString()), Double.valueOf(ja.get(2).toString()));
//
//                result.add(pqs);
//            }
//            return result;

//            ExmoFrame exmoFrame = new ExmoFrame();
//            String result = exmoFrame.publicAPIRequest("ticker", null);
//            System.out.println(result);
//
//            JSONParser parser = new JSONParser();
//            JSONObject jo = (JSONObject) parser.parse(result);
//            JSONObject target = (JSONObject) jo.get("BTC_USD");
//
//            double high =  Double.valueOf(target.get("high").toString());
//            double low =  Double.valueOf(target.get("low").toString());
//            double avg =  Double.valueOf(target.get("avg").toString());
//            double vol =  Double.valueOf(target.get("vol").toString());
//            double volCurr =  Double.valueOf(target.get("vol_curr").toString());
//            long updated = Long.valueOf(target.get("updated").toString());
//            double lastTrade =  Double.valueOf(target.get("last_trade").toString());
//            double buyPrice =  Double.valueOf(target.get("buy_price").toString());
//            double sellPrice =  Double.valueOf(target.get("sell_price").toString());
//
//            Ticker ticker = new Ticker(high, low, avg, vol,
//                    volCurr, lastTrade, buyPrice, sellPrice, updated);


            ExmoFrame exmoFrame = new ExmoFrame();
            String result = exmoFrame.publicAPIRequest("currency", null);
            JSONParser parser = new JSONParser();
            List<String>list = new ArrayList<>((JSONArray) parser.parse(result));













       }

}
