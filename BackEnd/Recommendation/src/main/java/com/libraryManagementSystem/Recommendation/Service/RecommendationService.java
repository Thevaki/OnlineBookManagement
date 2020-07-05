package com.libraryManagementSystem.Recommendation.Service;

import com.libraryManagementSystem.Recommendation.Model.Recommendation;

import java.util.List;

public interface RecommendationService {
   /* Recommendation createRecommendation(Recommendation book);

    Recommendation editRecommendation(Recommendation book);

    Recommendation deleteRecommendation(Integer id);

    Recommendation findRecommendation(Integer id);*/

    List<Recommendation> fetchAllRecommendation();
}
