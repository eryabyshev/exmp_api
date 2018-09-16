import exmo.Exmo;
import exmo.ExmoFrame;
import exmoException.ExmoException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import response.Trades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


            ExmoFrame exmoFrame = new ExmoFrame();

            Map<String, String> param = new HashMap<>();
            param.put("pair", "BTC_USD");
            String tradesResult = exmoFrame.publicAPIRequest("trades", param);

            JSONParser parser = new JSONParser();

            Object obj = parser.parse(tradesResult);
            JSONObject jo = (JSONObject) obj;

            List<JSONObject> jsonObjectList = (List<JSONObject>) jo.get("BTC_USD");

            List<Trades> trades = new ArrayList<>();

            for (JSONObject j : jsonObjectList) {
                trades.add(new Trades(Long.valueOf(j.get("date").toString()),
                        Double.valueOf(j.get("amount").toString()),
                        Long.valueOf(j.get("trade_id").toString()),
                        Double.valueOf(j.get("quantity").toString()),
                        Double.valueOf(j.get("price").toString()),
                        j.get("type").toString()));

            }

            int a = 10;




        }

}
