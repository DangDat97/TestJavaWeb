package naxusjavaweb.web.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
// import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "reviews")
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Product is required")
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @NotNull(message = "User is required")
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull(message = "Rating is required")
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must be at most 5")
    @Column(nullable = false)
    private Integer rating;

    @Size(max = 1000, message = "Comment must not exceed 1000 characters")
    @Column(length = 1000)
    private String comment;

    @NotNull(message = "Created date is required")
    @PastOrPresent(message = "Created date must be in the past or present")
    @Column(nullable = false)

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Updated date must be in the past or present")
    @Column
    private Date updatedAt;
}