package com.example.backend.pojo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Table
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VideoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ElementCollection
    private List<String> url;

    @NotNull
    @ElementCollection
    private List<String> title;

    @ElementCollection
    private List<String> brief;
}
