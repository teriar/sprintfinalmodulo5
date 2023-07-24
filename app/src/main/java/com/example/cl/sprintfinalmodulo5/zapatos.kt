package com.example.cl.sprintfinalmodulo5

class zapatos {
    fun returnShoeList(): List<zapato> {
        val shoeList = mutableListOf<zapato>()
        val shoeItem1 = zapato("Zapato 1", "https://zapatoscl.vtexassets.com/arquivos/ids/1019819-800-auto?v=638107220215670000&width=800&height=auto&aspect=true", 99.99)
        shoeList.add(shoeItem1)
        val shoeItem2 = zapato("Zapato 2", "https://cdn.guante.cl/20785-superlarge_default/zapato-guante-tennessee-cafe-0033226-1018259.jpg", 79.99)
        shoeList.add(shoeItem2)
        val shoeItem3 = zapato("Zapato 3", "https://toolmania.cl/14461-full_default/zapatos-de-seguridad-con-punta-de-acero-talla-43-total-tools-tsp201sb43.jpg", 149.99)
        shoeList.add(shoeItem3)
        val shoeItem4 = zapato("Zapato 4", "https://rockfordcl.vtexassets.com/arquivos/ids/542872-800-1000?v=638207147494430000&width=800&height=1000&aspect=true", 129.99)
        shoeList.add(shoeItem4)
        val shoeItem5 = zapato("Zapato 5", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRHI7_WWgYjZx-H_788kc0SMNVjeuLhzZ-KAw&usqp=CAU", 109.99)
        shoeList.add(shoeItem5)

        val shoeItem6 = zapato("Zapato 6", "https://e00-expansion.uecdn.es/assets/multimedia/imagenes/2022/11/23/16691993780157.jpg", 89.99)
        shoeList.add(shoeItem6)
        val shoeItem7 = zapato("Zapato 7", "https://http2.mlstatic.com/D_NQ_NP_787823-MLC53486635745_012023-O.webp", 199.99)
        shoeList.add(shoeItem7)
        val shoeItem8 = zapato("Zapato 8", "https://northstar.digitag.cl/48416-large_default/zapatilla-hombre-new-star.jpg", 169.99)
        shoeList.add(shoeItem8)
        val shoeItem9 = zapato("Zapato 9", "https://bubblegummers.digitag.cl/26143-home_default/zapatilla-nina-saturno.jpg", 119.99)
        shoeList.add(shoeItem9)
        val shoeItem10 = zapato("Zapato 10", "https://sparta.cl/media/catalog/product/z/a/zapatilla-basquetbol-hombre-nike-kyrie-flytrap-6-negra-derecha.png?quality=80&bg-color=255,255,255&fit=bounds&height=550&width=600&canvas=600:550", 149.99)
        shoeList.add(shoeItem10)
        return shoeList
    }
}

data class zapato(val nombre:String, val url:String,val precio:Double)
