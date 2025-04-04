package com.bootcoding.utils.service;

import com.bootcoding.utils.entity.CodingQuestion;
import com.bootcoding.utils.repository.CodingProblemRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CodingProblemService {

    private final CodingProblemRepository repository;
    private final ObjectMapper objectMapper;

    public CodingProblemService(CodingProblemRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    public void insertDataFromJson() {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("coding_problem.json");
            if (inputStream == null) {
                throw new RuntimeException("File not found: coding_problem.json");
            }

            List<CodingQuestion> problems = objectMapper.readValue(inputStream, new TypeReference<List<CodingQuestion>>() {});
            System.out.println("Number of problems parsed: " + problems.size());

            List<CodingQuestion> newProblems = problems.stream()
                    .filter(problem -> problem.getId() == null || !repository.existsById(problem.getId()))
                    .collect(Collectors.toList());

            repository.saveAll(newProblems);
            System.out.println("Successfully inserted " + newProblems.size() + " new coding problems.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

