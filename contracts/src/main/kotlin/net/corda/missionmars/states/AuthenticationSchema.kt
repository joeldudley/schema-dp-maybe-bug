package net.corda.missionmars.states

import net.corda.v5.ledger.schemas.PersistentState
import net.corda.v5.persistence.MappedSchema
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

object AuthenticationSchema

object AuthenticationSchemaV1 : MappedSchema(
        schemaFamily = AuthenticationSchema.javaClass,
        version = 1,
        mappedTypes = listOf(AuthMappedType::class.java)
) {
    @Entity
    @Table(name = "AUTH")
    class AuthMappedType(
        @Column(name = "col")
        var col: String
    ) : PersistentState() {
        constructor(): this("test_string")
    }
}
