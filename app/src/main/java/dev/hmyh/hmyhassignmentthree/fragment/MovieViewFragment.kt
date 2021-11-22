package dev.hmyh.hmyhassignmentthree.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import dev.hmyh.hmyhassignmentthree.R
import kotlinx.android.synthetic.main.fragment_movie_view.*

class MovieViewFragment: BaseFragment() {

    private val args: MovieViewFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_view,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var movieKey = args.movieKey

        if (movieKey.isEmpty()){

        }
        else{
            setUpYoutubePlayerView(movieKey)
        }
    }

    private fun setUpYoutubePlayerView(movieKey: String) {
        youtubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener(){
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.cueVideo(movieKey,0F)
            }
        })
    }

}