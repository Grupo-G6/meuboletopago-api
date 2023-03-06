package br.com.g6.orgfinanceiro.services

import com.sun.mail.smtp.SMTPSendFailedException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service
import kotlin.jvm.Throws

@Service
class SpringMailService {
    @Autowired
    lateinit var emailSender: JavaMailSender;

    @Throws(SMTPSendFailedException::class)
    fun sendEmail(toEMail: String, subject: String, body: String){
        val message: SimpleMailMessage = SimpleMailMessage()
        message.run {
            setFrom("meu.boleto.pago.g6@gmail.com")
            setTo(toEMail)
            setText(body)
            setSubject(subject)
        }
        emailSender.send(message)

    }

    fun textoBoasVindas(nome: String) : String {
        val texto = "Olá, $nome,\n" +
                "\n" +
                "Bem-vinde ao Meu boleto pago: o app que vai te ajudar a colocar seus boletos em dia e fazer mais economia. \uD83D\uDCB0\uD83E\uDD70\uD83D\uDC9A\n" +
                "\n" +
                "Com o app você pode:\n" +
                "\n" +
                "- cadastrar despesas: coloque uma descrição curta e sugestiva, o valor e  a data de vencimento. Nós te lembraremos 24 horas antes, por email, para te garantir a tranquilidade de um boleto pago.\n" +
                "-cadastrar receitas: aqui você coloca seus rendimentos correntes, a data que eles caem na sua mão (conta, porquinho, o que for). \n" +
                "\n" +
                "Qual a importância disso tudo? \n" +
                "\n" +
                "Com as anotações em dia, você consegue ter uma previsibilidade do saldo mensal, planejar melhor seus gastos e não fazer dívidas.\n" +
                " Dá  até pra pensar naquela viagem de fim de ano. \uD83C\uDFD6️\n" +
                "\n" +
                "Então, vamos começar? \n" +
                "\n" +
                "Registrar a primeira movimentação é o passo inicial para um futuro próspero, com boletos em dia e organização financeira.\n" +
                "\n" +
                "Boa sorte, \uD83C\uDF40\n" +
                "\n" +
                "Meu Boleto Pago"
        return texto
    }

    fun textoRecuperacao(name: String, token: String? = "") : String {
        val texto = "Olá, $name,\n" +
                "\n" +
                "esqueceu a senha?\n" +
                "\n" +
                "Tudo certo! A gente já resolve isso. \uD83D\uDE43\n" +
                "\n" +
                "Siga os seguintes passos:\n" +
                "\n" +
                "1-Insira esse token  no campo em que for solicitado:\n" +
                "$token\n" +
                "2-Cadastre uma nova senha: recomendamos uma senha de 8 dígitos, que combine caracteres maiúsculos, minúsculos e números (não sequenciais). \n" +
                "3-Feito, senha resetada!\n" +
                "Pode esquecer a senha, mas os boletos você não esquece, o app te ajuda a lembrar \uD83E\uDDFE.\n" +
                "\n" +
                "Boa sorte,\uD83C\uDF40\n" +
                "\n" +
                "Meu Boleto Pago"
        return texto
    }

}