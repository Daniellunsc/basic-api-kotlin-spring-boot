package com.kotlinAPI.demo.domain

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class User (val id: String, val name: String) {
}