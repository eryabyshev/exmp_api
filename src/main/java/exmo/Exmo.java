package exmo;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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


    public List<Trades> getTrades(String pairName) throws ParseException {
        Map<String, String> param = new HashMap<>();
        param.put("pair", pairName);

        String tradesResult = exmoFrame.publicAPIRequest("trades", param);
        if(tradesResult.equals("{}"))
            return null;

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

        return trades;
    }






}
