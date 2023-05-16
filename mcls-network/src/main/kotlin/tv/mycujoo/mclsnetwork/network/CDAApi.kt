package tv.mycujoo.mclsnetwork.network

import retrofit2.http.Body
import retrofit2.http.POST
import tv.mycujoo.mclsnetwork.data.model.EventResponse
import tv.mycujoo.mclsnetwork.data.model.EventsSourceData
import tv.mycujoo.mclsnetwork.network.request.GetEventDetailsRequest
import tv.mycujoo.mclsnetwork.network.request.GetEventListRequest

interface CDAApi {

    @POST("mcls.cda.events.v1.EventsService/List")
    suspend fun getEvents(
        @Body eventListRequest: GetEventListRequest
    ): EventsSourceData

    @POST("mcls.cda.events.v1.EventsService/Get")
    suspend fun getEventDetails(
        @Body eventByIdRequest: GetEventDetailsRequest
    ): EventResponse
}