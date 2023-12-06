package com.example.backend.pojo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String username;

    @NotNull
    @Size(min = 6)
    private String password;

    @NotNull
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Pattern(regexp = "1[3-9][0-9]{9}")
    private String phone;

    @Transient
    private SportRecordEntity[] records;

}
