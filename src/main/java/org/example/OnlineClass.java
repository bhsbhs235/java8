package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class OnlineClass {
    private Integer id;

    private String title;

    private boolean closed;

    private Progress progress;

    public OnlineClass(Integer id, String title, boolean closed){
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public Optional<Progress> getProcess(){
        // return Optional.of(progress); progress가 null이면 nullException
        return Optional.ofNullable(progress);
    }

}
