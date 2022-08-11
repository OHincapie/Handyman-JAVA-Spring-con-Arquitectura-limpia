package co.com.ias.handyman.service.application.domain.valueObjs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeWorked {
    static Calendar cal = Calendar.getInstance();

    public static int calculateHour (Date date) {
        cal.setTime(date);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    public static int calculateHourService (Date startDate, Date endDate) {
        int startTime = calculateHour(startDate);
        int endTime = calculateHour(endDate);
        if (endTime > startTime) {
            return endTime - startTime;
        }
        return 0;
    }

    public static int calculateDayWeek (Date date) {
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public static int calculateWeek (Date date) {
        cal.setTime(date);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    public static int calculateHorasNocturnas (Date start, Date end) {

        int startTime = calculateHour(start);
        int endTime = calculateHour(end);

        int startNight = 20;
        int endNigth = 7;
        int midNigth = 23;
        if (startTime <= endNigth && endTime <= endNigth) {
            return endTime - startTime;
        }else if(startTime < endNigth && endTime < startNight){
            return endNigth - startTime;
        } else if(startTime > endNigth && endTime >startNight){
            return endTime-startNight;
        }else if(startTime >= startNight && endTime> startNight){
            return endTime-startTime;
        }else if(startTime<endNigth && endTime>startNight){
            return (endNigth-startTime)+(endTime-startNight);
        }else {return 0;}
    }


    public static int calculateHorasExtras (int TotalHoras) {
        int horasLaborales = 48;
        if (TotalHoras > horasLaborales) {
            return TotalHoras - horasLaborales;
        } else {
            return 0;
        }
    }

    public static int calculateHorasComunes (Date startDate, Date endDate) {
        return calculateHourService(startDate, endDate);
    }

    public static int calculateHorasDominicales (Date startDate, Date endDate,int TotalHoras) {
        int dia = calculateDayWeek(startDate);
        int horasLaborales = 48;
        if (dia == 7 &&calculateHorasExtras(TotalHoras)>0) {
            return calculateHourService(startDate, endDate);
        } else {
            return 0;
        }
    }

    public static int calculateHorasExtrasDomingo (Date startDate, Date endDate,int TotalHoras) {
        int dia = calculateDayWeek(startDate);
        int horasLaborales = 48;
        if (calculateHourService(startDate, endDate)<horasLaborales && dia == 7) {
            return calculateHourService(startDate, endDate);
        } else {
            return 0;
        }
    }
    public static int calculateHorasExtrasNocturnas(Date startDate, Date endDate, int totalHoras) {
        int horasLaborales = 48;
        if (calculateHourService(startDate, endDate)<horasLaborales) {
            return calculateHorasExtras(totalHoras);
        } else {
            return 0;
        }

    }

    public static Date formatDate (String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy HH:mm");
        return formatter.parse(date);
    }

}

