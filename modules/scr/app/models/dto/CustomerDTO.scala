package models.dto

case class CustomerDTO(
                          firstName: String,
                          lastName: String,
                          licenseNumber: String,
                          city: String,
                          street: String,
                          email: String,
                          password: String
                      )