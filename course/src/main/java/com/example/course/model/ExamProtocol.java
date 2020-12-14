package com.example.course.model;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

//@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamProtocol extends AbstractPersistable<Integer> {

    @Override
    public String toString() {
        return "ExamProtocol{" +
//                "user=" + user +
                ", exam=" + exam +
                ", start=" + start +
                ", finish=" + finish +
                ", questionCount=" + questionCount +
                ", correctAnswers=" + correctAnswers +
                ", grade=" + grade +
                '}';
    }



//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "EXAM_ID")
    private Exam exam;

//    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    private Integer Id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date start;

    @Temporal(TemporalType.TIMESTAMP)
    private Date finish;
    private Integer questionCount;
    private Integer correctAnswers;
    private Integer grade;
}
