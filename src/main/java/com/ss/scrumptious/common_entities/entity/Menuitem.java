package com.ss.scrumptious.common_entities.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import com.ss.scrumptious.common_entities.dto.MonetaryAmountConverter;
import lombok.*;

import javax.money.MonetaryAmount;
import javax.money.NumberValue;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name="MENUITEM")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Menuitem {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    Restaurant restaurant;

	@NotBlank
	private String name;

	@NotNull
	@Convert(converter = MonetaryAmountConverter.class)
	@Column(name = "price", columnDefinition="float")
    private MonetaryAmount price;

	@Column(columnDefinition = "TINYINT")
	@Builder.Default
	private Boolean isAvailable = false;

	private String picture;

	private String description;

	private String size;

	@Builder.Default
	private float discount = 0;

	@ManyToMany
	@EqualsAndHashCode.Exclude
	@JoinTable(name = "menuitem_tag", joinColumns = {@JoinColumn(name = "menuitem_id")},
			inverseJoinColumns = {@JoinColumn(name = "tag_id")})
	private Set<Tag> tags;

	@ManyToMany
	@EqualsAndHashCode.Exclude
	@JoinTable(name = "menuitem_category", joinColumns = {@JoinColumn(name = "menuitem_id")},
			inverseJoinColumns = {@JoinColumn(name = "category_id")})
	private Set<MenuCategory> categories;

	public NumberValue getPrice(){
		return price.getNumber();
	}
}
