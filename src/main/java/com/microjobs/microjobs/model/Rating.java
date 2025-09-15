package com.microjobs.microjobs.model;

import java.time.Instant;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "rating")
public class Rating {
    @Id
    @EqualsAndHashCode.Include
    private UUID id = UUID.randomUUID();

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private User rater;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private User ratee;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Match match;

    @Min(value = 0)
    @Max(value = 5)
    private int stars;

    @Size(max = 300)
    private String comment;

    @NotNull
    private Instant createdAt;
}
