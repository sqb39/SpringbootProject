package dev.saqib.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<>();

    List<Run> findAll(){
        return runs;
    }

    Run findById(Integer id){
        return runs.stream().filter(run -> run.id().equals(id))
                .findFirst()
                .get();
    }

    @PostConstruct
    private void init(){
        runs.add(new Run(1,
                "MondayRun",
                LocalDateTime.now(),
                LocalDateTime.now().plus(1, ChronoUnit.HOURS),
                1,
                Location.OUTDOOR));

        runs.add(new Run(2,
                "WednesdayRun",
                LocalDateTime.now(),
                LocalDateTime.now().plus(2, ChronoUnit.HOURS),
                2,
                Location.INDOOR));
    }
}
