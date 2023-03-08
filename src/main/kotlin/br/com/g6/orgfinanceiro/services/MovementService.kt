package br.com.g6.orgfinanceiro.services

import br.com.g6.orgfinanceiro.dto.BalanceDTO
import br.com.g6.orgfinanceiro.dto.MovementDTO
import br.com.g6.orgfinanceiro.enumeration.TypeMovement
import br.com.g6.orgfinanceiro.repository.MovementRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MovementService {
    @Autowired
    lateinit var movementRepository: MovementRepository

    @Autowired
    lateinit var currentUserService: CurrentUserService


    fun getBalance(): BalanceDTO {
        val response = BalanceDTO()
        var user = currentUserService.getCurrentUser()

        // Credit
        val filter = MovementDTO()
        filter.typeMovement = "1"
        filter.idUser = user?.id

        var filterMovement = FilterMovementSpecification(filter)
        var listCredit = movementRepository.findAll(filterMovement)
        var totalCredit = 0.0

        for (credit in listCredit) {
            totalCredit += credit.valueMovement
        }
        response.setCredit(totalCredit)

        // Debt
        filter.typeMovement = "2"
        filter.idUser = user?.id

        filterMovement = FilterMovementSpecification(filter)
        var listDebt = movementRepository.findAll(filterMovement)
        var totalDebt = 0.0

        for (debt in listDebt) {
            totalDebt += debt.valueMovement
        }
        response.setDebt(totalDebt)

        // Saldo
        response.setBalance(totalCredit - totalDebt)

        return response
    }

}