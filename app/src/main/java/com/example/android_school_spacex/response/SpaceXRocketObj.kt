package com.example.android_school_spacex.response

import com.example.android_school_spacex.Transformable
import com.example.android_school_spacex.data.*
import com.google.gson.annotations.SerializedName

data class SpaceXRocketObj(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("active") val active: Boolean? = null,
    @SerializedName("stages") val stages: Int? = null,
    @SerializedName("boosters") val boosters: Int? = null,
    @SerializedName("cost_per_launch") val costPerLaunch: Int? = null,
    @SerializedName("success_rate_pct") val successRatePct: Int? = null,
    @SerializedName("first_flight") val firstFlight: String? = null,
    @SerializedName("country") val country: String? = null,
    @SerializedName("company") val company: String? = null,
    @SerializedName("height") val heightObj: DimensionObj = DimensionObj(),
    @SerializedName("diameter") val diameterObj: DimensionObj = DimensionObj(),
    @SerializedName("mass") val massObj: MassObj = MassObj(),
    @SerializedName("payload_weights") val payloadWeightObjs: List<PayloadWeightsObj> = emptyList(),
    @SerializedName("first_stage") val firstStageObj: FirstStageObj = FirstStageObj(),
    @SerializedName("second_stage") val secondStageObj: SecondStageObj = SecondStageObj(),
    @SerializedName("engines") val enginesObj: EnginesObj = EnginesObj(),
    @SerializedName("landing_legs") val landingLegsObj: LandingLegsObj = LandingLegsObj(),
    @SerializedName("wikipedia") val wikipediaUrl: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("rocket_id") val rocketId: String? = null,
    @SerializedName("rocket_name") val rocketName: String? = null,
    @SerializedName("rocket_type") val rocketType: String? = null
) : Transformable<SpaceXRocket> {

    override fun transform(): SpaceXRocket {
        return SpaceXRocket(
            id = id ?: -1,
            active = active ?: false,
            stages = stages ?: 0,
            boosters = boosters ?: 0,
            costPerLaunch = costPerLaunch ?: 0,
            successRatePct = successRatePct ?: 0,
            firstFlight = firstFlight ?: "",
            country = country ?: "",
            company = company ?: "",
            height = heightObj.transform(),
            diameter = diameterObj.transform(),
            mass = massObj.transform(),
            payloadWeights = payloadWeightObjs.map { it.transform() },
            firstStage = firstStageObj.transform(),
            secondStage = secondStageObj.transform(),
            engines = enginesObj.transform(),
            landingLegs = landingLegsObj.transform(),
            wikipediaUrl = wikipediaUrl ?: "",
            description = description ?: "",
            rocketId = rocketId ?: "",
            rocketName = rocketName ?: "",
            rocketType = rocketType ?: ""
        )
    }
}