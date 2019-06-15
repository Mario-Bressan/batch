package com.bressan.sample.batch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doc")
public class Doc {
    @Id
    @Column(name = "id_doc")
    private Integer id;
    private String descricao;
}
