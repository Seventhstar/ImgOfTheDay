package com.seventhstar.imgoftheday.model

data class Wish(
    val id: Long,
    val name: String,
    val imageUrl: String,
    val description: String
)

fun getLocalWishes(): List<Wish> {
    return listOf(
        Wish(
            1,
            "Seiko Urushi",
            "https://cdn.shopify.com/s/files/1/0243/0993/products/S-SARX029_e_1400x.jpg?v=1625039541",
            ""
        ),

        Wish(
            2,
            "Oris Lake Baikal Limited Edition",
            "https://revolutionwatch.com/wp-content/uploads/2020/01/06-Oris-Asia.jpg",
            ""
        ),

        Wish(
            2,
            "Oris Sixty-Five (Oris Divers)",
            "https://www.haroldltd.ru/swiss_watch/big/Oris/733%207720%204055%20TS.jpg",
            ""
        ),

        Wish(
            3,
            "Yamaha a-s2100",
            "https://us.v-cdn.net/5021930/uploads/editor/f1/0wcrwta5kuxg.jpg",
            "Стрелочки"
        ),
        Wish(
            4,
            "Мотоцикл ",
            "https://synergosmoto.com/uploaded/dKGcF09fRB.jpg",
            ""
        ),
        Wish(
            5,
            "BMW X5",
            "https://www.bmw.ru/content/dam/bmw/marketRU/bmw_ru/all-models/x-series/x5/2019/highlights-obzor/bmw-x5-highlights-gallery-desktop-02.jpg",
            ""
        )
    )
}
