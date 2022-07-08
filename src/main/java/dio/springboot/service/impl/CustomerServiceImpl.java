package dio.springboot.service.impl;

import dio.springboot.model.Address;
import dio.springboot.model.Customer;
import dio.springboot.repository.AddressRepository;
import dio.springboot.repository.CustomerRepository;
import dio.springboot.service.CustomerService;
import dio.springboot.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ViaCepService viaCepService;
    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        return customerOptional.orElse(null);
    }

    @Override
    public void insert(Customer customer) {
        saveCustomerWithCompleteAddress(customer);
    }

    @Override
    public void update(Long id, Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()){
            saveCustomerWithCompleteAddress(customer);
        }
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    private void saveCustomerWithCompleteAddress(Customer customer){
        String customerCep = customer.getAddress().getCep();
        Address customerAddress = addressRepository.findById(customerCep).orElseGet(()->{
            Address newAddress = viaCepService.consultCep(customerCep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        customer.setAddress(customerAddress);
        customerRepository.save(customer);
    }
}
