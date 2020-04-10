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
//import net.aksingh.owmjapis.model.DailyWeatherForecast;
//import net.aksingh.owmjapis.model.HourlyWeatherForecast;
public class WeatherApp {

    /**
     * @param args the command line arguments
     * @throws net.aksingh.owmjapis.api.APIException
     * 
     * Work on the setLanguage and setAccuracy and the commented imports.
     */
    public static void main(String[] args) throws APIException {
        // TODO code application logic here
        Scanner wLoc = new Scanner(System.in);
                
            // declaring object of "OWM" class
            OWM owm = new OWM("fba9f12b592bc739ef460d7125353aa1");
            owm.setAccuracy(OWM.Accuracy.ACCURATE); //Accuracy readings.
            owm.setLanguage(OWM.Language.ENGLISH); //To change language. 
            owm.setUnit(OWM.Unit.METRIC); //To Manipulate the Units... Readings unit will be altered. You change.
            
            // getting current weather data from the inputed city
            //City or State first then Country. Seperate with a comma.
            System.out.print("Input Location: ");
            String cityLoc = wLoc.nextLine();
            CurrentWeather cwd = owm.currentWeatherByCityName(cityLoc);
//            DailyWeatherForecast dwf = owm.dailyWeatherForecastByCityName(cityLoc);
//            HourlyWeatherForecast hwf = owm.hourlyWeatherForecastByCityName(cityLoc);
            System.out.println("");
    
            //printing city name from the retrieved data
            System.out.println("City: " + cwd.getCityName());
            
            //for Current Weather.
            //The (.has) method checks if it exist. If the requested values exist, It displays true else false.
            try{
            System.out.println("Latitude: " + cwd.getCoordData().hasLatitude() + " " + cwd.getCoordData().getLatitude());
            System.out.println("Longitude: " + cwd.getCoordData().hasLongitude() + " " + cwd.getCoordData().getLatitude());
            System.out.println("");
            
            System.out.println("Weather ID: " + cwd.getWeatherList().get(0).getConditionId());
            System.out.println("Weather Info: " + cwd.getWeatherList().get(0).getMainInfo());
            System.out.println("Weather Detailed Info: " + cwd.getWeatherList().get(0).getMoreInfo());
            System.out.println("Weather Icon Code: " + cwd.getWeatherList().get(0).getIconCode());
            System.out.println("Weather Icon Link: " + cwd.getWeatherList().get(0).getIconLink());
            System.out.println("");
            
//            double cTemp =  Math.round(cwd.getMainData().getTemp() - 273.15);
//            double fTemp =  Math.round((cwd.getMainData().getTemp() - 273.15)*9/5+32);
//            System.out.println("Main Temperature: " + cTemp + "'C");
//            System.out.println("Main Temperature: " + fTemp + "'F");
            System.out.println("Main Temperature: " + cwd.getMainData().getTemp() + "'C");
            System.out.println("Main Temperature Max: " + cwd.getMainData().getTempMax() + "'C");
            System.out.println("Main Temperature Min: " + cwd.getMainData().getTempMin() + "'C");
            System.out.println("Main Humidity: " + cwd.getMainData().getHumidity() + "%");
            System.out.println("Main Pressure: " + cwd.getMainData().getPressure() + " hPa");
            System.out.println("");
            
            System.out.println("Wind Speed: " + cwd.getWindData().getSpeed() + " mps");
            System.out.println("Wind Gust: " + cwd.getWindData().getGust() + " m");
            System.out.println("Wind Degree: " + cwd.getWindData().getDegree() + "'");
            System.out.println("");
            
            System.out.println("Cloud: " + cwd.getCloudData().getCloudiness() + "%");
            System.out.println("");
            
            System.out.println("Date and Time DATE: " + cwd.getDateTime().getDate());
            System.out.println("Date and Time DAY: " + cwd.getDateTime().getDay());
            System.out.println("Date and Time HOURS: " + cwd.getDateTime().getHours());
            System.out.println("Date and Time MINUTES: " + cwd.getDateTime().getMinutes());
            System.out.println("Date and Time MONTH: " + cwd.getDateTime().getMonth());
            System.out.println("Date and Time SECONDS: " + cwd.getDateTime().getSeconds());
            System.out.println("Date and Time TIME: " + cwd.getDateTime().getTime());
            System.out.println("Date and Time TIMEZONE: " + cwd.getDateTime().getTimezoneOffset());
            System.out.println("Date and Time YEAH: " + cwd.getDateTime().getYear());
            System.out.println("Date and Time: " + cwd.getDateTime().getHours() + ":" + cwd.getDateTime().getMinutes());
            System.out.println("");
            
            System.out.println("System ID: " + cwd.getSystemData().getId());
            System.out.println("System Type: " + cwd.getSystemData().getType());
            System.out.println("System Country Code: " + cwd.getSystemData().getCountryCode()); //part 2
            System.out.println("System Sunrise Date and Time: " + cwd.getSystemData().getSunriseDateTime().getHours() + ":" + cwd.getSystemData().getSunriseDateTime().getMinutes());
            System.out.println("System Sunset Date and Time: " + cwd.getSystemData().getSunsetDateTime());
            System.out.println("");
            
            System.out.println("Resp Code: " + cwd.getRespCode()); //Understand
            System.out.println("City ID: " + cwd.getCityId());
            System.out.println("City Name: " + cwd.getCityName());
            System.out.println("Base Station: " + cwd.getBaseStation());
            }catch(Exception e){
                System.out.println(e);
            }            
    }
}
