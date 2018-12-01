package ir.hosseinabbasi.skyscanner.ui.flight

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import ir.hosseinabbasi.domain.common.ResultState
import ir.hosseinabbasi.domain.entity.Entity
import ir.hosseinabbasi.skyscanner.R
import ir.hosseinabbasi.skyscanner.common.extension.observe
import ir.hosseinabbasi.skyscanner.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_flights.*
import javax.inject.Inject

/**
 * Created by Dr.jacky on 11/5/2018.
 */
class FlightFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val adapter: FlightListAdapter by lazy {
        FlightListAdapter()
    }

    private val viewModel: FlightViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(FlightViewModel::class.java)
    }

    private fun showFlights(flights: ResultState<List<Entity.Flight>>) {
        when (flights) {
            is ResultState.Success -> {
                hideLoading()
                adapter.submitList(flights.data)
            }
            is ResultState.Error -> {
                hideLoading()
                Toast.makeText(activity, flights.throwable.message, Toast.LENGTH_SHORT).show()
                adapter.submitList(flights.data)
            }
            is ResultState.Loading -> {
                showLoading()
                adapter.submitList(flights.data)
            }
        }
    }

    private fun initView() {
        fragmentFlightsRcyMain.layoutManager = LinearLayoutManager(activity)
        fragmentFlightsRcyMain.setHasFixedSize(true)
        fragmentFlightsRcyMain.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(
        R.layout.fragment_flights, container, false
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observe(viewModel.flightLiveData(), ::showFlights)
    }
}