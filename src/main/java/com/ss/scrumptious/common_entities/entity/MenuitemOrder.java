package com.ss.scrumptious.common_entities.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "menuitem_order")
@Builder
public class MenuitemOrder {

    @JsonIgnore
    @EmbeddedId
    MenuitemOrderKey id;

    @ManyToOne
    @MapsId("menuitemId")
    @JoinColumn(name = "menuitem_id")
    Menuitem menuitem;


    Long quantity;
}
