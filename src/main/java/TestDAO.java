import org.springframework.context.support.GenericXmlApplicationContext;
import ru.shakhin.dao.StationDAO;
import ru.shakhin.dao.TimeTableDAO;
import ru.shakhin.dao.TrainDAO;
import ru.shakhin.model.Station;
import ru.shakhin.model.Train;
import ru.shakhin.model.TimeTable;

import java.util.List;

/**
 * Created by Kostya on 20.12.2014.
 */
public class TestDAO {
    public static void main(String[] args){
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:/spring/core-context.xml");
        ctx.refresh();
        TrainDAO trainDAO = ctx.getBean("trainDAO",TrainDAO.class);
        List<Train> list = trainDAO.findAll();
        for(Train train : list) {
            System.out.println(train.getId()+"<>"+ train.getNumber());
        }
        StationDAO stationDAO = ctx.getBean("stationDAO",StationDAO.class);
        List<Station> listStations = stationDAO.findAll();
        for(Station station : listStations) {
            System.out.println(station.getId()+"<>"+ station.getName());
        }
        TimeTableDAO timetableDAO = ctx.getBean("timetableDAO",TimeTableDAO.class);
        List<TimeTable> listTimeTables = timetableDAO.findAll();
        for(TimeTable timeTable : listTimeTables) {
            System.out.println(timeTable.getId()+"<>"+ timeTable.getTrain().getNumber()+
                    "<>"+ timeTable.getStation().getName()+"<>"+ timeTable.getDirection().getName()+
                    "<>"+ timeTable.getTime());
        }
        listTimeTables = timetableDAO.findAllByDirectionAndNumber("Tarhanuy-Kokyrino", "1792");
        for(TimeTable timeTable : listTimeTables) {
            System.out.println(timeTable.getId()+"<>"+ timeTable.getTrain().getNumber()+
                    "<>"+ timeTable.getStation().getName()+"<>"+ timeTable.getDirection().getName()+
                    "<>"+ timeTable.getTime());
        }


    }
}
