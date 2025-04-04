package com.bootcoding.utils.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import com.bootcoding.utils.converter.StringListConverter;
import com.bootcoding.utils.converter.StringMapConverter;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "coding_question")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CodingQuestion {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private UUID id;

    @Version
    @Column(name = "version")
    private Long version; // Optimistic locking

    @Column(name = "title", nullable = false, columnDefinition = "TEXT")
    private String title;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "topic", nullable = false, length = 255)
    private String topic;

    @Column(name = "subtopic", length = 255)
    private String subtopic;

    @Column(name = "level", length = 50)
    private String level;

    @Convert(converter = StringListConverter.class)
    @Column(name = "tags", columnDefinition = "TEXT")
    private List<String> tags;

    @Convert(converter = StringMapConverter.class)
    @Column(name = "examples", columnDefinition = "TEXT")
    private Map<String, String> examples;

    @Convert(converter = StringMapConverter.class)
    @Column(name = "constraints", columnDefinition = "TEXT")
    private Map<String, String> constraints;

    @Convert(converter = StringMapConverter.class)
    @Column(name = "hints", columnDefinition = "TEXT")
    private Map<String, String> hints;

    @Convert(converter = StringMapConverter.class)
    @Column(name = "test_cases", columnDefinition = "TEXT")
    private Map<String, String> testCases;

    @Convert(converter = StringMapConverter.class)
    @Column(name = "code_snippets", columnDefinition = "TEXT")
    private Map<String, String> codeSnippets;
}
