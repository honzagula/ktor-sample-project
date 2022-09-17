package ktor.honza.cz.mapper

import ktor.honza.cz.client.AuthorDetailClientResponse
import ktor.honza.cz.domain.Author
import ktor.honza.cz.model.response.AuthorResponse


fun AuthorDetailClientResponse.mapToDomain() = Author(
    id = id,
    firstName = firstName,
    middleName = middleName,
    lastName = lastName,
    country = country,
    birth = birth,
    description = description,
)

fun Author.mapToResponse() = AuthorResponse(
    id = id,
    fullName = middleName?.let { "$firstName $middleName $lastName" } ?: "$firstName $lastName",
    dateOfBirth = birth,
    country = country
)
