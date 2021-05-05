package org.sefglobal.scholarx.model;

import org.sefglobal.scholarx.util.QuestionCategory;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String Question;

    @Column(nullable = false)
    private QuestionCategory category;

    @ManyToOne
    @JoinColumn(name = "program_id")
    private Program program;

    @OneToMany(mappedBy = "question")
    private List<MentorResponse> mentorResponses;

    public Question() {}

    public Question(long id, String question, QuestionCategory category, Program program) {
        this.id = id;
        Question = question;
        this.category = category;
        this.program = program;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public QuestionCategory getCategory() {
        return category;
    }

    public void setCategory(QuestionCategory category) {
        this.category = category;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
