package ru.shakhin.service;

import ru.shakhin.dao.TimeTableDAO;
import ru.shakhin.model.TimeTable;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kostya on 21.12.2014.
 */
public class TimeTableService {
    @Inject
    TimeTableDAO timeTableDAO;

    public List<TimeTable> getTimeTableStation(String station) {
        List tableList = timeTableDAO.findAll();
        List<TimeTable> tableListStation = new ArrayList();
        for(TimeTable row :(List<TimeTable>)tableList){
            if(row.getStation().getName().equals(station)){
                tableListStation.add(row);
            }
        }

        return tableListStation;
    }
    public List<TimeTable> getTrainPath(String trainDirection, String trainNumber){
        List<TimeTable> pathList =(List<TimeTable>)timeTableDAO.findAllByDirectionAndNumber(trainDirection,
                trainNumber);
        return pathList;
    }
}
