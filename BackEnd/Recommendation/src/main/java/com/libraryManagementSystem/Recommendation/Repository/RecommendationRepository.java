package com.libraryManagementSystem.Recommendation.Repository;

import com.libraryManagementSystem.Recommendation.Model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationRepository extends JpaRepository<Recommendation,Integer> {
}
