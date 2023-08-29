package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class PatientP0 {
    private Integer patientID;
    private String password;
    private Date birthDate;
    private String gender;
    private String patientName;
    private String phoneNum;
    private String email;
    private String identityNum;
    private String address;
}
