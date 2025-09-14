package com.microjobs.microjobs.model;

import java.time.Instant;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "interest")
public class Interest {
    @Id
    @EqualsAndHashCode.Include
    private UUID id = UUID.randomUUID();

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Job job;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private User helper;

    @NotNull
    private Instant createdAt;
}
