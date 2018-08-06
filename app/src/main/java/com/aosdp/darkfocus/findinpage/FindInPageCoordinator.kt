package com.aosdp.darkfocus.findinpage

import android.arch.lifecycle.MutableLiveData
import com.aosdp.darkfocus.web.IFindListener

class FindInPageCoordinator : IFindListener {
    val matches = MutableLiveData<Pair<Int, Int>>()

    fun reset() = matches.postValue(Pair(0, 0))

    override fun onFindResultReceived(activeMatchOrdinal: Int, numberOfMatches: Int, isDoneCounting: Boolean) {
        matches.postValue(Pair(activeMatchOrdinal, numberOfMatches))
    }
}
