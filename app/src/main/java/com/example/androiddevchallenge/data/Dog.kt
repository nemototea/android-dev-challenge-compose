package com.example.androiddevchallenge.data

data class Dog(
    val id: Int,
    val name: String,
    val gender: Gender,
    val age: Int,
    val personalities: List<Personality>,
    val houseTrained: Boolean,
    val fee: Double,
    val health: String,
    val image: Int
)

enum class Gender {
    MALE,
    FEMALE
}

enum class Personality {
    SMART,
    FRIENDLY,
    AFFECTIONATE,
    GENTLE,
    PATIENT,
    CURIOUS,
    FEARLESS,

    STUPID,
    SHY,
    NAUGHTY,
    STUBBORN,
    ANXIOUS

//    ＜ポジティブな性格＞
//    affectionate（愛情深い）
//    patient（我慢強い）
//    curious（好奇心旺盛な）
//    fearless（怖いもの知らず）
//    ＜ネガティブな性格＞
//    naughty（やんちゃな）
//    stubborn（頑固な）
//    anxious（臆病な）
}
