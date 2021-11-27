package com.br.gook.bff.user.dto

import javax.validation.constraints.NotBlank

data class UserRequest(
    @NotBlank(message = "Name not informed")
    val name: String,

    @NotBlank(message = "Email not informed")
    val email: String,

    @NotBlank(message = "Pix not informed")
    val pix: String

)