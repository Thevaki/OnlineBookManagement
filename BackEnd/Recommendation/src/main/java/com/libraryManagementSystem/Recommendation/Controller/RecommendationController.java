package com.libraryManagementSystem.Recommendation.Controller;

import com.libraryManagementSystem.Recommendation.Model.Recommendation;
import com.libraryManagementSystem.Recommendation.Service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@RestController
@RequestMapping("/Recommendation")
@XmlRootElement
public class RecommendationController {

    @Autowired
    RecommendationService recommendationService;

    @RequestMapping(value="/fetchAllCategories",method = RequestMethod.GET)
    public List<Recommendation> fetchAllRecommendations(){
        return recommendationService.fetchAllRecommendation();
    }

//    @RequestMapping(value="/findCategoryBooks/{id}",method = RequestMethod.GET)
//    public List<Recommendation> findCategoryBooks(@PathVariable("id") Integer id){
//        return bookService.findCategoryBooks(id);
//    }


}
