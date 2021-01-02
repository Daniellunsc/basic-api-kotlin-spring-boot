package com.kotlinAPI.demo.exceptions

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@AllArgsConstructor
@NoArgsConstructor
class CustomExceptionSchema(val message: String, val details: String, val hint: String) {
}