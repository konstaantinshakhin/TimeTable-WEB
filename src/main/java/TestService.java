import org.springframework.context.support.GenericXmlApplicationContext;
import ru.shakhin.model.TimeTable;
import ru.shakhin.service.TimeTableService;

import java.util.List;

/**
 * Created by Kostya on 21.12.2014.
 */
public class TestService {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:/spring/core-context.xml");
        ctx.refresh();
        TimeTableService timeTableService = ctx.getBean("timetableservice", TimeTableService.class);
        List<TimeTable> list = timeTableService.getTimeTableStation("Kontakt");
        for(TimeTable timeTable : list) {
            System.out.println(timeTable.getId()+"<>"+ timeTable.getTrain().getNumber()+
                    "<>"+ timeTable.getStation().getName()+"<>"+ timeTable.getDirection().getName()+
                    "<>"+ timeTable.getTime());
        }
         list = timeTableService.getTrainPath("Tatishevo-Anisovka", "1342");
        for(TimeTable timeTable : list) {
            System.out.println(timeTable.getId()+"<>"+ timeTable.getTrain().getNumber()+
                    "<>"+ timeTable.getStation().getName()+"<>"+ timeTable.getDirection().getName()+
                    "<>"+ timeTable.getTime());
        }
    }
}
