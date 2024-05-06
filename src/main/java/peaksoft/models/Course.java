package peaksoft.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {
    private Long id ;
    private String name;
    private String description ;
    private int duration;

    public Course(String name, String description, int duration) {
        this.name = name;
        this.description = description;
        this.duration = duration;
    }
}
