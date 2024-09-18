package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String nationality;
    private String email;
    private String mobileNumber;
    private String address;
    private String city;
    private String province;
    private String postalCode;
    private String country;
    private String guardiansName;
    private String guardiansPhoneNumber;
    private String guardiansEmail;
    private String signature;
    private LocalDate date;
    private String imageName;
    private String imagePath;
}
