package lk.ijse.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@AllArgsConstructor

public class AttendanceTm {
    private String id;
    private String date;
    private LocalTime time;
    private String attendance;

    public AttendanceTm(String id, LocalDate date, LocalTime now, String text) {

    }
}

