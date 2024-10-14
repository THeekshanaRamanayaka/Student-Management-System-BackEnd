package edu.icet.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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
    @Lob
    @Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] image;
}
