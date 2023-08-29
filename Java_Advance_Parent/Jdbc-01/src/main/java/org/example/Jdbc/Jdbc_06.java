package org.example.Jdbc;

import org.example.PatientP0;

import java.sql.Date;

public class Jdbc_06 {
    public static void main(String[] args) {
        PatientP0 patient = new PatientP0();
        patient.setPatientID(13);
        patient.setPatientName("张菲");
        patient.setPassword("909000");
        patient.setBirthDate(Date.valueOf("1995-02-12"));
        patient.setGender("女");
        patient.setPhoneNum("13721234423");
        patient.setEmail("fei.zhang@qq.com");
        patient.setIdentityNum("34010199502129999");
        patient.setAddress("北京市");
    }
}
