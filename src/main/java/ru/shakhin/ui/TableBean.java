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
@Named(TableBean.BEAN_NAME)
@Scope("session")
public class TableBean {
    public static final String BEAN_NAME = "tableBean";


    @Inject
    TimeTableService timeTableService;


    private List<TimeTable> listTimeTable;

    private String stationName;
    public List<TimeTable> getListTimeTable(String stationName) {
        return timeTableService.getTimeTableStation(getStationName());
    }

    public String outCome() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        setStationName( params.get("stationName"));
        return "timetable.xhtml";
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
}
