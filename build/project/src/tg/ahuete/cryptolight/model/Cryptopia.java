package tg.ahuete.cryptolight.model;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;

import com.dylanjsa.cryptopia.remote.CryptopiaClientException;
import com.dylanjsa.cryptopia.remote.data.Balance;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.List;

/**
 * Missing methods:
 *  - CancelTrade
 *  - SubmitTip
 *  - SubmitWithdraw
 *  - SubmitTransfer
 *
 * Created by Dylan Janeke on 2017/06/22.
 */
public class Cryptopia {
    private static final String ROOT_URL = "https://www.cryptopia.co.nz";
    private static final String PRIVATE_PATH = "api";

    private String key;
    private String secretKey;

    public Cryptopia() {
    	
	}

	public Cryptopia setKey(String key) {
        this.key = key;
        return this;
    }

    public Cryptopia setSecretKey(String secretKey) {
        this.secretKey = secretKey;
        return this;
    }

    /**
     * Performs a raw public API query.
     * @param method the REST resource
     * @return result JSON
     */
    private String publicApiQuery(String method) {
        BufferedReader in = null;
        try {
            final String urlMethod = String.format("%s/%s/%s", ROOT_URL, PRIVATE_PATH, method);
            final URLConnection con = new URL(urlMethod).openConnection();
            final HttpsURLConnection httpsConn = (HttpsURLConnection) con;
            httpsConn.setRequestMethod("GET");
            httpsConn.setInstanceFollowRedirects(true);
            con.setRequestProperty("Content-Type", "application/json");
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            final StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            return response.toString();
        } catch (Exception e) {
            throw new CryptopiaClientException("An error occurred communicating with Cryptopia.", e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ignored) {}
            }
        }
    }

    /**
     * Performs a raw private API query.
     * @param method the REST resource
     * @param postParam the JSON to send in the request body.
     * @return result JSON
     */
    //Thanks to sampey from https://www.cryptopia.co.nz/Forum/Thread/262
    private String privateApiQuery(String method, String postParam) {
    	
        if (secretKey == null) {
            throw new CryptopiaClientException("Please set your secret key before attempting " +
                    "to access any private API methods.");
        }
        if (key == null) {
            throw new CryptopiaClientException("Please set your key before attempting " +
                    "to access any private API methods.");
        }
        BufferedReader in = null;
        try {
            final String urlMethod = String.format("%s/%s/%s", ROOT_URL, PRIVATE_PATH, method);
            final String nonce = String.valueOf(System.currentTimeMillis());
            final StringBuilder reqSignature = new StringBuilder();
            reqSignature
                    .append(key)
                    .append("POST")
                    .append(URLEncoder.encode(urlMethod, StandardCharsets.UTF_8.toString()).toLowerCase())
                    .append(nonce)
                    .append(getMD5_B64(postParam));
           
            final StringBuilder auth = new StringBuilder();
            auth.append("amx ")
                    .append(key)
                    .append(":")
                    .append(sha256_B64(reqSignature.toString()))
                    .append(":")
                    .append(nonce);
            System.out.println(auth);
            final URLConnection con = new URL(urlMethod).openConnection();
            con.setDoOutput(true);
            final HttpsURLConnection httpsConn = (HttpsURLConnection) con;
            httpsConn.setRequestMethod("POST");
            httpsConn.setInstanceFollowRedirects(true);
           
            con.setRequestProperty("Authorization", auth.toString());
            con.setRequestProperty("Content-Type", "application/json");
            final DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParam);
            wr.flush();
            wr.close();
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            return response.toString();
        }catch (Exception e) {
            throw new CryptopiaClientException("An error occurred communicating with Cryptopia.", e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ignored) {}
            }
        }
    }

    private String getMD5_B64(String postParameter) throws Exception {
        return Base64.getEncoder().encodeToString(
                MessageDigest.getInstance("MD5").digest(postParameter.getBytes("UTF-8")));
    }

    private String sha256_B64(String msg) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(Base64.getDecoder().decode(secretKey), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        return Base64.getEncoder().encodeToString(sha256_HMAC.doFinal(msg.getBytes("UTF-8")));
    }
    
    public String getBalance(String currency) {
    	final String methodName = "GetBalance";
        final JsonObject jo = new JsonObject();
        jo.addProperty("Currency", currency);
        System.out.println("param = " + jo.toString());
        final String jsonResponse = privateApiQuery(methodName, jo.toString());
        return jsonResponse;
    }
    
}