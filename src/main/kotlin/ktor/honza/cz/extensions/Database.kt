package ktor.honza.cz.extensions

import kotlinx.nosql.AbstractColumn
import kotlinx.nosql.AbstractSchema
import kotlinx.nosql.ColumnType
import java.util.*

fun <S : AbstractSchema> uuid(name: String): AbstractColumn<UUID, S, UUID> = AbstractColumn(name, UUID::class, ColumnType.STRING)
fun <S : AbstractSchema> S.uuid(name: String): AbstractColumn<UUID, S, UUID> = AbstractColumn(name, UUID::class, ColumnType.STRING)
