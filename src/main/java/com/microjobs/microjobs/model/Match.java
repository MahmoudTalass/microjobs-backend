package com.microjobs.microjobs.model;

import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "match")
public class Match {
    @Id
    @EqualsAndHashCode.Include
    private UUID id = UUID.randomUUID();

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    private Job job;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private User helper;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private User client;
}
