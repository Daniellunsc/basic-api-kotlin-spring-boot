package com.kotlinAPI.demo.converters

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
class UserCreateRequest {
    lateinit var name: String;
}