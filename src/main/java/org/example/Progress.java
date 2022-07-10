package org.example;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Setter
@Getter
public class Progress {

    private Duration studyDuration;

    private boolean finished;
}
