package cl.admedios.searchml.ui.detail

import android.content.Context
import androidx.lifecycle.ViewModel
import cl.admedios.searchml.model.ResultData


class DetailViewModel : ViewModel() {

    var result: ResultData? = null


    fun getResultDataObserver(): ResultData? {
        return result
    }


}
