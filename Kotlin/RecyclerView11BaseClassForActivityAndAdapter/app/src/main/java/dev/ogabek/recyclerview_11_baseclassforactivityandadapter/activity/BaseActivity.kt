package dev.ogabek.recyclerview_11_baseclassforactivityandadapter.activity

import androidx.appcompat.app.AppCompatActivity
import dev.ogabek.recyclerview_11_baseclassforactivityandadapter.model.Member
import dev.ogabek.recyclerview_11_baseclassforactivityandadapter.network.BaseServer

open class BaseActivity: AppCompatActivity(), BaseServer {

    protected fun getServer(): String {
        return if (BaseServer.IS_TESTER) {
            BaseServer.SERVER_DEVELOPMENT
        } else {
            BaseServer.SERVER_DEPLOYMENT
        }
    }

    protected fun prepareMemberList(): List<Member> {
        val members = ArrayList<Member>()
        for (i in 0..50) members.add(Member("Ogabek Matyakubov", "@OgabekDev"))
        return members
    }

}