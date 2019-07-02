package com.example.acquirerdatacontrol.repository;

import com.example.acquirerdatacontrol.model.File;
import com.example.acquirerdatacontrol.model.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {

    @Query(value = "SELECT acquirer_name, COUNT(DISTINCT establishment, date(create_at)) as establishment_count, date(create_at) as send_date FROM file WHERE status!='Reijeitado' GROUP BY acquirer_name, date(create_at) ORDER BY date(create_at)",
    nativeQuery = true)
    List<Statistics> getStatisticsFile();

//    @Query("SELECT DISTINCT new com.example.acquirerdatacontrol.model.Statistics(establishment,acquirer_name, date(create_at)) FROM File WHERE status <> 'Rejeitado'")
//    List<Statistics> getStatisticsFile();

}
