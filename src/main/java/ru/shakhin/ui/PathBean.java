package ru.shakhin.ui;

import org.springframework.context.annotation.Scope;
import ru.shakhin.model.TimeTable;
import ru.shakhin.service.TimeTableService;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

/**
 * Created by Kostya on 21.12.2014.
 */
@Named(PathBean.BEAN_NAME)
@Scope("session")
public class PathBean {

    public static final String BEAN_NAME = "pathBean";

    @Inject
    TimeTableService timeTableService;

    private List<TimeTable> listTimeTable;

    private String stationName;
    private String trainNumber;
    private String trainDirection;

    public List<TimeTable> getListTrainPath(String trainDirection,String trainNumber) {
        return timeTableService.getTrainPath(getTrainDirection(),getTrainNumber());
    }

    public String outCome() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        setTrainNumber( params.get("trainNumber"));
        setTrainDirection( params.get("trainDirection"));
        return "pathtrain.xhtml";
    }




    public String getStationName() {
        if(stationName == null || stationName.isEmpty()){
            return "Saratov";
        }
        else return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getTrainNumber() {
        if(trainNumber == null || trainNumber.isEmpty()){
            return "1342";
        }
        else return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainDirection() {
        if(trainDirection == null || trainDirection.isEmpty()){
            return "Anisovka-Tatishevo";
        }
        else return trainDirection;
    }

    public void setTrainDirection(String trainDirection) {
        this.trainDirection = trainDirection;
    }
}
