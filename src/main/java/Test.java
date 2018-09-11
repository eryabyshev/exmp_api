import exmo.ExmoFrame;
import exmoException.ExmoException;

import java.util.HashMap;
import java.util.Map;

public class Test {

        public static void main(String[] args) throws ExmoException {

            ExmoFrame e = new ExmoFrame("K-3c71a6cc6b3af7c4ad50d864e66936fa0cea39b4","S-a2a3d3afb32f3639a749b0d620f328c941f67946");
            String result = e.authenticatedRequest("user_info", null);
            System.out.println(result);
            String result2 = e.authenticatedRequest("user_cancelled_orders", new HashMap<String, String>() {{
                put("limit", "2");
                put("offset", "0");
            }});
            System.out.println(result2);



            e = new ExmoFrame();
            Map<String, String> arguments = new HashMap<>();
            arguments.put("pair", "BTC_USD");
            String result3 = e.publicAPIRequest("order_book", arguments);
            System.out.println(result3);

        }
}
