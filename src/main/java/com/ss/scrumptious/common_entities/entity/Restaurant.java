package com.ss.scrumptious.common_entities.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name="RESTAURANT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Restaurant {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@EqualsAndHashCode.Exclude
	private Address address;

    @NotBlank
    private String name;

    @Builder.Default
    private Float rating = 0.f;

    private String phone;

    private String picture;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private PriceCategory priceCategory = PriceCategory.$;

    @Column(columnDefinition = "TINYINT")
    @Builder.Default
    private Boolean isActive = true;

    @ManyToMany
    @EqualsAndHashCode.Exclude
    @JoinTable(name = "restaurant_cuisine", joinColumns = {@JoinColumn(name = "restaurant_id")},
            inverseJoinColumns = {@JoinColumn(name = "cuisine_id")})
    private Set<Cuisine> cuisines;

    @JsonIgnore
    @ManyToOne
    private RestaurantOwner owner;

	public void addRestaurantCuisine(Cuisine rC) {

		cuisines.add(rC);
	}

}
