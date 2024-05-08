package dev.saqib.runnerz.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(
        Integer id,
        @NotEmpty //Uses spring-boot-starter-validation in dependency
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive //Uses spring-boot-starter-validation in dependency
        Integer miles,
        Location location
) {
    //Executes this checking each time during new Run creation
    public Run{
        if (!completedOn.isAfter(startedOn)){
            throw new IllegalArgumentException("Completed On must be after Started On");
        }
    }
}
