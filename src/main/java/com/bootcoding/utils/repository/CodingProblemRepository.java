package com.bootcoding.utils.repository;

import com.bootcoding.utils.entity.CodingQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CodingProblemRepository extends JpaRepository<CodingQuestion, UUID> {
}
