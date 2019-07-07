package com.example.acquirerdatacontrol.repository;

import com.example.acquirerdatacontrol.model.File;
import com.example.acquirerdatacontrol.model.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {

    @Query(value = "SELECT acquirer_name, COUNT(DISTINCT establishment, date(create_at)) as establishment_count, date(create_at) as send_date FROM file WHERE status!='Reijeitado' GROUP BY acquirer_name, date(create_at) ORDER BY date(create_at)",
    nativeQuery = true)
    List<Statistics> getStatisticsFile();

    @Query(value = "SELECT acquirer_name, COUNT(DISTINCT establishment, date(create_at)) as establishment_count, date(create_at) as send_date FROM file WHERE status!='Reijeitado' AND acquirer_name=:acquirer GROUP BY acquirer_name, date(create_at) ORDER BY date(create_at)",
            nativeQuery = true)
    List<Statistics> getStatisticsFileByName(@Param("acquirer") String acquirer);

    @Query(value = "SELECT acquirer_name, COUNT(DISTINCT establishment, date(create_at)) as establishment_count, date(create_at) as send_date FROM file WHERE status!='Reijeitado' AND acquirer_name=:acquirer AND date(create_at) <= :final_date AND date(create_at) > :initial_date GROUP BY acquirer_name, date(create_at) ORDER BY date(create_at)",
            nativeQuery = true)
    List<Statistics> getStatisticsFileByNameAndDate(@Param("acquirer") String acquirer, @Param("initial_date") String initial_date, @Param("final_date") String final_date);

//    @Query("SELECT DISTINCT new com.example.acquirerdatacontrol.model.Statistics(establishment,acquirer_name, date(create_at)) FROM File WHERE status <> 'Rejeitado'")
//    List<Statistics> getStatisticsFile();

}
