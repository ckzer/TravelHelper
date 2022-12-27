package com.example.travelproject

// 데이터베이스에 저장할
// 사용자 정보를 담을 모델 class
data class User(
    var name: String,
    var email: String,
    var uId: String
) {
    constructor(): this("", "", "")
}