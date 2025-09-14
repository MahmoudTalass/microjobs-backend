package com.microjobs.microjobs.model;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
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
@Table(name = "_user")
public class User {
    @Id
    private UUID id = UUID.randomUUID();

    @NotNull
    @Size(min = 1, max = 36)
    @Column(unique = true)
    private String name;

    @NotBlank
    @Email(regexp = "^[a-z0-9._%+-]{1,64}@(terpmail\\.)?umd\\.edu$")
    @Size(max = 255)
    @Column(unique = true)
    private String email;

    @Size(max = 500)
    private String bio;

    @NotNull
    private boolean isBanned = false;

    @OneToMany(mappedBy = "helper", fetch = FetchType.LAZY)
    private Set<Interest> jobInterests = new HashSet<>();

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Set<Job> jobs = new HashSet<>();

    @NotNull
    private Instant joinedAt;
}