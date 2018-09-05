package com.TacoCloud.TacoCloud.Domain.Entities;

import java.util.List;
import lombok.Data;

@Data
public class Taco {

    private String       name;
    private List<String> ingredients;

}
