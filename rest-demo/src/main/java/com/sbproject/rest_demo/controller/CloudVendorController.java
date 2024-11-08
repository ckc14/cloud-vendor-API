package com.sbproject.rest_demo.controller;

import java.util.List;
import com.sbproject.rest_demo.model.CloudVendor;
import com.sbproject.rest_demo.response.ResponseHandler;
import com.sbproject.rest_demo.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    //Read specific cloud vendor details
    @GetMapping("{vendorId}")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String VendorId){

        return ResponseHandler.responseBuilder("Requested vendor details are given here",
                HttpStatus.OK, cloudVendorService.getCloudVendor(VendorId));

    }

    //Read all cloud vendor details
    @GetMapping()
    public List<CloudVendor> getAllCloudVendorDetails(){

        return cloudVendorService.getAllCloudVendors();
    }


    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){

        cloudVendorService.createCloudVendor(cloudVendor);
        return "Cloud Vendor Created Successfully";
    }

    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){

        cloudVendorService.updateCloudVendor(cloudVendor);
        return "Cloud Vendor Updated Successfully";
    }

    @DeleteMapping
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId){

        cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud Vendor deleted Successfully";
    }
}
