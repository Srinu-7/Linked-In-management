package LinkedInManagementSystem.example.LinkedInManagement.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_like")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // user -- like --- post


    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private User user;


    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Post post;
}
