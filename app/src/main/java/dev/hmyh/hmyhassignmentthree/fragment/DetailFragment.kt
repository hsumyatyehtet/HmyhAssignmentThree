package dev.hmyh.hmyhassignmentthree.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dev.hmyh.hmyhassignmentthree.R
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment: Fragment() {

    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var movieId = args.movieId

        setUpListener()
    }

    private fun setUpListener() {
        ivBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}