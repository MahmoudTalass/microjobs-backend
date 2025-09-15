package com.microjobs.microjobs.model;

import java.time.Instant;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.GenerationType;
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
@Table(name = "tag")
public class Tag {
    @Id
    @EqualsAndHashCode.Include
    private UUID id = UUID.randomUUID();

    @NotNull
    @Size(min = 1, max = 25)
    @Column(length = 25, unique = true)
    private String name;

    @NotNull
    private Instant createdAt;
}
