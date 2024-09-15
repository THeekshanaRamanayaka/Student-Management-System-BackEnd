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
    private String email;
    private String mobileNumber;
    private String gender;
    private String address;
    private String city;
    private String postalCode;
    private String guardiansName;
    private String guardiansAddress;
    private String guardiansPhoneNumber;
    private String guardiansEmail;
}
