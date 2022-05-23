package com.example.GuideCane.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;


@NoArgsConstructor
@Entity
@Data
@AllArgsConstructor
@Table(name = "gps")
public class Gps {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @OneToOne
    @JoinColumn(name = "devicecode")
    private Account deviceCode;
    @Column(name="longitude")
    private String longitude;
    @Column(name="latitude")
    private String latitude;
    @CreationTimestamp
    @Column(name="createTime")
    private Timestamp createTime;

    public Gps(Account deviceCode, String longitude, String latitude) {
        this.deviceCode = deviceCode;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
