package com.example.android_school_spacex.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_school_spacex.data.SpaceXRocket
import com.example.android_school_spacex.databinding.ItemControllerRocketBinding
import com.example.android_school_spacex.service.NotSpecifiedUtils.getImageAccordingToId
import com.example.android_school_spacex.service.StringUtils.getFormattedDateWithYear

class RocketsAdapter : RecyclerView.Adapter<RocketsAdapter.RocketViewHolder>() {

    private var rockets: List<SpaceXRocket> = emptyList()

    override fun getItemCount(): Int = rockets.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketViewHolder {
        val binding = ItemControllerRocketBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return RocketViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RocketViewHolder, position: Int) {
        val rocketData = rockets[position]

        holder.name.text = rocketData.rocketName
        holder.launchDate.text = rocketData.firstFlight.getFormattedDateWithYear()
        holder.image.setImageResource(rocketData.getImageAccordingToId())
    }

    fun update(data: List<SpaceXRocket>) {
        rockets = data
        notifyDataSetChanged()
    }

    inner class RocketViewHolder(
        binding: ItemControllerRocketBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        val name: TextView = binding.rocketNameTv
        val launchDate: TextView = binding.rocketLaunchDateTv
        val image: ImageView = binding.rocketIv
    }
}