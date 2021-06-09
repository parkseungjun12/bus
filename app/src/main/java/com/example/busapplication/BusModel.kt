package com.example.busapplication

import java.io.Serializable

data class BusModel(val routeno: String, val arrprevstationcnt: String, val arrtime: Int) : Serializable {
    val routenoString: String
        get() = "차량 번호: $routeno"

    val arrprevstationcntString: String
        get() = "남은 구간: ${arrprevstationcnt}정류장"

    val arrtimeString: String
        get() {
            return if (arrtime < 0) {
                "남은 시간: 도착 정보 없음"
            }
            else if (arrtime == 0) {
                "남은 시간: 곧 도착"
            }
            else {
                "남은 시간: ${arrtime / 60}분 ${arrtime % 60}초"
            }
        }
}
