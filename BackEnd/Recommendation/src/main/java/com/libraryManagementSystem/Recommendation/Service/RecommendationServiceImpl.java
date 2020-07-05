package com.libraryManagementSystem.Recommendation.Service;

import com.libraryManagementSystem.Recommendation.Model.Recommendation;
import com.libraryManagementSystem.Recommendation.Repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationServiceImpl {
    @Autowired
    RecommendationRepository recommendationRepository;

   /* Recommendation createRecommendation(Recommendation book){ }

    Recommendation editRecommendation(Recommendation book){ }

    Recommendation deleteRecommendation(Integer id){ }

    Recommendation findRecommendation(Integer id){ }
*/

   //USERS WHO VIEWED THIS BOOK ALSO VIEWED THESE BOOKS
    List<Recommendation> fetchAllRecommendations(){
        List<Recommendation> recommendations = recommendationRepository.findAll();

        if(recommendations.isEmpty()){
            return null;
        }
        return  recommendations;
    }
}
