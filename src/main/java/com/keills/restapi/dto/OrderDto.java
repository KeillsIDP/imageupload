package com.keills.restapi.dto;

import com.keills.restapi.model.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {
    private Long id;

    private String title;

    private String description;

    private int price;

    private byte[] image;

    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date startDate;

    public static OrderDto toModel(Order order){
        OrderDto model = new OrderDto();
        model.setId(order.getId());
        model.setTitle(order.getTitle());
        model.setDescription(order.getDescription());
        model.setPrice(order.getPrice());
        model.setStartDate(order.getStartDate());
        return model;
    }

}
