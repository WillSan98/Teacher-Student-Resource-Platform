package Group3_CSC340.TSRP_Backend.Review;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService Reviewservice;

    @GetMapping("/all")
    public String getAllReviews(Model model) {
        model.addAttribute( "reviewList", Reviewservice.getAllReviews());
        return "review-list";
    }

    @GetMapping("/{review_Id}")
    public String getOneReview(@PathVariable int review_Id, Model model) {
        model.addAttribute("review", Reviewservice.getReviewById(review_Id));
        return "t_profile";
    }

    @GetMapping("/createForm")
    public String showCreateForm(){

        return "review-new";
    }

    @PostMapping("/new")
    public String addNewReview(Review review) {
        Reviewservice.saveReview(review);
        return "redirect:/reviews/all";
    }


    @GetMapping("delete/{review_id}")
    public String deleteReviewById(@PathVariable int review_id) {
        Reviewservice.deleteReviewById(review_id);
        return "redirect:/reviews/all";
    }
}
