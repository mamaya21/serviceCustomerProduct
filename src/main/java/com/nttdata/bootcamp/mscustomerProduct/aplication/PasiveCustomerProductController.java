package com.nttdata.bootcamp.mscustomerProduct.aplication;

import com.nttdata.bootcamp.mscustomerProduct.model.PasiveCustomerProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PasiveCustomerProductController {
    @Autowired
    PasiveCustomerProductService pasiveCustomerProductService;

    @PostMapping("pasivecustomerproduct")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<PasiveCustomerProduct> createPasiveCustomProd(@RequestBody PasiveCustomerProduct pasiveCustomerProduct){
        return pasiveCustomerProductService.createPasiveCustomProd(Mono.just(pasiveCustomerProduct));
    }

    @GetMapping(value = "getPasiveCustomerProduct", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<PasiveCustomerProduct> listAll(){
        return pasiveCustomerProductService.listPasiveCustomProdAll();
    }

    @GetMapping(value = "getPasiveCustomerProduct/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<PasiveCustomerProduct> listPasiveCustomProd_Id(@PathVariable("id") Integer id){
        return pasiveCustomerProductService.listPasiveCustomProd_Id(id);
    }

    @DeleteMapping(value = "delete/{id}")
    public Mono<Void> deleteProduct(@PathVariable("id") Integer id){
        return pasiveCustomerProductService.deletePasiveCustomProd(id);
    }
}
