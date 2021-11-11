package dev.hmyh.hmyhassignmentthree

import android.app.Application
import android.content.Context
import dev.hmyh.hmyhassignmentthree.data.models.impl.HmyhAssignmentThreeModelImpl

class HmyhAssignmentThreeApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        application = applicationContext

        HmyhAssignmentThreeModelImpl.init(applicationContext)

    }

    companion object{
        const val TAG="HmyhAssignmentThreeApp"
        lateinit var application: Context
    }

}