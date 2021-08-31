package backend.API;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.math.BigDecimal;

public class CurrencyCalculator {

    private static String getApiResult(String from, String to){

        URL currencyConverterURL = null;
        HttpsURLConnection connection = null;
        BufferedReader inputReader = null;

        try{
            currencyConverterURL = new URL("https://v6.exchangerate-api.com/v6/635982881eba68af985c2e3e/pair/"+ from +"/"+ to);
        }catch (MalformedURLException ex){
            ex.printStackTrace();
        }

        try{
            connection = (HttpsURLConnection)currencyConverterURL.openConnection();
        }catch (IOException ex){
            ex.printStackTrace();
        }

        try{
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            inputReader = new BufferedReader(inputStreamReader);
        }catch (IOException ex){
            ex.printStackTrace();
        }

        String inputLine;
        StringBuilder inputStringBuilder = new StringBuilder();

        try{
            while((inputLine = inputReader.readLine()) != null){
                inputStringBuilder.append(inputLine);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }

        String jsonResult = inputStringBuilder.toString();

        return jsonResult;
    }


    private static BigDecimal getExchangeRateFromJson(String jsonResult){
        char[] chars = new char[6];

        jsonResult.getChars(372,378,chars,0);
        String exchangeRateInString = new String(chars);
        System.out.println(exchangeRateInString);
        BigDecimal exchangeRate = new BigDecimal(exchangeRateInString);

        return exchangeRate;
    }

    public static String currencyConverter(String from, String to, String userAmount){

        BigDecimal amountForConversion = new BigDecimal(Integer.parseInt(userAmount));
        BigDecimal amountAfterConversion;

        String jsonResult = getApiResult(from,to);
        BigDecimal exchangeRate = getExchangeRateFromJson(jsonResult);

        amountAfterConversion = amountForConversion.multiply(exchangeRate);

        String ConvertedAmount = amountAfterConversion.toString();

        return ConvertedAmount;
    }


}
