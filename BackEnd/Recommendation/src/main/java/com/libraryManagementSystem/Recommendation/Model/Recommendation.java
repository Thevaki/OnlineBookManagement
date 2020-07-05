package com.libraryManagementSystem.Recommendation.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recommendationId;
    private String userId;//pk of user
    private String bookId;//pk of book
    private String date;
    private Integer noOfVisit;
}
