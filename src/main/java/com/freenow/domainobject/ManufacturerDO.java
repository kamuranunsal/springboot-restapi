package com.freenow.domainobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "manufacturer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ManufacturerDO {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "manufacturerDO")
    private List<CarDO> cars;

}
