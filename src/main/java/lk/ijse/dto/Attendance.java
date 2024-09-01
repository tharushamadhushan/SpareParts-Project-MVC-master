package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Attendance {
    private String employeeId;
    private Date date;
    private String attendance;


}
