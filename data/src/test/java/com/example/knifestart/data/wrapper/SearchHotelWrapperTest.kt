package com.example.knifestart.data.wrapper

import com.example.knifestart.domain.entity.Hotel
import com.example.knifestart.domain.response.HotelResponse
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

/**
 * Created by glebkalinichenko on 02.01.18.
 */
class SearchHotelWrapperTest {
    var wrapper = SearchHotelNameWrapper()

    @Test
    fun testTransformHotelResponse() {
        var response = HotelResponse("Intourist")
        var hotel = wrapper.convertHotelReponse(response)

        assertThat(hotel, `is`(instanceOf(Hotel::class.java)))
        assertThat(hotel.name, `is`("Intourist"))
    }

    @Test
    fun testTransformHotelListResponse() {
        var mockHotelResponseOne = mock(HotelResponse::class.java)
        var mockHotelResponseTwo = mock(HotelResponse::class.java)

        `when`(mockHotelResponseOne.name).thenReturn("Intourist")
        `when`(mockHotelResponseTwo.name).thenReturn("Intourist")

        var listResponses = listOf<HotelResponse>(mockHotelResponseOne, mockHotelResponseTwo)
        var listHotels = wrapper.convertHotelsReponse(listResponses)

        assertThat(listHotels[0], `is`(instanceOf(Hotel::class.java)))
        assertThat(listHotels[1], `is`(instanceOf(Hotel::class.java)))
        assertThat(listHotels.size, `is`(2))
    }
}