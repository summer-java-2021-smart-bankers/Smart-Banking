package backend.API;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class CurrencyCalculator {

    private static HttpsURLConnection connection;

    private static double getExchangeRate(String apiResponse){

        double exchangeRate;

        char[] chars = new char[8];
        apiResponse.getChars(11,19,chars,0);
        String exchangeRateInString = new String(chars);
        exchangeRate = Double.parseDouble(exchangeRateInString);
        System.out.println(exchangeRate);

        return exchangeRate;
    }

    public static void currencyConverter(){
        Scanner scanner = new Scanner(System.in);

        //String[] currencies = new String[];
        String currencyOne = "EUR";
        String currencyTwo = "BGN";
        double amountForConversion;
        double amountAfterConversion;

        System.out.println("Enter first currency:");
        currencyOne = scanner.nextLine();
        System.out.println("Enter second currency:");
        currencyTwo = scanner.nextLine();
        System.out.println("Enter amount you would like to convert:");
        amountForConversion = scanner.nextDouble();


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
        double exchangeRate = getExchangeRate(responseContent.toString());
        amountAfterConversion = amountForConversion * exchangeRate;
        System.out.println(amountAfterConversion);

    }


}
