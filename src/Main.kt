import java.util.Scanner

fun main() {
    val input  = Scanner(System.`in`)
    var aniqla = false
    var oyna = """
        |  1 |  2 |  3 |
        |  4 |  5 |  6 |
        |  7 |  8 |  9 |
    """.trimIndent()
    val oxiri = """
        | ❌ | ⭕ | ❌ |
        | ⭕ | ❌ | ⭕ |
        | ❌ | ⭕ | ❌ |
    """.trimIndent()

    val victories = arrayOf("123","456","789","147","258","369","159","357")
    var x_steps =""
    var o_steps = ""
    while (true) {
        if (oyna==oxiri){
            println("O'yin durang bilan yakunlandi 🤝")
            break
        }else if (aniqla){
            break
        }
        while (true) {
            println(oyna)
            print("1-o'yinchi tanlagan xona: ")
            val first = input.nextInt()
            if (oyna.contains("$first")) {
                oyna = oyna.replace(" $first", "❌")
                x_steps+="$first"
                println(oyna)
                for (victory in victories) {
                    if (victory[0] in x_steps && victory[1] in x_steps && victory[2] in x_steps){
                        println("1-o'yinchi g'alaba qozondi")
                        aniqla=true
                        break
                    }
                }
                if (aniqla==true){
                    break
                }
                if (oyna==oxiri){
                    break
                }
                print("2-o'yinchi tanlagan xona: ")
                val second = input.nextInt()
                if (oyna.contains("$second")) {
                    oyna = oyna.replace(" $second", "⭕")
                    o_steps+="$second"
                    for (victory in victories) {
                        if (victory[0] in o_steps && victory[1] in o_steps && victory[2] in o_steps){
                            println(oyna)
                            println("2-o'yinchi g'alaba qozondi")
                            aniqla=true
                            break
                        }
                    }
                    if (aniqla==true){
                        break
                    }
                    break
                } else {
                    println("Bu xona band")
                }
            } else {
                println("Bu xona band")
            }
        }
    }

}
