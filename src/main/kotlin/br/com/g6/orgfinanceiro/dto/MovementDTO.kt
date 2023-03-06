package br.com.g6.orgfinanceiro.dto

import br.com.g6.orgfinanceiro.model.Movement
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate
import java.util.*


data class MovementDTO (

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    var dueDateIni: LocalDate? = null,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    var dueDateEnd: LocalDate? = null,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    var dueDate: LocalDate? = null,

    var typeMovement: String? = null,
    var descriptionMovement: String? = null,
    var idUser: Long? = null,
    var valueMovementIni: Double? = null,
    var valueMovementEnd: Double? = null,
    var valueMovement: Double? = null,
    var seqParcel: Int? = null,
    var wasPaid: Boolean? = null,
    var idMovement: Long? = null
) {
    fun toEntity(): Movement {
        val movement = Movement()
        movement.idMovement = idMovement
        movement.descriptionMovement = descriptionMovement
        movement.typeMovement = typeMovement
        movement.valueMovement = valueMovement!!
        movement.wasPaid = wasPaid
        movement.seqParcel = seqParcel!!
        movement.dueDate = dueDate
        return movement
    }
}