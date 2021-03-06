package com.example.GuideCane.repository;

        import java.util.List;

        import com.example.GuideCane.model.Device;
        import com.example.GuideCane.model.HeartBeat;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.stereotype.Repository;

@Repository
public interface HeartBeatRepository extends JpaRepository<HeartBeat,Long> {
    List<HeartBeat> findAll();
    List<HeartBeat> findByDeviceCode(Device DeviceCode);
    @Query(value = "SELECT *  FROM `heart_beat` WHERE `devicecode` = :DeviceCode ORDER BY create_time DESC LIMIT 0 , 1",nativeQuery = true)
    HeartBeat findMaxTimeHeartBeat(Device DeviceCode);
}
