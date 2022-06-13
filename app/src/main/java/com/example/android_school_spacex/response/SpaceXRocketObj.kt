package com.example.android_school_spacex.response

import com.example.android_school_spacex.network.Transformable
import com.example.android_school_spacex.data.*
import kotlinx.serialization.Serializable

@Serializable
data class SpaceXRocketObj(
    val id: String? = null,
    val active: Boolean? = null,
    val stages: Int? = null,
    val boosters: Int? = null,
    val costPerLaunch: Int? = null,
    val successRatePct: Int? = null,
    val firstFlight: String? = null,
    val country: String? = null,
    val company: String? = null,
    val heightObj: DimensionObj = DimensionObj(),
    val diameterObj: DimensionObj = DimensionObj(),
    val massObj: MassObj = MassObj(),
    val payloadWeightObjs: List<PayloadWeightsObj> = emptyList(),
    val firstStageObj: FirstStageObj = FirstStageObj(),
    val secondStageObj: SecondStageObj = SecondStageObj(),
    val enginesObj: EnginesObj = EnginesObj(),
    val landingLegsObj: LandingLegsObj = LandingLegsObj(),
    val wikipediaUrl: String? = null,
    val description: String? = null,
    val rocketId: String? = null,
    val rocketName: String? = null,
    val rocketType: String? = null
) : Transformable<SpaceXRocket> {

    override fun transform(): SpaceXRocket {
        return SpaceXRocket(
            id = id ?: "",
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