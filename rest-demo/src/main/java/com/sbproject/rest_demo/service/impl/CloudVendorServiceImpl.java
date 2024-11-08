package com.sbproject.rest_demo.service.impl;

import com.sbproject.rest_demo.exception.CloudVendorNotFoundException;
import com.sbproject.rest_demo.model.CloudVendor;
import com.sbproject.rest_demo.repository.CloudVendorRepository;
import com.sbproject.rest_demo.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {


    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        //More business logic: write here if required
        cloudVendorRepository.save(cloudVendor);
        return "Created Successfully";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        //More business logic: write here if required
        cloudVendorRepository.save(cloudVendor);
        return "Updated Successfully";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        //More business logic: write here if required
        cloudVendorRepository.deleteById(cloudVendorId);
        return "Deleted Successfully";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        //More business logic: write here if required
        if(cloudVendorRepository.findById(cloudVendorId).isEmpty())
            throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        //More business logic: write here if required
        return cloudVendorRepository.findAll();
    }
}
