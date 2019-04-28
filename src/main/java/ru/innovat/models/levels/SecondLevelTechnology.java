package ru.innovat.models.levels;

import javax.persistence.*;

@Entity
@Table(name = "second_level_technology")
public class SecondLevelTechnology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_second_level_technology;
    @Column(name = "id_first_level_technology")
    private int id_first_level_technology;
    @Column(name = "Name_second_level_technology")
    private String name_second_level_technology;

    public int getId_second_level_technology() {
        return id_second_level_technology;
    }

    public void setId_second_level_technology(int id_second_level_technology) {
        this.id_second_level_technology = id_second_level_technology;
    }

    public int getId_first_level_technology() {
        return id_first_level_technology;
    }

    public void setId_first_level_technology(int id_first_level_technology) {
        this.id_first_level_technology = id_first_level_technology;
    }

    public String getName_second_level_technology() {
        return name_second_level_technology;
    }

    public void setName_second_level_technology(String name_second_level_technology) {
        this.name_second_level_technology = name_second_level_technology;
    }
}




