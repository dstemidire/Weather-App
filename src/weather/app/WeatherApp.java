/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather.app;


/**
 *
 * @author Ibro Yusuf Ola
 */
import java.util.Scanner;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.CurrentWeather;
public class WeatherApp {

    /**
     * @param args the command line arguments
     * @throws net.aksingh.owmjapis.api.APIException
     */
    public static void main(String[] args) throws APIException {
        // TODO code application logic here
        Scanner wLoc = new Scanner(System.in);
        
        // declaring object of "OWM" class
        OWM owm = new OWM("fba9f12b592bc739ef460d7125353aa1");

        // getting current weather data for the "London" city
        System.out.print("Input Location: ");
        String cityLoc = wLoc.nextLine();
        CurrentWeather cwd = owm.currentWeatherByCityName(cityLoc);
        System.out.println("");
        // checking data retrieval was successful or not
        if (cwd.hasRespCode() && cwd.getRespCode() == 200) {
        
            // checking if city name is available
            if (cwd.hasCityName()) {
                //printing city name from the retrieved data
                System.out.println("City: " + cwd.getCityName());
            }
            
            // checking if max. temp. and min. temp. is available
            if (cwd.hasMainData() && cwd.getMainData().hasTempMax() && cwd.getMainData().hasTempMin()) {
                // printing the max./min. temperature
                System.out.println("Temperature: " + cwd.getMainData().getTempMax()
                            + "/" + cwd.getMainData().getTempMin() + "\'K");
            }
        }
    }
    
}
