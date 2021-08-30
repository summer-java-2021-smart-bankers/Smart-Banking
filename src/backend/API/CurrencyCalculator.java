package backend.API;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.math.BigDecimal;

public class CurrencyCalculator {

    private static HttpsURLConnection connection;

    private static BigDecimal getExchangeRate(String apiResponse){
        char[] chars = new char[8];

        apiResponse.getChars(11,19,chars,0);
        String exchangeRateInString = new String(chars);
        BigDecimal exchangeRate = new BigDecimal(exchangeRateInString);

        return exchangeRate;
    }

    public static String currencyConverter(String currencyOne, String currencyTwo, String userAmount){

        BigDecimal amountAfterConversion;
        BigDecimal amountForConversion = new BigDecimal(Integer.parseInt(userAmount));


        String line;
        StringBuffer responseContent = new StringBuffer();
        BufferedReader reader;

        try {
            URL url = new URL("https://free.currconv.com/api/v7/convert?q="+currencyOne+"_"+currencyTwo+"&compact=ultra&apiKey=cf9eb88d0d990ddba9d1");
            connection = (HttpsURLConnection) url.openConnection();

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }
            reader.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        BigDecimal exchangeRate = getExchangeRate(responseContent.toString());
        amountAfterConversion = amountForConversion.multiply(exchangeRate);

        String ConvertedAmount = amountAfterConversion.toString();

        return ConvertedAmount;
    }


}
