package com.keills.restapi.controller;

import com.keills.restapi.model.Order;
import com.keills.restapi.service.OrderService;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/orders")
public class OrderController {

    // path to upload images
    @Value("${upload.path}")
    private String uploadPath;
    @Autowired
    private OrderService service;

    //get all orders
    @GetMapping("/")
    public ResponseEntity getOrders(){
        return service.getOrders();
    }

    //create new order, takes order entity and file
    @PostMapping("/create")
    public ResponseEntity createOrder(@RequestPart Order order, @RequestPart(required = true) MultipartFile file) throws IOException {
        try{
            // saving file
            if(!file.isEmpty()){
                System.out.println(uploadPath);
                File folder = new File(uploadPath);
                if(!folder.exists())
                    folder.mkdir();

                String uuidFile = UUID.randomUUID().toString();
                String fileName = uuidFile+"."+file.getOriginalFilename();

                file.transferTo(new File(folder+"/"+fileName));

                order.setFileName(fileName);
                return service.createOrder(order);
            }
            return ResponseEntity.badRequest().body("No image presented");
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }

    //delete order by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOrder(@PathVariable Long id){
        return service.deleteOrder(id);
    }
}
