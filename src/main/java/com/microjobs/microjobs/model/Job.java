package com.microjobs.microjobs.model;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;
import com.microjobs.microjobs.helpers.Enums.CompensationType;
import com.microjobs.microjobs.helpers.Enums.JobStatus;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "job")
public class Job {
    @Id
    @EqualsAndHashCode.Include
    private UUID id = UUID.randomUUID();

    @NotBlank
    @Size(min = 1, max = 60)
    private String title;

    @NotBlank
    @Size(min = 1, max = 1200)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private User client;

    @NotNull
    @Enumerated(EnumType.STRING)
    private JobStatus status;

    @NotBlank
    @Size(max = 80)
    private String location;

    @NotNull
    private Instant dueOn;

    @NotNull
    private Instant createdAt;

    @NotNull
    private Instant updatedAt;

    @NotNull
    @Min(value = 15)
    @Max(value = 360)
    private int durationMinutes;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @Size(min = 1, max = 3)
    private Set<CompensationType> compensationType;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(joinColumns = @JoinColumn(name = "job_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
    private Set<Tag> tags;

    @NotNull
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "job")
    private Set<Image> images;
}
