package co.com.ias.handyman.serviceTechnician.application.services;

import co.com.ias.handyman.infranstructure.models.CalculatorHoursDTO;
import co.com.ias.handyman.infranstructure.models.ServiceTechnicianDTO;
import co.com.ias.handyman.serviceTechnician.application.domain.ServiceTechnician;
import co.com.ias.handyman.serviceTechnician.application.ports.input.CalculatorHoursWorkUseCase;
import co.com.ias.handyman.serviceTechnician.application.ports.output.ServiceTechnicianRepository;
import co.com.ias.handyman.technician.application.domain.valueObjs.TechnicianId;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class CalculatorHoursWorkService implements CalculatorHoursWorkUseCase {

    private final ServiceTechnicianRepository serviceTechnicianRepository;

    public CalculatorHoursWorkService(ServiceTechnicianRepository serviceTechnicianRepository) {
        this.serviceTechnicianRepository = serviceTechnicianRepository;
    }

    @Override
    public Optional<List<CalculatorHoursDTO>> execute(ServiceTechnicianDTO serviceTechnicianDTO) {
        Double hoursAtWeek = 0.0;
        Optional<List<ServiceTechnician>> serviceTechnician = serviceTechnicianRepository.getServiceTechnicianBetweenDates(new TechnicianId(serviceTechnicianDTO.getIdTechnician()), serviceTechnicianDTO.getStartDate(), serviceTechnicianDTO.getFinalDate());
        List<CalculatorHoursDTO> calculatorSomeHoursDTO = new ArrayList<>();
        if (serviceTechnician.isPresent()) {
            for(ServiceTechnician st : serviceTechnician.get()) {
                CalculatorHoursDTO calculatorHoursDTO = CalculatorHoursDTO.fromDomain(st);
                Map<String, Double> hoursMap = calculateHours(calculatorHoursDTO, serviceTechnicianDTO.getStartDate(), serviceTechnicianDTO.getFinalDate(), hoursAtWeek);
                calculatorHoursDTO = setHoursInCalculator(calculatorHoursDTO, hoursMap);
                hoursAtWeek = hoursMap.get("TotalHours");
                calculatorSomeHoursDTO.add(calculatorHoursDTO);
            }
            return Optional.of(calculatorSomeHoursDTO);
        } else {
            return Optional.empty();
        }
    }

    private CalculatorHoursDTO setHoursInCalculator(CalculatorHoursDTO calculatorHoursDTO, Map<String, Double> hoursMap) {
        calculatorHoursDTO.setRegularHours(hoursMap.get("RegularHour"));
        calculatorHoursDTO.setNightHour(hoursMap.get("NightHour"));
        calculatorHoursDTO.setRegularHourExtra(hoursMap.get("RegularHourExtra"));
        calculatorHoursDTO.setNightHourExtra(hoursMap.get("NightHourExtra"));
        calculatorHoursDTO.setSundayHour(hoursMap.get("SundayHour"));
        calculatorHoursDTO.setSundayHourExtra(hoursMap.get("SundayHourExtra"));
        calculatorHoursDTO.setTotalHoursByService(hoursMap.get("TotalHoursByService"));
        calculatorHoursDTO.setTotalHours(hoursMap.get("TotalHours"));
        return calculatorHoursDTO;
    }


    public Map<String, Double> calculateHours(CalculatorHoursDTO calculator, LocalDateTime startDateFromUser, LocalDateTime finalDateFromUser, Double hoursWorkedAtWeek) {
        Double hoursWorkedByService, hNoc, hNor, hNocEx, hNorEx, hDom, hDomEx ;
        hoursWorkedByService= hNoc= hNor= hNocEx= hNorEx= hDom= hDomEx = 0.0;
        LocalDateTime[] datesValues = setDates(calculator, startDateFromUser, finalDateFromUser);
        LocalDateTime startDateAux =  datesValues[0];
        LocalDateTime finalDateAux = datesValues[1];
        while (startDateAux.isBefore(finalDateAux)) {
            for (int i =0; startDateAux.isBefore(finalDateAux); i++){
                //Validar que las horas  y fechas sean iguales y a partir de ahi trabajar sobre minutos
                String qualifyHour = qualifyHours(startDateAux, hoursWorkedAtWeek);
                switch (qualifyHour) {
                    case "HNOC" -> {
                        hNoc++;
                    }
                    case "HNOR" -> {
                        hNor++;
                    }
                    case "HNOCEXTRA" -> {
                        hNocEx++;
                    }
                    case "HNOREXTRA" -> {
                        hNorEx++;
                    }
                    case "HDOM" -> {
                        hDom++;
                    }
                    case "HDOMEXTRA" -> {
                        hDomEx++;
                    }
                    default -> {
                    }
                }
                if(qualifyHour != "") {
                    hoursWorkedAtWeek++;
                    hoursWorkedByService++;
                }
                startDateAux = startDateAux.plusHours(1);
            }
        }
        Map<String, Double> hours = setQualifyHours(hNoc, hNor, hNocEx, hNorEx, hDom, hDomEx, hoursWorkedByService, hoursWorkedAtWeek);
        return hours;
    }


    public String qualifyHours(LocalDateTime dateToAnalyze, Double hoursWorkedAtWeek) {
        if(dateToAnalyze.getDayOfWeek() != DayOfWeek.SUNDAY) {
            if(((dateToAnalyze.getHour() >= 20)|| dateToAnalyze.getHour() < 7) && hoursWorkedAtWeek < 48) {
                return "HNOC";
            } else if((dateToAnalyze.getHour() >= 7 || dateToAnalyze.getHour() <= 20) && hoursWorkedAtWeek < 48) {
                return "HNOR";
            } else if(((dateToAnalyze.getHour() >= 20 )|| dateToAnalyze.getHour() < 7) && hoursWorkedAtWeek >= 48) {
                return "HNOCEXTRA";
            }
            else if((dateToAnalyze.getHour() >= 7 || dateToAnalyze.getHour() <= 20) && hoursWorkedAtWeek >= 48) {
                return "HNOREXTRA";
            }
        } else {
            if(hoursWorkedAtWeek >= 48) {
                return "HDOMEXTRA";
            } else {
                return "HDOM";
            }
        }
        return "";
    }

    public LocalDateTime[] setDates(CalculatorHoursDTO calculator, LocalDateTime startDateFromUser, LocalDateTime finalDateFromUser) {
        LocalDateTime[] dates = new LocalDateTime[2];
        LocalDateTime startDateAux, finalDateAux;
        startDateAux =  LocalDateTime.now();
        finalDateAux = LocalDateTime.now();
        if(calculator.getStartDate().isAfter(startDateFromUser) && calculator.getFinalDate().isBefore(finalDateFromUser)) {
            startDateAux = calculator.getStartDate();
            finalDateAux = calculator.getFinalDate();
        } else if(calculator.getStartDate().isAfter(startDateFromUser) && calculator.getFinalDate().isAfter(finalDateFromUser)) {
            startDateAux = calculator.getStartDate();
            finalDateAux = finalDateFromUser;
        } else if(calculator.getStartDate().isBefore(startDateFromUser) && calculator.getFinalDate().isBefore(finalDateFromUser)) {
            startDateAux = startDateFromUser;
            finalDateAux = calculator.getFinalDate();
        }
        dates[0] = startDateAux;
        dates[1] = finalDateAux;
        return dates;
    }

    public Map<String, Double> setQualifyHours(Double hNoc,Double hNor,Double hNocEx,Double hNorEx,Double hDom, Double hDomEx, Double hoursWorkedByService, Double hoursWorkedAtWeek){
        Map<String, Double> hours = new HashMap<String, Double>();
        hours.put("RegularHour", hNor);
        hours.put("NightHour", hNoc);
        hours.put("RegularHourExtra", hNorEx);
        hours.put("NightHourExtra", hNocEx);
        hours.put("SundayHour", hDom);
        hours.put("SundayHourExtra", hDomEx);
        hours.put("TotalHoursByService", hoursWorkedByService);
        hours.put("TotalHours", hoursWorkedAtWeek);
        return hours;
    }
}
