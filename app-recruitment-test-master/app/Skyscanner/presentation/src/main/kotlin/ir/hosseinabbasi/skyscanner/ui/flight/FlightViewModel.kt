package ir.hosseinabbasi.skyscanner.ui.flight

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ir.hosseinabbasi.data.common.DateUtils
import ir.hosseinabbasi.domain.common.ResultState
import ir.hosseinabbasi.domain.entity.Entity
import ir.hosseinabbasi.domain.usecase.flight.GetFlightsUseCase
import ir.hosseinabbasi.skyscanner.BuildConfig
import ir.hosseinabbasi.skyscanner.common.OperationLiveData
import ir.hosseinabbasi.skyscanner.ui.base.BaseViewModel
import javax.inject.Inject

/**
 * Created by Dr.jacky on 11/5/2018.
 */
class FlightViewModel @Inject constructor(private val getFlightsUseCase: GetFlightsUseCase) : BaseViewModel() {

    private var flightLiveData = MutableLiveData<ResultState<List<Entity.Flight>>>()

    fun flightLiveData(): LiveData<ResultState<List<Entity.Flight>>> {

        flightLiveData = operationLiveData()
        return flightLiveData
    }

    private fun operationLiveData(): OperationLiveData<ResultState<List<Entity.Flight>>> {

        return OperationLiveData {
            getFlightsUseCase.createSession(
                DateUtils.getOutboundDate(),
                DateUtils.getInboundDate(),
                BuildConfig.API_KEY
            ).subscribe {
                it.response()?.headers()?.get("Location")?.let { locationHeader ->
                    getFlightsUseCase.getFlights(locationHeader).subscribe { it ->
                        postValue(it)
                    }.track()
                }
            }.track()
        }
    }
}