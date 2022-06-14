package com.example.android_school_spacex.network.response

import com.example.android_school_spacex.data.SpaceXRocket
import com.example.android_school_spacex.network.Transformable
import kotlinx.serialization.Serializable

@Serializable
data class SpaceXRocketObj(
    val id: String? = null,
    val active: Boolean? = null,
    val stages: Int? = null,
    val boosters: Int? = null,
    val cost_per_launch: Int? = null,
    val success_rate_pct: Int? = null,
    val first_flight: String? = null,
    val country: String? = null,
    val company: String? = null,
    val height: DimensionObj = DimensionObj(),
    val diameter: DimensionObj = DimensionObj(),
    val mass: MassObj = MassObj(),
    val payload_weights: List<PayloadWeightsObj> = emptyList(),
    val first_stage: FirstStageObj = FirstStageObj(),
    val second_stage: SecondStageObj = SecondStageObj(),
    val engines: EnginesObj = EnginesObj(),
    val landing_legs: LandingLegsObj = LandingLegsObj(),
    val wikipedia: String? = null,
    val description: String? = null,
    val name: String? = null,
    val type: String? = null
) : Transformable<SpaceXRocket> {

    override fun transform(): SpaceXRocket {
        return SpaceXRocket(
            id = id ?: "",
            active = active ?: false,
            stages = stages ?: 0,
            boosters = boosters ?: 0,
            costPerLaunch = cost_per_launch ?: 0,
            successRatePct = success_rate_pct ?: 0,
            firstFlight = first_flight ?: "",
            country = country ?: "",
            company = company ?: "",
            height = height.transform(),
            diameter = diameter.transform(),
            mass = mass.transform(),
            payloadWeights = payload_weights.map { it.transform() },
            firstStage = first_stage.transform(),
            secondStage = second_stage.transform(),
            engines = engines.transform(),
            landingLegs = landing_legs.transform(),
            wikipediaUrl = wikipedia ?: "",
            description = description ?: "",
            rocketName = name ?: "",
            rocketType = type ?: ""
        )
    }
}