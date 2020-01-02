package com.github.rogerp91.common.util.test

import com.github.rogerp91.common.data.source.local.entity.ResultEntity

object ResultEntityTest {

    fun getStubResultEntity(): ResultEntity {
        return ResultEntity(
            541.169, 569, false,
            "/xBHvZcjRiWyobQ9kxBhO6B2dtRI.jpg", 419704,
            false, "/p3TCqUDoVsrIm8fHK9KOTfWnDjZ.jpg",
            "en", "Ad Astra", "Ad Astra", 6.0,
            "The near future", "2019-09-17"
        )
    }

    fun getStubResultEntity2(): ResultEntity {
        return ResultEntity(
            546.165, 600, true,
            "/xBHvZcjRiWyobQ9kxBhO6BdtwRI.jpg", 419707,
            false, "/p3TCqUDoerIm8fHK9KOTfWnDjZ.jpg",
            "en", "New Avenge", "New Avenger", 8.0,
            "The near future", "2019-09-10"
        )
    }

    fun getResultEntityEmpty(): ResultEntity {
        return ResultEntity(
            -1.0, -1, false,
            "", -1,
            false, "",
            "", "", "", -1.0,
            "", ""
        )
    }
}