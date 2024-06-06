package models.services.car

import com.google.inject.Inject
import models.dao.entities.car.Customer
import models.dao.repositories.car.CustomerRepository
import models.dto.CustomerDTO

trait CustomerService {
    def check(email: String,password: String): Boolean

    def find(id: String): Option[Customer]
    def list(): List[Customer]
    def update(customer: Customer)
    def delete(customer: Customer)
    def insert(customer:  Customer)
    def insert(customer: CustomerDTO): Unit
}
class CustomerServiceImpl @Inject()(val customerRepository: CustomerRepository) extends CustomerService {

    override def check(email: String, password: String): Boolean =
        customerRepository.findByEmailAndPassword(email,password)





    override def find(id: String): Option[Customer] = customerRepository.find(id)

    override def list(): List[Customer] = customerRepository.list()

    override def update(customer: Customer): Unit = customerRepository.update(customer)

    override def delete(customer: Customer): Unit = customerRepository.delete(customer)

    override def insert(customer: Customer): Unit = customerRepository.insert(customer)


    override def insert(customer: CustomerDTO): Unit = customerRepository.insert(customer)


    implicit def customerDTOtoCustomer(c: CustomerDTO): Customer =
        Customer(
            id = (c.email + c.password + c.firstName).hashCode.toString,
            firstName = c.firstName,
            licenseNumber = c.licenseNumber,
            lastName = c.lastName,
            city = c.city,
            street = c.street,
            email = c.email,
            password = c.password,
            role = "USER"
        )
}

