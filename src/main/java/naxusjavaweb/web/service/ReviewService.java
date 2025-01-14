package naxusjavaweb.web.service;

import naxusjavaweb.web.entity.Review;
import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> getAllReviews();

    Optional<Review> getReviewById(Long id);

    Review saveReview(Review review);

    void deleteReview(Long id);

    List<Review> getReviewsByProductId(Long productId);

    List<Review> getReviewsByUserId(Long userId);
}