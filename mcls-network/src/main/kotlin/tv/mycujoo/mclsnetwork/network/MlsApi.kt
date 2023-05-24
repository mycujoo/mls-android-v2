package tv.mycujoo.mclsnetwork.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import tv.mycujoo.mclsnetwork.data.entity.ActionResponse

interface MlsApi {

    @GET("bff/timeline/v1beta1/{timeline_id}")
    suspend fun getActions(
        @Path("timeline_id") timelineId: String,
        @Query("update_id") updateId: String? = null
    ): ActionResponse
}