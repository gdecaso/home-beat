package ar.curiosidadesespaciales.homebeat.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Entity
public class BeatEntry {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP")
    private ZonedDateTime dateTime;

    public BeatEntry() { }

    protected BeatEntry(Long id, ZonedDateTime dateTime) {
        this.id = id;
        this.dateTime = dateTime;
    }

    public BeatEntry withZonedDateTimeCopy(ZoneId zone) {
        return new BeatEntry(id, dateTime.withZoneSameInstant(zone));
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(ZonedDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
