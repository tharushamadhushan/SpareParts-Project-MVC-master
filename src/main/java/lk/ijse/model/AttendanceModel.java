package lk.ijse.model;

import lk.ijse.Util.CrudUtil;
import lk.ijse.dto.Attendance;

import java.lang.ref.Reference;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AttendanceModel {
    public static boolean save(Attendance attendance) throws SQLException {
        String sql = "INSERT INTO attendance (employeeId,attendance,date) VALUES (?,?,?)";
        return CrudUtil.execute(sql,attendance.getEmployeeId(),attendance.getAttendance(),attendance.getDate());
    }
}
