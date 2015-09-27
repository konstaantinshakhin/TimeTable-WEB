package ru.shakhin.model;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Kostya on 20.12.2014.
 */
@Entity(name = "TimeTable")
@Table(name = "TIMETABLE")
public class TimeTable {
    private  Long id;
    private Train train;
    private Station station;
    private String time;
    private Direction direction;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @ManyToOne
    @JoinColumn(name = "TRAIN_ID")
    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
    @ManyToOne
    @JoinColumn(name = "STATION_ID")
    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
    @Column(name = "TIME")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    @ManyToOne
    @JoinColumn(name = "DIRECTION_ID")
    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
