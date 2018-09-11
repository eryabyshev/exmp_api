package exmo;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import exmoException.ExmoException;
import org.apache.commons.codec.binary.Hex;
import okhttp3.*;

public class ExmoFrame {
    private static long nonce = System.nanoTime();
    private String key;
    private String secret;

    public ExmoFrame(String key, String secret) {
        this.key = key;
        this.secret = secret;
    }

    public ExmoFrame() {
        this.key = null;
        this.secret = null;
    }



    private String doPostData(Map<String, String> arguments) {
        if (arguments == null)
            arguments = new HashMap<>();

        arguments.put("nonce", "" + ++nonce);
        StringBuffer postData = new StringBuffer();

        for (Map.Entry<String, String> stringStringEntry : arguments.entrySet()) {
            Map.Entry argument = (Map.Entry) stringStringEntry;

            if (postData.length() > 0) {
                postData.append("&");
            }
            postData.append(argument.getKey() + "=" + argument.getValue());
        }
        return postData.toString();
    }


    public String authenticatedRequest(String method, Map<String, String> arguments) throws ExmoException {


        if(key == null || secret == null){
            throw new ExmoException();
        }


        Mac mac;
        SecretKeySpec secretKeySpec;
        String sign;

        String postData = doPostData(arguments);

        // Create a new secret key
        try {
            secretKeySpec = new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA512");
        } catch (UnsupportedEncodingException uee) {
            System.err.println("Unsupported encoding exception: " + uee.toString());
            return null;
        }

        // Create a new mac
        try {
            mac = Mac.getInstance("HmacSHA512");
        } catch (NoSuchAlgorithmException nsae) {
            System.err.println("No such algorithm exception: " + nsae.toString());
            return null;
        }

        // Init mac with key.
        try {
            mac.init(secretKeySpec);
        } catch (InvalidKeyException ike) {
            System.err.println("Invalid key exception: " + ike.toString());
            return null;
        }


        // Encode the post data by the secret and encode the result as base64.
        try {
            sign = new String(Hex.encodeHex(mac.doFinal(postData.getBytes("UTF-8"))));
        } catch (UnsupportedEncodingException uee) {
            System.err.println("Unsupported encoding exception: " + uee.toString());
            return null;
        }


        return doRequestBody(postData, method, sign) ;


    }


    private String doRequestBody(String postData, String method, String sign) {

        MediaType form = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        try {

            RequestBody body = RequestBody.create(form, postData);
            Request request = new Request.Builder()
                    .url("https://api.exmo.com/v1/" + method)
                    .addHeader("Key", key)
                    .addHeader("Sign", sign)
                    .post(body)
                    .build();

            Response response = client.newCall(request).execute();
            return response.body().string();

        } catch (IOException e) {
            System.out.println("[ERROR] - Request fail: " + e.toString());
            return null;
        }
    }

    private String doRequestBody(String postData, String method) {

        MediaType form = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        try {

            RequestBody body = RequestBody.create(form, postData);
            Request request = new Request.Builder()
                    .url("https://api.exmo.com/v1/" + method)
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();
            return response.body().string();

        } catch (IOException e) {
            System.out.println("[ERROR] - Request fail: " + e.toString());
            return null;
        }
    }


    public String publicAPIRequest(String method, Map<String, String> arguments) {
        String postData = doPostData(arguments);
        return doRequestBody(postData, method);
    }

}


