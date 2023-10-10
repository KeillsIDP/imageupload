package com.keills.restapi.service;

import com.keills.restapi.dto.OrderDto;
import com.keills.restapi.model.Order;
import com.keills.restapi.exception.OrderNotFoundException;
import com.keills.restapi.repository.OrderRepo;
import com.keills.restapi.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo repo;

    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public ResponseEntity<Object> getOrders() {
        try{
            Iterable orders = repo.findAll();
            List<OrderDto> result = new ArrayList<OrderDto>();
            for(Object order: orders){
                Order entity = (Order)order;
                OrderDto orderResult = OrderDto.toModel(entity);

                // generating byte array representation of image
                File imageFile = new File(uploadPath+"/"+entity.getFileName());
                orderResult.setImage( Files.readAllBytes(imageFile.toPath()));

                result.add(orderResult);
            }
            return ResponseHandler.responseBuilder("list of orders", HttpStatus.OK,result);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseHandler.responseBuilder("error", HttpStatus.I_AM_A_TEAPOT,"");
        }
    }
    @Override
    public ResponseEntity<Object> createOrder(Order order){
        Date date = Date.valueOf(LocalDate.now());
        return ResponseHandler.responseBuilder("order created", HttpStatus.OK,repo.save(order));
    }
    @Override
    public ResponseEntity<Object> deleteOrder(Long id) throws OrderNotFoundException {
        if(!repo.findById(id).isPresent())
            throw new OrderNotFoundException("Order not found");
        repo.deleteById(id);
        return ResponseHandler.responseBuilder("order deleted", HttpStatus.OK,"");
    }
}
