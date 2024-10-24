package naxusjavaweb.web.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email(message = "Email is not valid", regexp = "{(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])}")
    @NotEmpty(message = "Email cannot be empty")
    private String email;
    @Min(value = 8, message = "Password must be at least 8 characters")
    private String password;

    private String role;

    @ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    @Column(name = "full_name")
    @NotEmpty(message = "Full Name cannot be empty")
    private String fullName;
    @NotEmpty(message = "Address cannot be empty")
    private String address;
    @Pattern(regexp = "(84|0[3|5|7|8|9])+([0-9]{8})\\b", message = "Phone number is not valid")
    @NotEmpty(message = "Phone cannot be empty")
    private String phone;

    @Size(max = 255, message = "Image path cannot exceed 255 characters")
    private String image;
    @Size(max = 1000, message = "Notes must not exceed 1000 characters.")
    private String note;

    @NotNull(message = "Creation date cannot be blank")
    @Past(message = "The creation date must be a date in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datecreate;

    public String getDateCreate() {
        return new SimpleDateFormat("dd/MM/yyyy").format(this.datecreate);

    }

}
