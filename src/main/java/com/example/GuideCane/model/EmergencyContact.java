package com.example.GuideCane.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "emergencyContact")
public class EmergencyContact {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @OneToOne
    @JoinColumn(name = "devicecode")
    private Device deviceCode;
    @Column(name="contactPerson")
    private String contactPerson;
    @Column(name="contactNo")
    private String contactNo;
    @Column(name="Relationship")
    private String relationship;

    public EmergencyContact(Device deviceCode, String contactPerson, String contactNo, String relationship) {
        this.deviceCode = deviceCode;
        this.contactPerson = contactPerson;
        this.contactNo = contactNo;
        this.relationship = relationship;
    }
}